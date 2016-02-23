package TestTool.Model.AdministrativeDetails;

import TestTool.Model.Resource.Course;


/**
 * This class represents the view of courses.
 * @author bsugiarto
 *
 */
public abstract class CourseView extends ListView{

	/**
	 * This function adds an object to the list.
	 * @param obj Object to add to the list.
	 */
	public abstract void add(Course obj);
	
	/**
	 * This function sends the teacher to the test results of the course selected
	 * @param index Index to get more details.
	 */
	public abstract void moreDetails(int index);
	
	
	/**
	 * This function expands the selected row to show Entry Code.
	 * @param index Index to expand row for Entry Code.
	 */
	public abstract void expand(int index);
}
