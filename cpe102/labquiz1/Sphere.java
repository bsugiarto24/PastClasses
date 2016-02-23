/**
  *@author Bryan Sugiarto
  *@version Lab Quiz 1
  */
  
public class Sphere{
  
   private double radius;
     
   public Sphere(){
      radius = 1;
   }
     
   public Sphere(double r){
      if (r<=0){
         throw new IllegalArgumentException(
            "Invalid Input");
      }
      radius = r;
   }
     
   public double getRadius(){
      return radius; 
   }  
     
   public void setRadius(double r){
      if (r<=0){
         throw new IllegalArgumentException(
            "Invalid Input");
      }
      radius = r;
   }
     
   public double getSurfaceArea(){
      return Math.PI*4.0*radius*radius;
   }
     
   public double getVolume(){
      return Math.PI*4.0*Math.pow(radius,3)/3.0;
   }
     
   public boolean equals(Object o){
      if(o==null)
         return false;
      else if(o instanceof Sphere)
         if(((Sphere)o).getRadius() == radius)
            return true;
      return false;
   }
     
   public String toString(){
      return "The Spehre class is mutable!";
   }
     
}