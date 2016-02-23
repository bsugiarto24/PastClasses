import java.util.Comparator;

 /*
  * age Comparator
  *@author Bryan Sugiarto
  *@version lab14
  */
public class OrderAge implements Comparator <Person> {

	private Comparator<Person> next;
	
	public OrderAge(Comparator<Person> p) {
		next = p;
	}
	public OrderAge() {
		next = null;
	}
	
	public int compare(Person a, Person b) {
		if(a.getAge()==b.getAge()){
			if(next!=null)
				return next.compare(a, b);
			else
				return 0;
		}else
			return a.getAge()-b.getAge();
	}

}
