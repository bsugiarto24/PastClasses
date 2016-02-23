/*
 *Circle
 *@author Bryan Sugiarto
 *@version program3
 */
 
import java.awt.*;
 
public class Circle implements Shape{
   private double radius;
   private Point p;
   private boolean fill;
   private java.awt.Color c;
   
   public Circle(double radius, java.awt.Point position, 
                 java.awt.Color color, boolean filled){
      this.radius =radius;
      p = position;
      c = color;
      fill = filled;
   }
   
   public double getArea(){
      return Math.PI*radius*radius;
   }
   public java.awt.Color getColor(){
      return c;
   }
   public void setColor(java.awt.Color color){
	  if (color ==null)
		  throw new IllegalArgumentException();
      c = color;
   } 
   public boolean getFilled(){
      return fill;
   }   
   public void setFilled(boolean filled){
      fill = filled;
   }
   public java.awt.Point getPosition(){
      return p;
   }  
   public void setPosition(java.awt.Point position){
	   if (position ==null)
			  throw new IllegalArgumentException();
	   p  = position;
   }
   public void move(java.awt.Point delta){
      p.x+=delta.getX();
      p.y+=delta.getY();
   }
   public boolean equals(Object o){
      if(o!=null)
    	  if(o.getClass()==this.getClass()&&
          ((Circle)o).getRadius()==radius&&
          ((Circle)o).getPosition().equals(p)&&
          ((Circle)o).getColor().equals(c)&&
          ((Circle)o).getFilled()==fill)
          			 return true;
      return false;
   }
   public double getRadius(){
      return radius;
   }
   public void setRadius(double radius){
      this.radius = radius;
   }
   

}