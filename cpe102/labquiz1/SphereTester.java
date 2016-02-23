/**
  *@author Bryan Sugiarto
  *@version Lab Quiz 1 Tester
  */
  
  
  
  public class SphereTester{
  
     public static void main(String[]args){
        Sphere r = new Sphere(3.23234);
        Sphere t = new Sphere(4);
        System.out.println(r);
        System.out.println("radius: "+r.getRadius());
        r.setRadius(1/Math.sqrt(Math.PI));
        System.out.println("radius: "+r.getRadius());
        System.out.println("area: "+r.getSurfaceArea());
        r.setRadius(1/Math.pow(Math.PI,1.0/3));
        System.out.println("volume: "+r.getVolume());
        System.out.println(t.equals(r));
     
     }
  
  
  
  }