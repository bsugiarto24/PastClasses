import java.awt.Point;


public class Triangle implements Shape {
	private Point a,b,c;
	private boolean fill;
	private java.awt.Color col;
	
	public Triangle(java.awt.Point a, 
					java.awt.Point b, 
					java.awt.Point c, 
					java.awt.Color color, 
					boolean filled){
		this.a = a;
		this.b = b;
		this.c = c;
		fill = filled;
		col = color;
	}
	
	public java.awt.Point getVertexA(){
		return a;
	}
	
	public void setVertexA(java.awt.Point point){
		if (point ==null)
			throw new IllegalArgumentException();
		a= point;
	}
	
	public java.awt.Point getVertexB(){
		return b;
	}
	
	public void setVertexB(java.awt.Point point){
		if (point ==null)
			throw new IllegalArgumentException();
		b = point;
	}
	
	public java.awt.Point getVertexC(){
		return c;
	}
	
	public void setVertexC(java.awt.Point point){
		if (point ==null)
			throw new IllegalArgumentException();
		c = point;
	}
	
	public double getArea(){
		double A = distance(a,b);
		double B = distance(b,c);
		double C = distance(c,a);
		double semi = (A+B+C)/2;
		return Math.sqrt(semi*(semi-A)*(semi-B)*(semi-C));
    }
	
	private double distance(Point a, Point b){
		return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
	}
	
    public java.awt.Color getColor(){ 
       return col;
    }
    public void setColor(java.awt.Color color){
 	  if (color ==null)
 		  throw new IllegalArgumentException();
       col = color;
    }  
    public boolean getFilled(){
       return fill;
    }   
    public void setFilled(boolean filled){
       fill = filled;
    }
    public java.awt.Point getPosition(){
       return a;
    }  
    public void setPosition(java.awt.Point position){
 	   if (position ==null) 
 		   throw new IllegalArgumentException();
	   Point dif = new Point(position.x-a.x,position.y-a.y);
	   this.move(dif);
    }
    public void move(java.awt.Point delta){
       a.x+=delta.getX();
       a.y+=delta.getY();
       b.x+=delta.getX();
       b.y+=delta.getY();
       c.x+=delta.getX();
       c.y+=delta.getY();
    }
    public boolean equals(Object o){
       if(o!=null)
    	   if(o.getClass()==this.getClass()&&
           ((Triangle)o).getVertexA().equals(a)&&
           ((Triangle)o).getVertexB().equals(b)&&
           ((Triangle)o).getVertexC().equals(c)&&
           ((Triangle)o).getColor().equals(col)&&
           ((Triangle)o).getFilled()==fill)
           			 return true;
       return false;
    }
	 
}