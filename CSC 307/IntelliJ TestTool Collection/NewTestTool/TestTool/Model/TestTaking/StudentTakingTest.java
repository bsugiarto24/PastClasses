//Delete
//
package TestTool.Model.TestTaking;

import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.TestCreation.Test;
import java.util.*;
/**
 * Created by Dylan on 11/9/15.
 */
public abstract class StudentTakingTest extends TestTaking{

    private static ArrayList<Integer> temp = new ArrayList<Integer>();




    //gets the question from TestTaking getTestQuestion function.
    private static ArrayList<Question> currentQuestion = getTestQuestion();



    // return how many questions in the test
    public static int getQuestinCount() {
        return currentQuestion.size();
    }


    //returns a question
    public static Question getQuestions(int questionNumber) {
        return currentQuestion.get(questionNumber);
    }

    /*
     * @param an integer testSerialNumber speicifically for a student
     * push their test answer to grading
     */
    public static ArrayList<Integer> submitTest(int testNumber) {
        temp.add(0,10);
        if (isFinished()) {
            //call the test result part
            return null;
        }
        else {
            //return returnUnasweredQuestions();


            //test
            return temp;
        }

    }

}
