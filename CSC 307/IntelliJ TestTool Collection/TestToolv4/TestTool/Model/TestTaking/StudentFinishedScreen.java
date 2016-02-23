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


    /*
     * contains all datas that needed for Home Screen to populate
     */
    public static void takeStudentToHomeScreen() {
        System.out.println("took student to home screen");
    }


    public static void setFinishedScreenTexts(String course, String test) {
        className = course;
        testName = test;
    }

    public static String getFinishedScreenTexts() {
        return className + " "+testName;
    }
}
