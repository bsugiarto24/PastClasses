package TestTool.Model.TestTaking;
import TestTool.Model.TestCreation.Test;

/**
 * This class breaks down the test taking just for
 * student's login screen. It will handle the data
 * that is being transfered within the login controller
 * This class contains two variables that saves the student's
 * name and the index of test they seleceted
 *
 * Created by Dylan Sun (ysun02@calpoly.edu) on 11/9/15.

 */
public class StudentLogin extends TestTaking{

    /*
     * String of StudentLoginName
     */
    private static String StudentLoginName;
    /*
     * int of the test index selected
     */
    private static int indexOfTestSelected;

    /*
     * @param an integer variable 'testNumber'
     * loads all questions of the test of a specific testNumber
     */
    public static void attemptTest(int testNumber) {

        /*
         * test gets the specific student test provided by the index number
         */
        Test test = TestTaking.getStudentAssignedTests().get(testNumber);

        /* set the give test's question in to local variable*/
        StudentTakingTest.setQuestions(test.getQuestions());
        StudentFinishedScreen.setFinishedScreenTexts(test.getCourse().getName(), test.getName());

        indexOfTestSelected = testNumber;
        /* remove the the test in the assigned test array list*/
        TestTaking.removeTest(testNumber);
    }

    /**
     * returns the current attempted test index;
     *
     * @return currentTestIndex
     */
    public static int returnTestNum() {
        return indexOfTestSelected;
    }

    /*
     * This method will return the string so the controller can
     * display the student's name
     *
     *
     * @return a String of current student's name;
     * gets student's name from a database
     */
    public static String getStudentName() {
        return StudentLoginName;
    }

}
