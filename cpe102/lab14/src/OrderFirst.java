import java.util.Comparator;

 /*
  * FirstName Comparator
  *@author Bryan Sugiarto
  *@version lab14
  */
public class OrderFirst implements Comparator <Person> {
	
	private Comparator<Person> next;
	
	public OrderFirst(Comparator<Person> p) {
		next = p;
	}
	public OrderFirst() {
		next = null;
	}
	public int compare(Person a, Person b){
		if(a.getFirst().compareTo(b.getFirst())==0){
			if(next!=null)
				return next.compare(a, b);
			else
				return 0;
		}else
			return a.getFirst().compareTo(b.getFirst());
	}

}
