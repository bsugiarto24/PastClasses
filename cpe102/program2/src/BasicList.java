/**
  *BasicList
  *@author Bryan Sugiarto
  *@version Program2a
  */

public interface BasicList {

	public void add(int index, java.lang.Object element); 
	public void add(java.lang.Object element); 
	public void clear(); 
	public boolean contains(java.lang.Object element); 
	public java.lang.Object get(int index);
	public int indexOf(java.lang.Object element); 
	public java.lang.Object remove(int index);
	public java.lang.Object set(int index, java.lang.Object element); 
	public int size();
}
