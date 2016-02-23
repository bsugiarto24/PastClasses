import java.util.Comparator;

 /*
  * state Comparator
  *@author Bryan Sugiarto
  *@version lab14
  */
public class OrderState implements Comparator <Person> {

	private Comparator<Person> next;
	
	public OrderState(Comparator<Person> p) {
		next = p;
	}
	
	public OrderState() {
		next = null;
	}

	public int compare(Person a, Person b) {
		if(a.getState().compareTo(b.getState())==0){
			if(next!=null)
				return next.compare(a, b);
			else
				return 0;
		}else
			return a.getState().compareTo(b.getState());
	}

}
