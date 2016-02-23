import java.util.LinkedList;

/*
 * Stack class
 * @author Bryan Sugiarto
 * @version lab11
 */

public class Stack <E>{
	private LinkedList<E> l;
	
	public Stack(){
		l  = new LinkedList<E>();
	}

	public void push(E in){
		l.add(in);
	}
	
	public E pop(){
		return l.removeLast();
	}

}
