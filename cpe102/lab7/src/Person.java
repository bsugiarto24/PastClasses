
public class Person extends Animal{

	private String name;
	
	public Person(String name, int legs){
		super(legs);
		this.name = name;
	}
	
	public boolean equals(Object o){
		if(super.equals(o))
			if(((Person)o).name.equals(name))
				return true;
		return false;
	}
	
	public String toString(){
		return  super.toString()
				+" and a Person object whose name is "+name; 
	}


}
