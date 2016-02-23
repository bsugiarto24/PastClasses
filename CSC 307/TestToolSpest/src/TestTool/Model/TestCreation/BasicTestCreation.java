package TestTool.Model.TestCreation;

/**
* Stores the settings needed to create a basic test.
* Also contains the function to create a test.
*
*/

public abstract class BasicTestCreation {

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
	* Pre:
       numQues != 0 && avgDiff != 0 && min != 0 && max != 0 && testLength != 0 && timeUnits != null
       && subject != null && course != null && min <= max
	*/
	public static void genBasicTest() {
		System.out.println("In Basic Test Gen");
	}

    /**
     * Goes to the previous page and cancels creating a basic test.
     */
	public static void goBack() {
		System.out.println("Back Button Pressed");
	}

    /**
     * Sets the Number Questions to specified value
     */
    public abstract void setNumQues(int a);

    /**
     * Sets the Average Difficulty to specified value
     */
    public abstract void setAvgDiff(int a);

    /**
     * Sets the Min to specified value
     */
    public abstract void setMin(int a);

    /**
     * Sets the Max to specified value
     */
    public abstract void setMax(int a);

    /**
     * Sets the test length to specified value
     */
    public abstract void setTestLength(int a);

    /**
     * Sets the Time Unit to specified value
     */
    public abstract void setTimeUnits(String a);

    /**
     * Sets the Subject to specified value
     */
    public abstract void setSubject(String a);

    /**
     * Sets the Course to specified value
     */
    public abstract void setCourse(String a);

    /**
     * Sets the Multiple Choice to specified value
     */
    public abstract void setMultipleChoice(boolean a);

    /**
     * Sets the Free Response to specified value
     */
    public abstract void setFreeResponse(boolean a);

    /**
     * Sets the True/False to specified value
     */
    public abstract void setTrueFalse(boolean a);

    /**
     * Sets the Fill In Blank to specified value
     */
    public abstract void setFillInBlank(boolean a);

    /**
     * Sets the Coding to specified value
     */
    public abstract void setCoding(boolean a);



}

