/**
  *InputParser
  *@author Bryan Sugiarto
  *@version Lab2
  */
 
import java.util.Scanner;

public class InputParser{
         
   public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);   
      System.out.print("Number of values to parse: ");
      int num = scanner.nextInt();
      System.out.print("Enter Values: ");
      int sum =0, c1=0 , c2 = 0, c3=0;
      double total=0;
      String combined = "";
     
      for(int i =0; i<num; i++){
         if(scanner.hasNextInt()){
            sum+= scanner.nextInt();
            c1++;
         }   
         else if(scanner.hasNextDouble()){
            total+= scanner.nextDouble();
            c2++;
         }
        else {
            combined+= scanner.next();
            c3++;
         }
      } 
      System.out.println("Ints: "+c1+" total: "+sum);
      System.out.println("Doubles: "+c2+" total: "+ total);
      System.out.println("Strings: "+c3+" combined: "+ combined);  
   }    
}