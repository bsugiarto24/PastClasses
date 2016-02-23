/*
 *Circle
 *@author Bryan Sugiarto
 *@version program3
 */
 
import java.awt.*;
 
public class Circle extends Ellipse{
   
   public Circle(double radius, java.awt.Point position, 
                 java.awt.Color color, boolean filled){
      super(radius,radius,position,color, filled);
   }
   public double getRadius(){
      return getSemiMinorAxis();
   }
   public void setRadius(double radius){
	   	if(radius<getSemiMajorAxis()){
	   		super.setSemiMinorAxis(radius);
	   		super.setSemiMajorAxis(radius);
	   	}else{
	   		super.setSemiMajorAxis(radius);
	   		super.setSemiMinorAxis(radius);
	   	}
	    
   }
   public void setSemiMajorAxis(double m){
	   setRadius(m);
   }
   public void setSemiMinorAxis(double m){
	   setRadius(m);
   }
   
  
}