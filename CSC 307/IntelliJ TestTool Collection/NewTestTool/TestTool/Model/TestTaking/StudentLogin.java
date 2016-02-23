package TestTool.Model.TestTaking;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.TestCreation.Test;
import java.util.*;

/**
 * Created by Dylan on 11/9/15.
 */
public class StudentLogin extends TestTaking{

    private static String StudentLoginName;
    private static int currentTestIndex;

    /*
     * @param an integer variable 'testNumber'
     * loads all questions of the test of a specific testNumber
     */
    public static void attemptTest(int testNumber) {
        Test test = getStudentAssignedTest(testNumber);
        setQuestion(test.getQuestions());
        currentTestIndex= testNumber;
    }

    //returns the current attempted test index;
    public static int returnTestNum() {
        return currentTestIndex;
    }

    /*
     * @return a String of current student's name;
     * gets student's name from a database
     */
    public static String displayStudentName() {
        return StudentLoginName;
    }

}
