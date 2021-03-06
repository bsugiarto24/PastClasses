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


    /**
     * post:
           testQuestion.size() > 0
     * return how many questions in the test
     *
     */
    public static int getQuestinCount() {
        return testQuestions.size();
    }

    /**
     *
     * pre:
          questions != null
     * @param question
     *
     * set the questions being attempted into this class
     */
    public static void setQuestions(ArrayList<Question> question ) {
        testQuestions = question;
    }

    /**
     *
     * post:
            testQuestions != null
     * @return testQuestions
     *
     *
     */
    public static ArrayList<Question> returnQuestions() {
        return testQuestions;
    }


}
