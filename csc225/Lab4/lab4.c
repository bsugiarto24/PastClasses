/*----------------------------------------------------------------------*
 *	Cal Poly CSC 225-03 Fall, 2014 Dr. Dave Retz			*
 *									*
 *	This is code done in 'c', and is an example of implementation	*
 *	for the LC-3 Lab.  This is intended to be "pseudo-code", but	*
 *	I compiled it to check for spelling errors, etc.  Perhaps this	*
 *	will help you design your assembler version for the LC-3.	*
 *									*
 *	This is assistance information for Lab 4 - linked lists and	*
 *	pointers.  It is implemented on a 64-bit Intel machine under	*
 *	Linux in the Lab for 225.  In this machine, pointers are 64 bits*
 *	long, while on the LC-3, pointers are only 16 bits long.	*
 *	Consequently, this defines a datatype of "LC3", which would be	*
 *	a 16 bit value on the LC-3, but is a 64 bit value on the	*
 * 	Intel platform so the pointers will fit inside a "word".	*
 *----------------------------------------------------------------------*/

typedef unsigned long int LC3;	/* Define "LC3" as a long integer of 64 bits */
				/* so it's big enough to hold a pointer */
				/* on the Intel 64-bit machines */

#define TOTAL_COUNT 20		/* This is the total count of buffers */
#define SIZE 16			/* This is the buffer size, in words */

/* Note - we define items of type "short unsigned int", because this mimics
	the LC-3 memory space of 16 bits. Now C can store pointers in words like
	the LC-3 can ... because they're 64 bits, and all the LC3 "words" are
	64 bits also.  */

/*	First, let's define the data areas and global variables  */


struct _pool
	 {
	 LC3 *free;	/* Pointer to first free buffer in pool, or 0 */
	 int n;		/* Number of buffers in the pool */
	 int size;	/* Size of buffers in the pool */
	 };
struct _pool pool1;	/* Allocate a pool description named "pool1" */

/* First, define the structure for a "queue" consisting of a head and a tail pointer */

  struct _queue { LC3 *head; LC3 *tail; };	/* LC3 pointers head and tail */

/* Now actually create (allocate in storage) a queue named "queue", a structure defined above. */

  struct _queue queue;		  // allocate a queue (head tail)

/* reserve a memory area that we can use for a buffer pool of LC3 buffers */
LC3 poolarea[SIZE * TOTAL_COUNT];	/* An array of "LC3" integers, named poolarea */


/*	Get definitions for system libraries for printf, etc.  */

#include "stdio.h"
#include "stdlib.h"
#include "string.h"


/*	Now define functions for manipulating buffers and queues */

/*----------------------------------------------------------------------*
 *	initpool - Initialize a buffer pool with N buffers of M words	*
 *									*
 *	Assumes: A pointer to a buffer pool, defined as a structure	*
 *		named "_pool".						*
 *		Also, defined values TOTAL_COUNT and SIZE.		*
 *	Returns: nothing  (void)					*
 *----------------------------------------------------------------------*/

  void initpool(struct _pool *poolptr)
    {
    LC3 *itempointer, *nextpointer;
    int count;			/* ... just a simple integer counter for the loop */

    poolptr->free = &poolarea[0];	/* Set the beginning address of pool storage area */

/* Now setup links to all the buffers in the pool, with the last one 0 */

    itempointer = poolptr->free;	/* point to first (address of beginning of area) */

/* Loop for the N-1 entries, setting up each one with a link to the next ... */

   for (count = TOTAL_COUNT-1; count>0; count--)
       {
       nextpointer = itempointer + SIZE; 	/* Pointer to next one is SIZE words more */
       *itempointer = (LC3) nextpointer;	/* and now advance the pointer to the next buffer */
       itempointer = nextpointer;		/* Advance to next in list */
       };

// Now clear the link from the last one:

   *itempointer = (LC3) NULL;		// store a zero as the link from the last buffer in the list

   }				// and we're done !


/*----------------------------------------------------------------------*
 *	getbuffer - Obtains a free buffer from a pool.			*
 *									*
 *	Assumes: pool pointer.  A "pool" is simply a pointer to the	*
 *		first available buffer.					*
 *	Returns: a pointer to an LC3 buffer, or 0 (NULL).		*
 *----------------------------------------------------------------------*/

LC3 * getbuffer (struct _pool *poolptr)	/* poolptr is a pointer to a list of pointers */

  {
  LC3 *newbuffer;		/* A pointer to an LC3 buffer */

  newbuffer = poolptr->free;		/* get pointer to first free buffer */
  if (newbuffer)			/* got one ok ? */
      {
      poolptr->free = (LC3 *) *newbuffer;  /* advance the link to be the new head of list */
      return (newbuffer);		// return pointer to buffer
      }
   else
      return (LC3 *) NULL;		// sorry, charlie tuna - no buffer!
   }


/*----------------------------------------------------------------------*
 *	freebuffer - Frees a buffer back to a pool.			*
 *									*
 *	Assumes: pool pointer, buffer pointer.				*
 *	Returns: nothing (void).					*
 *----------------------------------------------------------------------*/

void freebuffer (struct _pool *poolptr, LC3 *buffer)

   {
   *buffer = (LC3) poolptr->free;    /* store current head of list as link from buffer being freed */
   poolptr->free = (LC3 *) buffer;   /* store buffer as new head of free list.  */
   }

/*----------------------------------------------------------------------*
 *	enqueue - Adds a buffer entry to a queue.			*
 *									*
 *	Assumes: queue (head/tail) pointer, buffer pointer.		*
 *	Returns: nothing (void).					*
 *----------------------------------------------------------------------*/

void enqueue(struct _queue *qp, LC3 *buffer)
  {
  LC3 *qpoldtail;		/* Pointer to old tail, if there was one */

  if (qp->head == NULL)		/* Is queue empty? */
       qp->head = buffer;	/* yes, store new buffer at head of queue */
  else
	{
	qpoldtail = qp->tail;	/* Get current (soon to be previous) tail */
	* (LC3 **) qpoldtail = buffer;	/* Store link to new from previous tail */
	};

  qp->tail = buffer;		/* set new tail pointer as the buffer we're adding */
  *buffer = (LC3) NULL;		/* store 0 (NULL) link from last buffer (new one in queue) */
   
  }


/*----------------------------------------------------------------------*
 *	dequeue - Obtain an entry from a queue				*
 *									*
 *	Assumes: queue (head/tail) pointer, buffer pointer.		*
 *	Returns: pointer to a buffer, or 0 (NULL) if none on queue.	*
 *----------------------------------------------------------------------*/

LC3 * dequeue (struct _queue *qp)	// remove an entry from queue
    {
    LC3 *buffer;		// returns pointer to buffer

    if (qp->head)    /* is the head value non-zero (i.e., there is something on the queue) ? */
       {
       buffer = qp->head;
       qp->head = (LC3 *) *buffer;	// update head as now pointing to next in the list
       return(buffer);
       }
    else
       return(0);			// return 0 if nothing on the list
    }


/*----------------------------------------------------------------------*
 *	And now Beavis: the test suite!					*
 *									*
 *	main calls initpool, then gets a few buffers, then enqueues	*
 *	them, then dequeues them and frees them back to the pool.	*
 *	Finally, it gets a couple buffers and puts a message in them,	*
 *	then it puts them on a queue, then it dequeues them and prints	*
 *	the contents of the payload.					*
 *----------------------------------------------------------------------*/

int main()
	{
	LC3 *bp;		/* Buffer pointer */
	LC3 *bp1;		/* and another ... */
	LC3 *bp2;		/* ... and another */

	char *payloadp;		/* pointer to payload area */


	printf("Initializing a pool of LC3 buffers ...\n");
	initpool(&pool1);
	printf("Ok, pool initialized.\n");  

	queue.head = 0; queue.tail = 0;		/* Make sure queue is zeros to start */

/*	ok, now the test code ... */

	printf("About to get a buffer.\n");
	bp = getbuffer(&pool1);			/* get a buffer from the pool */
	if (bp)
	  printf("Got buffer, it's pointer is: %p\n", bp);
	else
	  {
	  printf("Sorry ... getbuffer failed.\n");
	  exit(1);
	  };

	enqueue(&queue, bp);			/* Add buffer to queue */

	printf("Buffer added ok to queue.\n");

/*	Now get buffer from queue */

	bp2 = dequeue(&queue);
	if (bp2)
	  {
	  printf("Got a buffer from the queue, it's pointer is: %p\n", bp2);
	  printf("Releasing the buffer back to the pool.\n");
	  freebuffer(&pool1, bp2);
	  }

        else
          printf("oh my, no buffer on the queue. Sorry.\n");

/*	Ok, now get two buffers, put a payload in them, then put them on the queue.
	Then dequeue them and print them out, releasing each one back to the free pool.
*/

	bp1 = getbuffer(&pool1);	/* get buffer 1 */
	printf("Got 1st buffer, pointer=%p\n", bp1);

	printf("Got another free buffer, %p\n", bp1);
	payloadp = ((char *) bp1) + sizeof(LC3 *); /* pointer to data, past pointer */
	printf("Storing object, bp1=%p, payloadp=%p\n", bp1, payloadp);

	strcpy (payloadp, "One small step for man.");

	printf("Placing it on the queue ...\n");
	enqueue (&queue, bp1);

	printf("Getting one more ...\n");
	bp1 = getbuffer(&pool1);	/* get another one, using the same pointer variable */

	payloadp = ((char *) bp1) + sizeof(LC3 *); /* pointer to data, past pointer */
	printf("Storing object, bp1=%p, payloadp=%p\n", bp1, payloadp);

	strcpy (payloadp, "One giant step for mankind.");
	enqueue (&queue, bp1);

/* ok, now dequeue them and print them out.  */

	while (bp2 = dequeue(&queue))	/* Get everything on the queue and print and free them */
	  {
	  printf("Dequeued one. pointer %p\n", bp2); // debug dork
	  payloadp = ((char *) bp2) + sizeof(LC3 *); /* get pointer to data area, past LC3 pointer */
	  printf("Buffer payload: %s\n", payloadp);
	  freebuffer(&pool1, bp2);		/* Put buffer back in free pool */
	  }; 

	printf("Hey, we're done here!\n\n");

 	}




