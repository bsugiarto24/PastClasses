import java.awt.Point;


public class Ellipse extends Shape {

	private double major,minor;
	private Point p;
	
	public Ellipse(double semiMajorAxis, double semiMinorAxis, 
			java.awt.Point position, java.awt.Color color, boolean filled){
		super(color,filled);
		major = semiMajorAxis;
		minor = semiMinorAxis;
		p = new Point(position);
	}

	public double getArea() {
		return (Math.PI*major*minor);
	}
	public double getSemiMajorAxis(){
		return major;
	}
	public double getSemiMinorAxis(){
		return minor;
	}
	public void setSemiMajorAxis(double m){
			major = m;
			if(major<minor){
				double t = minor;
				minor = major;
				major = t;
			}
	}
	public void setSemiMinorAxis(double m){
		minor = m;
		if(major<minor){
			double t = minor;
			minor = major;
			major = t;
		}
			
	}
	
	public boolean equals(Object o){
		if(o!=null)
			if(o.getClass()==this.getClass()&&
			((Ellipse)o).getSemiMajorAxis()==major&&
			((Ellipse)o).getSemiMinorAxis()==minor&&
			((Ellipse)o).getPosition().equals(getPosition())&&
			((Ellipse)o).getColor().equals(getColor())&&
			((Ellipse)o).getFilled()==getFilled())
				return true;
		return false;
	}

	public Point getPosition() {
		return new Point(p);
	}


	public void setPosition(Point position) {
		p = new Point(position);
	}
	public void move(Point delta) {
		p.x+=delta.x;
		p.y+=delta.y;
	}

}
