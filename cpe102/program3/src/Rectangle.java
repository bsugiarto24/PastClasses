import java.awt.Color;
import java.awt.Point;


import java.awt.*;

public class Rectangle implements Shape{

	private int w, h;
	private Point p;
	private Color c;
	private boolean fill;
	
	public Rectangle(int width, int height, java.awt.Point position, 
			java.awt.Color color, boolean filled){
		w = width;
		h = height;
		p = position;
		c = color;
		fill = filled;
	}
	
    public double getArea(){
    	return w*h;	
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
	
   public int getWidth() {
	   return w;
   }
   public void setWidth(int width) {
	   w = width;
   }
   public int getHeight(){
	   return h;
   }
   public void setHeight(int height){
	   h = height;
   } 
   
    public boolean equals(Object o){
       if(o!=null)
          if(o.getClass()==this.getClass()&&
            ((Rectangle)o).getHeight()==h&&
            ((Rectangle)o).getWidth()==w&&
            ((Rectangle)o).getPosition().equals(p)&&
            ((Rectangle)o).getColor().equals(c)&&
            ((Rectangle)o).getFilled()==fill)
            			 return true;
       return false;
   }
   
}
