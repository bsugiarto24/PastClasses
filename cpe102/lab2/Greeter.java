/**
 *Greeter
 *@author Bryan Sugiarto
 *@version Lab2
 */
 
 
 public class Greeter{
   
   private String x;
   
   public Greeter(String in){
      x = in;
   }
   
   public String greet(){
      return "Hello "+x;
   }
   
 }