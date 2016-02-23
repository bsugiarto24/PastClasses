package TestTool.Model.AdministrativeDetails;

import TestTool.Model.Resource.Course;

import java.util.ArrayList;


/**
 * This is an abstract class which represents a list in a window.
 * @author bsugiarto
 *
 */
public abstract class ListView {

	/* Represents data in list view
	private ArrayList<Object> data;
	
	/**
	 * This function adds an object to the list.
	 * @pre 
	 * @param obj Object to add to the list.
	 */
	public abstract void add(Object obj);
	
	
	/**
	 * This function deletes the object from the list.
	 * @param index  A String undex to remove from list
	 */
	public abstract void delete(String index);
	
	
	/**
	 * This function gets more details
	 * @param index Index to get more details.
	 */
	public abstract void moreDetails(int index);

	
}
