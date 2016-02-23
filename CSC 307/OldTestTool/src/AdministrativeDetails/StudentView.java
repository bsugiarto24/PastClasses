package TestTool.Model.AdministrativeDetails;

import TestTool.Model.Resource.Course;
import TestTool.Model.UIOverview.TestTaker;


/**
 * This class represents a list of TestTakers.
 * @author bsugiarto
 *
 */
public abstract class StudentView {

	
	/**
	 * This function connects the user to the selected student's test score.
	 * @param index Index to get more details.
	 */
	public abstract void moreDetails(int index);
	
	/**
	 * This function adds an TestTaker to the list.
	 * @param testtaker TestTaker to add to the list.
	 */
	public abstract void add(TestTaker testtaker);
	
}
