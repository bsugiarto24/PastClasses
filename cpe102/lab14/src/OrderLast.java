import java.util.Comparator;

 /*
  * LastName Comparator
  *@author Bryan Sugiarto
  *@version lab14
  */
public class OrderLast implements Comparator <Person> {

	private Comparator<Person> next;
	
	public OrderLast(Comparator<Person> p) {
		next = p;
	}
	public OrderLast() {
		next = null;
	}

	public int compare(Person a, Person b) {
		if(a.getLast().compareTo(b.getLast())==0){
			if(next!=null)
				return next.compare(a, b);
			else
				return 0;
		}else
			return a.getLast().compareTo(b.getLast());
	}

}
