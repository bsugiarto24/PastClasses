package TestTool.Model.AdministrativeDetails;

import java.util.ArrayList;


/**
 * This is an abstract class which represents a list in a window.
 * @author bsugiarto
 *
 */
public abstract class ListView {

	private ArrayList<Object> data;
	
	/**
	 * This function adds an object to the list.
	 * @pre 
	 * @param obj Object to add to the list.
	 */
	public abstract void add(Object obj);
	
	
	/**
	 * This function deletes the object from the list.
	 * @param index Index to remove from list
	 */
	public abstract void delete(int index);
	
	
	/**
	 * This function gets more details
	 * @param index Index to get more details.
	 */
	public abstract void moreDetails(int index);
	
	
	/**
	 * This function expands the selected row.
	 * @param index Index to expand row for more details.
	 */
	public abstract void expand(int index);
	
	
	/**
	 * Displays list view on the window.
	 */
	public abstract void display();
	
}
