import java.util.Iterator;

/**
 * List Iterator class
 * @author Bryan Sugiarto
 * @version program6
 */
public interface BasicListIterator<E> extends Iterator<E>{

	public boolean hasPrevious();
	public E previous();

}
