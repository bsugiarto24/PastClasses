
public class Student extends Person{

	private double gpa;
	
	public Student(double gpa, String name, int legs){
		super(name,legs);
		this.gpa = gpa;
	}
	
	public boolean equals(Object o){
		if(super.equals(o))
			if(((Student)o).gpa==gpa)
				return true;
		return false;
	}
	
	public String toString(){
		return  super.toString()
				+" and a Student Object with a "+gpa+" gpa"; 
	}
	
}
