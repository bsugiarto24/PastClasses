import java.util.Iterator;
import java.util.LinkedList;


/*
 * Explore class
 * @author Bryan Sugiarto
 * @version lab11
 */
public class Explore {


	public static void main(String[] args) {
		LinkedList<String> s = new LinkedList<String>();
		LinkedList<Integer> i = new LinkedList<Integer>();
		s.add("S");
		s.add("t");
		s.add("r");
		s.add("ing");
		i.add(8);
		i.add(3);
		i.add(6);
		i.add(5);
		
		Iterator it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		for(Integer in: i){
			System.out.println(in);
		}
		
		Stack<String> stack = new Stack<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.pop());
        stack.push("D");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop()); 


	}
}
