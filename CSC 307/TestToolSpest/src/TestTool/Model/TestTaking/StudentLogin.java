package TestTool.Model.TestTaking;


import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.TestCreation.Test;
import java.util.*;

/**
 * Created by Dylan on 11/9/15.
 */
public abstract class StudentLogin {

    /*
     * a private variable that stores the name of the Test
     */
    public static String [] testName = {"Test 1", "Test 2", "Test 3"};

    /*
     * @param an integer variable 'testNumber'
     * loads all questions of the test of a specific testNumber
     */
    public static void attemptTest(int testNumber) {
        System.out.println("Student is attempting " + testName[testNumber - 1]);
    }

    /*
     * @return a String of current student's name;
     * gets student's name from a database
     */
    public abstract String displayStudentName();

}
