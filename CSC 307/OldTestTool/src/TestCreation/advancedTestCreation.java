package TestCreation;

/**
* Stores the settings to create an advanced test and has a function
* to create that advanced test.
* 
*
*/

public abstract class advancedTestCreation {
	int testLength;
	String testUnits;
	String subject;
	String course;

	/**
	* Generates a test based on the settings specified in the variables.
	*
	* @return returns a random test based on the settings.
	*/
	public abstract test genAdvTest();

}