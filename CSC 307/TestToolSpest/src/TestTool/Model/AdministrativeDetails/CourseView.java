package TestTool.Model.AdministrativeDetails;

import java.util.ArrayList;

import TestTool.Model.Resource.Course;


/**
 * This class represents the view of courses.
 * @author bsugiarto
 *
 */
public abstract class CourseView extends ListView{

	/**
	 * ArrayList of courses
	 */
	private ArrayList<Course> courses;
	
	/**
	 * This function adds an object to the list.
	 * @param obj Object to add to the list.
     * pre: obj != null;
     * post:
	   // list of courses is added 
	   courses'.size() == courses.size() + 1
	 */
	public abstract void add(Course obj);
	
	/**
	 * This function sends the teacher to the test results of the course selected
	 * @param index Index to get more details.
     * pre: index >=0 && index < courses.size()
	 */
	public abstract void moreDetails(int index);
	

	/**
	 * This function expands the selected row to show Entry Code.
	 * @param index Index to expand row for Entry Code.
	 * pre: index >=0 && index < courses.size()
     */
	public abstract void expand(int index);
}
