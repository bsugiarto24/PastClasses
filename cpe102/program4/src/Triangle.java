
import java.awt.Point;

/**
 *Triangle class to represent 2d triangles for canvas
 *@author Bryan Sugiarto
 *@version program4
 */
public class Triangle extends ConvexPolygon {
	
	public Triangle(java.awt.Point a, 
					java.awt.Point b, 
					java.awt.Point c, 
					java.awt.Color color, 
					boolean filled){
		super(new Point[]{a,b,c},color, filled);
	}
	
	public java.awt.Point getVertexA(){
		return super.getVertex(0);
	}
	
	public void setVertexA(java.awt.Point point){
		if (point ==null)
			throw new IllegalArgumentException();
		super.setVertex(0, point);
	}
	
	public java.awt.Point getVertexB(){
		return super.getVertex(1);
	}
	
	public void setVertexB(java.awt.Point point){
		if (point ==null)
			throw new IllegalArgumentException();
		super.setVertex(1, point);
	}
	
	public java.awt.Point getVertexC(){
		return super.getVertex(2);
	}
	
	public void setVertexC(java.awt.Point point){
		if (point ==null)
			throw new IllegalArgumentException();
		super.setVertex(2, point);
	}
	
	public double getArea(){
		double A = distance(getVertex(0),getVertex(1));
		double B = distance(getVertex(1),getVertex(2));
		double C = distance(getVertex(2),getVertex(0));
		double semi = (A+B+C)/2;
		return Math.sqrt(semi*(semi-A)*(semi-B)*(semi-C));
    }
	
	private double distance(Point a, Point b){
		return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
	}
	
}
