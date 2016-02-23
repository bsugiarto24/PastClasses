//Bryan Sugiarto
//Theodore Tan

//Lab 7

#include <stdio.h>
#include <stdlib.h>

#define MAXMEM 32768		/* Define maximum memory space */
#define MAX_INST = 1000

typedef unsigned char BYTE;	/* Define unsigned characters as "bytes" */
typedef unsigned short LC3;	/* Define LC3 as a data type, a 16-bit unsigned int */

LC3 memory[MAXMEM];		/* A simulated LC3 memory, consisting of 32K 16-bit words */

/* The following utility function swaps bytes, handling the problem of "big-endian" LC3 object files,
	consisting of 16 bit entities.  The byte order is swapped here */

LC3 lc3_swap(LC3 x)		/* Argument is an LC3 unsigned 16-bit value */
{
	LC3 a,b;		/* temporary locations */

	a = x >> 8;		/* High byte moves low, clear 0's to left */
	b = x << 8;		/* Low byte moves high, clear 0's to right */
	return(a | b);		/* OR them together to get the byte-swapped result */
}

/* Prints the Registers*/
void print(LC3 registers[])
{
 	for(int i  = 0 ; i < 8; i++)
	{
		printf("Register %d: %d\n", i, registers[i]);
	}
}

/* converts 2's complement to signed int*/
int toSignedInt(unsigned int value, int bitLength)
{
    int signedValue = value;
    if (value >> (bitLength - 1))
        signedValue |= -1 << bitLength;
    return signedValue;
}

/*executes the program*/
void execute(LC3 registers[], LC3 org)
{

	printf("\n\n\nExecute\n");
	//set pc to org
	LC3 pc = org;
	
	//set psr
	LC3 psr = 0;
	int i = 0;
 	for(i = 0; i <= 10; i++)
	{
		//prints registers
		print(registers);
		
		//gets instruction
		LC3 ir = memory[pc];

		
		LC3 opcode,dest, offset,offset11,src1, offset6, src2, n, z, p, imm, immCheck,vect8,offset9;

		//3 bits after opcode
		dest = ir<<4;
		dest = dest>>13;

		//3 bits after opcode plus destintation
		src1 = ir<<7;
		src1 = src1>>13;

		//last 3 bits
		src2 = ir<<13;
		src2 = src2>>13;

		//first 4 bits
		opcode = ir>>12;

		//immediate Check
		immCheck = ir<<10;
		immCheck = immCheck>>15;

		//immediate
		imm = ir<<11;
		imm = imm>>11;

		imm = toSignedInt(imm,5);

		//6 bit offset
		offset6 = ir<<10;
		offset6 = offset6>>10;

		//9 bit offset
		offset = ir<<7;
		offset = offset>>7;

		//11 bit offset
		offset11 = ir<<5;
		offset11 = offset11>>5;

		//offset 9, bits 0 - 8
		offset9 = offset;

		//trapvect 8, bits 0 - 7
		vect8 = ir<<8;
		vect8 = vect8>>8;


		//NZP for branching
		n = ir<<4;
		n = n>>15;
		z = ir<<5;
		z = z>>15;
		p = ir<<6;
		p = p>>15;

		printf("opcode %04x\n",opcode);	  
		printf("command %04x\n", ir);
		
		/*SWITCH for executing program*/
		switch(opcode)
		{
			case 0: //branch based on psr! 
				printf("BRANCH NZP: %d,%d,%d PC-Offset: %d\n" ,n,z,p,offset);
				if(n==1)
				{
					//psr = 100 
					if(psr==4)
					{
						//sign extend offset and add to PC
						pc += (offset & 0x1FF) | ((offset & 0x100) ? 0xFE00 : 0);
					}
				}
				//repeat for psr = 010
				if(z==1)
				{
					//psr = 010
					if(psr==2)
					{
						pc += (offset & 0x1FF) | ((offset & 0x100) ? 0xFE00 : 0);
					}
				}

				if(p==1)
				{
					//psr = 001
					if(psr ==1)
					{
						pc += (offset & 0x1FF) | ((offset & 0x100) ? 0xFE00 : 0);
					}
				}
				break;

			case 1: //add 
				printf("ADD ");
				printf("Dest %d SRC1: %d ", dest, src1);
				if(immCheck == 0)
				{
					registers[dest] = registers[src1] + registers[src2];
					printf("SRC2: %d\n", src2);
				}
				else
				{
					registers[dest] = registers[src1] + imm;
					printf("Imm: %d\n", imm);
				}

				
				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 2: //LD       
				printf("LD");		
				printf(" Dest: %d PC-Offset: %d\n", dest,offset);
				LC3 PCinc = (offset & 0x1FF) | ((offset & 0x100) ? 0xFE00 : 0);
				registers[dest] = memory[pc+PCinc];
				pc++;
				break;

			case 3: //ST       
				printf("ST SRC: %d PC-Offset: %d\n",dest,offset);
				memory[pc+offset] = registers[dest];
				
				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 4: //jsr
				printf("JSR PC-Offset: %d\n", offset);
				registers[7] = pc+1;
				//s.ext offset11 + incremented pc
				pc = pc+1+((offset11 & 0x7FF) | ((offset11 & 0x400) ? 0xF800 : 0));
				break;

			case 5: //AND 
				printf("AND ");
				printf("Dest %d SRC1: %d ", dest, src1);
				if(immCheck == 0)
				{
					registers[dest] = registers[src1] & registers[src2];
					printf("SRC2: %d\n", src2);
				}
				else
				{
					registers[dest] = registers[src1] & imm;
					printf("Imm: %d\n", imm);
				}
				
				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 6: //LDR 
				printf("LDR Dest: %d Base: %d PC-Offset: %d\n", dest, src1, offset6);
				registers[dest] = memory[src1+((offset6 & 0x03F) | ((offset6 & 0x020)) ? 0xFFC0 : 0)];

				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 7: //STR 
				printf("STR Source: %d Base: %d PC-Offset: %d\n", dest, src1, offset6);
				memory[registers[src1]+offset6] = registers[dest];
				
				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 8: //RTI
				printf("RTI\n");
				pc++;
				break;

			case 9: //NOT
				printf("NOT - Destination: R%d, Source: R%d\n", dest, src1);
				registers[dest] = ~registers[src1];
				
				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 10: //LDI
				printf("LDI - Destination: R%d, PCOffset9: %d\n", dest, offset9);
				registers[dest] = memory[memory[pc+1 + ((offset9 & 0x1FF) | ((offset9 & 0x100)) ? 0xFE00 : 0)]];
				
				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 11: //STI
				printf("STI - Source: R%d, PCOffset9: %d\n", dest, offset9);
				memory[offset9] = registers[dest];
				
				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 12: //RET
				printf("RET\n\n");
				pc = registers[7];
				break;

			case 13: //reserved
				printf("ILLEGAL OPCODE\n");
				break;

			case 14: //LEA
				printf("LEA - Destination R:%d, PCOffset9: %d\n", dest, offset9);
				registers[dest] = pc + 1 + ((offset9 & 0x1FF) | ((offset9 & 0x100)) ? 0xFE00 : 0);
				
				/*assign psr*/
				if(registers[dest]>0)
				{
					psr = 1;
				}
				else if(registers[dest]==0)
				{
					psr = 2;
				}
				else if(registers[dest]<0)
				{
					psr = 4;
				}
				pc++;
				break;

			case 15: //Trap
				printf("TRAP - x%d\n", vect8);
				if(vect8 == 37) //x25
				{
					i = 100000;
					exit(0);
				}
				else if(vect8 == 32) //20 - input
				{
					char character = 0;
					scanf("%c", &character);
					registers[0] = character;
				}
				else if(vect8 == 34) //22- output a string
				{
					printf("%d",registers[memory[0]]);
				}
				else if(vect8 == 33) //21- input
				{
					printf("%d", memory[0]);
				}
				pc++;
				break;

			default:
				printf("Cannot Find Command\n");
				break;
		}
	}
}




/* This program gets the basic LC3 object file, swapping the bytes and printing the hex instruction or data value */

int main(int argc, char *argv[])
{
	FILE *fp;
	LC3 org;		/* Value specified in .obj file as starting (.org) address */
	LC3 ip;		/* ip = Instruction pointer - load address */
	LC3 lc3data;

	LC3 registers[8];
	for(int i  = 0 ; i < 8; i++)
	{
		registers[i] = 0;
	}

	size_t bc;		/* Byte count from read - for detecting End of File */

	if (argc < 2)
	{
		printf ("You have to at least enter a file name to dump.  Preferably, an LC3 object file\nof the form: boofar.obj\n");
		exit(98);	/* Fail with an error code */
	};

	fp = fopen(argv[1], "rb");		/* Open for 'read' in 'binary' mode, rb */
	if (fp != NULL)			/* Opened file ok? */
	{
		ip = 0;				/* Initialize instruction pointer */
		bc = fread (&org, 2, 1, fp);	/* read origin address */
		if (bc <=0)			/* End of file - already ? */
		{
			fclose(fp);			/* ok, already, close the file */
			exit (97);			/* and exit with a code */
		};

	org = lc3_swap(org);		/* swap bytes because of big-endian LC3 nature */
	ip = org;			/* Get "org" address as IP value  */
	printf ("Setting ORG to %04X\n", org);	/* debug information */

	/*	Now read the rest of the object file into "memory" as long as it is within MAXMEM limits,
	incrementing ip for each new LC3 word of memory */

	for (int i = 0; i < MAXMEM; i++)			/* Repeat "forever", that is, until we do a "break" */
	{
		bc = fread (&lc3data, 2, 1, fp);	/* read an LC word */
		if (bc <= 0) break;			/* exit loop on end-of-file */

		if (ip >= MAXMEM)		/* Make sure ip isn't exceeding size of memory array */
		{
			printf ("Maximum memory address exceeded. Ending.\n");
			fclose(fp);
			exit(96);
		};
		//memory[ip] = lc3_swap(lc3data);	/* Store byte-swapped data in memory array */
		memory[ip] = lc3_swap(lc3data);
		//printf ("Loaded at Loc %04X : %04X\n", ip, memory[ip]); /* Debug information */

		LC3 opcode, ir,dest, offset,offset11,src1, offset6, src2, n, z, p, imm, immCheck,vect8,offset9;
		ir = lc3_swap(memory[ip]);

		//3 bits after opcode
		dest = ir<<4;
		dest = dest>>13;

		//3 bits after opcode plus destintation
		src1 = ir<<7;
		src1 = src1>>13;

		//last 3 bits
		src2 = ir<<13;
		src2 = src2>>13;

		//first 4 bits
		opcode = ir>>12;

		//immediate Check
		immCheck = ir<<10;
		immCheck = immCheck>>15;

		//immediate
		imm = ir<<11;
		imm = imm>>11;

		if(imm>8)
			imm-=17;

		//6 bit offset
		offset6 = ir<<10;
		offset6 = offset6>>10;

		//9 bit offset
		offset = ir<<7;
		offset = offset>>7;

		//11 bit offset
		offset11 = ir<<5;
		offset11 = offset11>>5;


		//offset 9, bits 0 - 8
		offset9 = offset;

		//trapvect 8, bits 0 - 7
		vect8 = ir<<8;
		vect8 = vect8>>8;

		//NZP for branching
		n = ir<<4;
		n = n>>15;
		z = ir<<5;
		z = z>>15;
		p = ir<<6;
		p = p>>15;

		printf("opcode %04x\n",opcode);	  
		printf("command %04x\n", ir);
		switch(opcode)
		{
			case 0: //branch 
				printf("BRANCH NZP: %d,%d,%d PC-Offset: %d\n" ,n,z,p,offset);
				break;

			case 1: //add 
				printf("ADD ");
				printf("Dest %d SRC1: %d ", dest, src1);
				if(immCheck == 0)
				{
					printf("SRC2: %d\n", src2);
				}
				else
				{
					printf("Imm: %d\n", imm);
				}
				break;

			case 2: //LD       
				printf("LD");		
				printf(" Dest: %d PC-Offset: %d\n", dest,offset);
				break;

			case 3: //ST       
				printf("ST SRC: %d PC-Offset: %d\n",dest,offset);
				
				break;

			case 4: //jsr
				printf("JSR PC-Offset: %d\n", offset);
				break;

			case 5: //AND 
				printf("AND ");
				printf("Dest %d SRC1: %d ", dest, src1);
				if(immCheck == 0)
				{
					printf("SRC2: %d\n", src2);
				}
				else
				{
					printf("Imm: %d\n", imm);
				}
				break;

			case 6: //LDR 
				printf("LDR Dest: %d Base: %d PC-Offset: %d\n", dest, src1, offset6);
				break;

			case 7: //STR 
				printf("STR Source: %d Base: %d PC-Offset: %d\n", dest, src1, offset6);
				break;

			case 8: //RTI
				printf("RTI\n");
				break;

			case 9: //NOT
				printf("NOT - Destination: R%d, Source: R%d\n", dest, src1);
				break;

			case 10: //LDI
				printf("LDI - Destination: R%d, PCOffset9: %d\n", dest, offset9);
				break;

			case 11: //STI
				printf("STI - Source: R%d, PCOffset9: %d\n", dest, offset9);
				break;

			case 12: //RET
				printf("RET\n\n");
				break;

			case 13: //reserved
				printf("ILLEGAL OPCODE\n");
				break;
	
			case 14: //LEA
				printf("LEA - Destination R:%d, PCOffset9: %d\n", dest, offset9);
				break;

			case 15: //Trap
				printf("TRAP - x%d\n", vect8);
				if(vect8 == 37) //x25
				{
					i = MAXMEM;
					//exit(0);
				}
				else if(vect8 == 32) //20 - input
				{
				
				}
				else if(vect8 == 34) //22- output a string
				{
					printf("%d",registers[memory[0]]);
				}
				else if(vect8 == 33) //21- input
				{
					printf("%d", memory[0]);
				}
				break;

			default:
				printf("Cannot Find Command\n");
				break;
		}
		ip++;					/* Increment memory pointer */
	};
		fclose(fp);
	}
	else
	{
		printf ("I'm sorry, be we couldn't find the file you are trying to use.\n");
	};


	print(registers);
	execute(registers,org);
	exit(0);
}
