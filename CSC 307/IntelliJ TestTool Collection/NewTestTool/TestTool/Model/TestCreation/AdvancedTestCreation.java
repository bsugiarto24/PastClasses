package TestTool.Model.TestCreation;

import java.util.ArrayList;
import TestTool.Model.TestBank.*;

/**
* Stores the settings to create an advanced test and has a function
* to create that advanced test.
*
* Created by JonathanTan (jtan14@calpoly.edu) on 11/20/15.
*
*/

public class AdvancedTestCreation {

    /* The name of the Test */
    String testName;

    /* The Number Test Length of the test */
	int testLength;

    /* The unit test length of the test. */
	String testUnits;

    /* The subject of the test so the generator knows which bank to pull from */
	String subject;

    /* The course number of the subject */
	String course;

    /* An arraylist to keep track of all the options for different questions the user has selected */
    ArrayList<AdvTestOption> advTestOpt;

	/**
	* Generates a test based on the settings specified in the variables.
	*
	* @return returns a random test based on the settings.
	*
	  Pre:
		testName != null && testLength != 0 && testUnits != null && subject != null && course != null
	*/
	public void genAdvTest(String testName, int testLengthNum, String testLengthUnit, String subject, String course, ArrayList<AdvTestOption> advOpt) {

        this.testName = testName;
        testLength = testLengthNum;
        testUnits = testLengthUnit;
        this.subject = subject;
        this.course = course;
        advTestOpt = advOpt;



	}


}