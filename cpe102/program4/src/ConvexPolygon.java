import java.awt.*;
import java.util.ArrayList;

public class ConvexPolygon extends Shape {

	private Point[]v;
	

	public ConvexPolygon(java.awt.Point[] vertices, 
			java.awt.Color color, boolean filled){
		super(new Color(color.getRGB()),filled);
		v = new Point[vertices.length];
		for(int i = 0; i<vertices.length; i++)
			v[i]= new Point(vertices[i]);
	}
	
	public double getArea(){
        double sum = 0;
        for(int i = 0; i<v.length-1; i++){
        	sum+=(v[i].x*v[i+1].y);
        	sum-=(v[i+1].x*v[i].y);
        }
        sum+=(v[v.length-1].x*v[0].y);
        sum-=(v[v.length-1].y*v[0].x);
		return sum/2;
    }
   
    public Point getVertex(int index){
    	return new Point(v[index]);
    }
    public void setVertex(int index, java.awt.Point vertex) {
    	v[index] = new Point(vertex);
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
      !((ConvexPolygon)o).getColor().equals(getColor())||
      !((ConvexPolygon)o).getFilled()==getFilled())
    	  return false;
      if(v.length!=((ConvexPolygon)o).v.length)
    	  return false;
	  for(int i = 0; i<v.length; i++)
		  if(!v[i].equals(((ConvexPolygon)o).getVertex(i)))
  			 return false;
      		  
      return true;
   }

   public Point getPosition() {
	   return new Point(v[0]);
   }

	 
}
