import java.awt.*;
import java.util.ArrayList;

public class ConvexPolygon implements Shape {

	private Point[]v;
	private boolean fill;
	private Color c;
	

	public ConvexPolygon(java.awt.Point[] vertices, 
			java.awt.Color color, boolean filled){
		v = vertices;
		c = color;
		fill = filled;
	}
	
	public double getArea(){
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();
        double sum = 0;
        for(int i = 0; i<v.length-1; i++){
        	sum+=(v[i].x*v[i+1].y);
        	sum-=(v[i+1].x*v[i].y);
        }
        sum+=(v[v.length-1].x*v[0].y);
        sum-=(v[v.length-1].y*v[0].x);
		return sum/2;
    }
    public java.awt.Color getColor(){
       return c;
    }
    public Point getVertex(int index){
    	return v[index];
    }
    public void setVertex(int index, java.awt.Point vertex) {
    	v[index] = vertex;
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
      return v[0];
   }  
   public void setPosition(java.awt.Point position){
	   if (position ==null)
			  throw new IllegalArgumentException();
	   Point dif = new Point(position.x-v[0].x,position.y-v[0].y);
	   this.move(dif);
   }
   public void move(java.awt.Point delta){
      for(Point p :v){
    	  p.x+=delta.getX();
    	  p.y+=delta.getY();
      }
    		  
   }
   public boolean equals(Object o){
      if(o==null)
    	  return false;
      if(o.getClass()!=this.getClass()||
      !((ConvexPolygon)o).getColor().equals(c)||
      !((ConvexPolygon)o).getFilled()==fill)
    	  return false;
      if(v.length!=((ConvexPolygon)o).v.length)
    	  return false;
	  for(int i = 0; i<v.length; i++)
		  if(!v[i].equals(((ConvexPolygon)o).getVertex(i)))
  			 return false;
      		  
      return true;
   }
	 
}
