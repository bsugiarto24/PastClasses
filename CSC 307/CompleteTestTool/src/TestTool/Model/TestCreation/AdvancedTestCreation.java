package TestTool.Model.TestCreation;

/**
* Stores the settings to create an advanced test and has a function
* to create that advanced test.
*
*/

public abstract class AdvancedTestCreation {
	int testLength;
	String testUnits;
	String subject;
	String course;


/**
* Generates a test based on the settings specified in the variables.
*
* @return returns a random test based on the settings.
*
  Pre:
    testLength != 0 && testUnits != null && subject != null && course != null
*/
	public static void genAdvTest() {
		System.out.println("In Adv Test Gen");
	}

    /**
     * Goes to the previous page and cancels creating an Advanced test.
     */
    public static void goBack() {
        System.out.println("Back Button Pressed");
    }


}