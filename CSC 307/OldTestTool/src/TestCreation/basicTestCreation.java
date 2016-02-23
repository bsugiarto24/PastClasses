package TestCreation;

/**
* Stores the settings needed to create a basic test.
* Also contains the function to create a test.
*
*/

public abstract class basicTestCreation {

	int numQues;
	int avgDiff;
	int min;
	int max;
	int testLength;
	String timeUnits;
	String subject;
	String course;
	boolean multipleChoice;
	boolean freeResponse;
	boolean trueFalse;
	boolean fillInBlank;
	boolean coding;

	/**
	* Generates a test based on the settings specified in the variables.
	*
	* @return returns a random test based on the settings.
	*/
	public abstract test genBasicTest();
}

