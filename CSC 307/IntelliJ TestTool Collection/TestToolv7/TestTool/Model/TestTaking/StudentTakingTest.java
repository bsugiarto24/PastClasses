//Delete
//
package TestTool.Model.TestTaking;

import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestBank.StudentTestBank;
import TestTool.Model.TestCreation.*;

import java.util.*;
/**
 *
 * This class is for controlling the data when student
 * is ready to take a test. This class contains two variables
 * that will allow the test taking controller to transverse
 * data.
 *
 * Created by Dylan Sun (ysun02@calpoly.edu) on 11/09/2015.
 */
public class StudentTakingTest extends TestTaking{

    /*
     * dummy variable, please ignore.
     */
    private static ArrayList<Integer> temp = new ArrayList<Integer>();

    private static ArrayList<Question> testQuestions;



    // return how many questions in the test
    public static int getQuestinCount() {
        return testQuestions.size();
    }

    public static void setQuestions(ArrayList<Question> question ) {
        testQuestions = question;
    }

    public static ArrayList<Question> returnQuestions() {
        return testQuestions;
    }

    public static int returnQuestionTypeCount(String type) {
        int count = 0;
        for (int i = 0; i < testQuestions.size(); i++) {
            if(testQuestions.get(i).getType() == type) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method allows the data to be transversed when student
     * finsihes a test and submits it.
     */
    public static void submitATest() {
        //StudentTest assignedTest = TestTaking.getStudentAssignedTest(StudentLogin.returnTestNum());
        String name = "john smith";

        ArrayList<Question> question = StudentTestBank.getInstance().getTests(name).get(0).getQuestions();
        
    }

}
