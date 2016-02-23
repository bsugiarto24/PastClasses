package TestTool.Model.TestTaking;


/**
 * This class controlls all the data transfers within the finished screen
 * when student finish taking a test.
 *
 * Created by Dylan Sun (ysun02@calpoly.edu) on 11/9/15.
 */
public class StudentFinishedScreen extends TestTaking {
    private static String className;

    private static String testName;

    /**
     *
     * pre:
            course != null && test != null

     * @param course
     * @param test
     *
     * sets the test name and class name
     */

    public static void setFinishedScreenTexts(String course, String test) {
        className = course;
        testName = test;
    }

    /**
     *
     * @return String
     *
     * returns a string of combination of the class name and the test name
     */
    public static String getFinishedScreenTexts() {
        return className + " " + testName;
    }
}
