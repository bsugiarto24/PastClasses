import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * BasicLinkedList class
 * @author Bryan Sugiarto
 * @version program6
 */
public class BasicLinkedList<E> implements BasicList<E>, Iterable<E>{

   private class Node{
		public E data;
		public Node next,prev;
	}
   
   private Node head;
   private int size;
	
   private class MyIt implements BasicListIterator<E>{
	   
	   private Node cursor = head;
	   
	   public boolean hasNext(){
		   if(cursor.next!=head)
			   return true;
		   return false;
	   }
	   public E next(){
		   if(hasNext())
			   cursor = cursor.next;
		   else 
			   throw new NoSuchElementException();
		   return cursor.data;   
	   }
	   public void remove() {
		   throw new UnsupportedOperationException();
	   }
	   public boolean hasPrevious() {
		   if(cursor==head)
			   return false;
		   return true;
	   }
	   public E previous() {
		   if(hasPrevious())
			   cursor = cursor.prev;
		   else 
			   throw new NoSuchElementException();
		   return cursor.next.data;
	   }
   }

	public BasicLinkedList(){
      head = new Node();
      head.next  = head;
      head.prev = head;
      size = 0;
   }
   
	public Iterator<E> iterator() {
		return (Iterator<E>)new MyIt();
	}
	
	public BasicListIterator<E> basicListIterator(){
		return new MyIt();
	}
	
	public void add(E element) {
	  size++;
      Node n = new Node();
      n.data = element;
  
      n.prev = head.prev;
      n.next = head;
      n.prev.next = n;
      head.prev =n;
	}

	public void add(int index, E element) {
		if(index<0||index>size)
			throw new IndexOutOfBoundsException();
		if(size==index){
			add(element);
		}else{
			size++;
			Node cursor = head;
			for(int i=0; i<index; i++){
				cursor = cursor.next;
			}
			Node n = new Node();
		    n.data = element;
		  
		    n.prev = cursor;
		    n.next = cursor.next;
		    cursor.next = n;
		    n.next.prev =n;
		}
	}

	public void clear() {
		head = new Node();
	    head.next  = head;
	    head.prev = head;
	    size = 0;
	}

	public boolean contains(E element) {
		Node n = head.next;
		for(int i=0; i<size; i++){
			if(n.data== null&&element==null||n.data.equals(element))
				return true;
			n = n.next;
		}
		return false;
	}

	public E get(int index) throws IndexOutOfBoundsException {
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		Node n = head;
		for(int i=0; i<=index; i++){
			n = n.next;
		}
		return n.data;
	}

	public int indexOf(E element) {
		Node n = head.next;
		for(int i=0; i<size; i++){
			if(n.data== null&&element==null||n.data.equals(element))
				return i;
			n = n.next;
		}
		throw new NoSuchElementException();
	}

	public E remove(int index) {
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		size--;
		Node n = head;
		for(int i=0; i<=index; i++){
			n = n.next;
		}
		E e = n.data;
	    n.prev.next = n.next;
	    n.next.prev = n.prev;
		return e;
	}

	public E set(int index, E element) {
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		Node n = head;
		for(int i=0; i<=index; i++){
			n = n.next;
		}
		E e = n.data;
		n.data = element;
		return e;
	}

	public int size() {
		return size;
	}



}
