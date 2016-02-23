package TestTool.Model.TestCreation;

/**
* Stores the settings needed to create a basic test.
* Also contains the function to create a test.
*
*/

public class BasicTestCreation {

	/**
	* Generates a test based on the settings specified in the variables.
	*
	*
     pre:
       numQues > 0 &&
       avgDiff > 0 &&
       minRange > 0 &&
       maxRange > 0 &&
       minRange <= maxRange &&
       testLength > 0 &&
       !timeUnits.equals(null) &&
       !subject.equals(null) &&
       !course.equals(null) &&
       !multipleChoice.equals(null) &&
       !freeResponse.equals(null) &&
       !trueFalse.equals(null) &&
       !fillInBlank.equals(null) &&
       !coding.equals(null);
	*/
	public static void genBasicTest(String name, int numQues, int avgDiff, int minRange, int maxRange, int testLength,
                                    String timeUnit, String subject, String course, boolean multipleChoice,
                                    boolean freeResponse, boolean trueFalse, boolean fillInBlank, boolean coding) {

        System.out.println("Name: "+ name);
        System.out.println("Number of Questions: " + numQues);
        System.out.println("Avg Difficulty: " + avgDiff);
        System.out.println("Max Range: " + maxRange);
        System.out.println("Min Range: " + minRange);
        System.out.println("testLength " + testLength);
        System.out.println("Unit of Time: " + timeUnit);
        System.out.println("Subject: "+ subject);
        System.out.println("Course: " + course);
        System.out.println("Multiple Choice: " + multipleChoice);
        System.out.println("Free Response: " + freeResponse);
        System.out.println("True or False: " + trueFalse);
        System.out.println("Fill in the Blank: " + fillInBlank);
        System.out.println("Coding: " + coding);
	}

}

