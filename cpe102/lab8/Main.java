/*
 *Main Class
 *@author Bryan
 *@version lab8
 */
 
 import java.util.*;
 
 public class Main{
 
 
    public static void main (String args[]){     
       Scanner scan = new Scanner(System.in);
       while(true){
	       int in = scan.nextInt();  
	       Crap c = new Crap();
	       try{
	          c.run(in);
	       }catch(NullPointerException e){
	          System.out.println("null pointer exception");
	       }catch(ClassCastException e){
	          System.out.println("class cast exception");
	       }catch(IndexOutOfBoundsException e){
	          System.out.println("index out of bounds exception");
	       }catch(CheckedException e){
	           System.out.println("checked exception");
	       }catch(UncheckedException e){
	           System.out.println("unchecked exception");
	       }finally{
	          System.out.println("invalid choice");
	       }
	   } 
    }
}