
public class Animal {

	private int legs;
	
	public Animal(int legs){
		this.legs = legs;
	}
	
	public boolean equals(Object o){
		if(o!=null)
			if(o.getClass()==(this.getClass()))
				if(((Animal)o).legs==legs)
					return true;
		return false;
	}
	
	public String toString(){
		return  "I am an Animal object with "+legs+" legs"; 
	}

}
