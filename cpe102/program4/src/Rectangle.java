import java.awt.*;

/**
 *Rectange class to represent 2d rectangles for canvas
 *@author Bryan Sugiarto
 *@version program4
 */
public class Rectangle extends ConvexPolygon{


	public Rectangle(int width, int height, java.awt.Point position, 
			java.awt.Color color, boolean filled){
		super(new Point[]{position,
					      new Point(position.x+width,position.y),
					      new Point(position.x+width,position.y+height),
					      new Point(position.x,position.y+height)}, color, filled);
	}
	
   public int getWidth() {
	   return (int) distance(getVertex(0),getVertex(1));
   }
   public void setWidth(int width) {
	   Point p = getVertex(0);
	   Point p2 = getVertex(3);
	   super.setVertex(2,new Point(p2.x+width,p2.y));
	   super.setVertex(1,new Point(p.x+width,p.y));
   }
   public void setHeight(int height){
	   Point p = getVertex(0);
	   Point p2 = getVertex(1);
	   super.setVertex(3,new Point(p.x,p.y+height));
	   super.setVertex(2,new Point(p2.x,p2.y+height));
   } 
   
   public int getHeight(){
	   return (int) distance(getVertex(0),getVertex(3));
   }
   
   public void setVertex(int index, java.awt.Point vertex) {
   		throw new UnsupportedOperationException();
   }
   
   private double distance(Point a, Point b){
	   return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
   }
   
   
}
