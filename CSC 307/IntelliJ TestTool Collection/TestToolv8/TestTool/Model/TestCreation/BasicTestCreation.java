package TestTool.Model.TestCreation;

import TestTool.Model.QuestionBank.QuestionBank;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.TestBank.TestBank;

import java.util.ArrayList;
import java.util.Collections;

 /**
 * Contains the functionality to create a test when using basic test creation settings
 *
 * Created by Brandon Vo (brvo@calpoly.edu) on 11/20/15.
 *
 */

public class BasicTestCreation {

    /*Private static variable that contains the string "Minutes" */
    private static final String minutes = "Minutes";

    /*Private static variable that contains the string "Seconds" */
    private static final String seconds = "Seconds";

     /*Private static variable that contains the value 60 */
    private static final int time = 60;

    private static final String trueFalseType = "True/False";

     private static final String multipleChoiceType = "Multiple Choice";

     private static final String freeResponseType = "Free-Response";

     private static final String codingType = "Coding";

     private static final String fillInTheBlankType = "Fill-In-The-Blank";

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
                                    boolean freeResponse, boolean trueFalse, boolean fillInBlank, boolean coding)
                                    throws TestCreationException{

        /* This variable contains the time limit of the test that is in a minute unit of time */
        int time = computerTime(testLength, timeUnit);

        /* Any ArrayList of questions that fit the requirements. */
        ArrayList<Question> possibleQuestions = possibleQuestionTypes(multipleChoice, freeResponse,
                trueFalse, fillInBlank, coding);

        /*The is the list of questions chosen that will be passed to the test object constructor */
        ArrayList<Question> questionList = new ArrayList<>();

        Collections.shuffle(possibleQuestions);

        /*This iterates through all questions in possibleQuestions */
        for(Question question : possibleQuestions){

            /* If the question fits into the difficulty range it is added to the questionList*/
            if(question.getDifficulty() >= minRange && question.getDifficulty() <= maxRange){
                questionList.add(question);
            }

            /* If the question list is equal to the test length then it exits the loop. */
            if(questionList.size() == numQues){
                break;
            }
        }

        /* If the quesitonList size is less then numQues then it means not enough questions are available
         * so it throws a custom exception.
          */
        if(questionList.size() < numQues){
            throw new TestCreationException();
        }

        /* Creates a test object */
        Test test = new Test(questionList, avgDiff, time, subject, name, course);

        /* Adds the test to the testbank singleton */
        TestBank.getInstance().add(test);
	}

    private static ArrayList<Question> possibleQuestionTypes(boolean multipleChoice, boolean freeResponse,
                                                             boolean trueFalse, boolean fillInBlank, boolean coding) {
        ArrayList<Question> possibleList = new ArrayList<>();
        ArrayList<Question> bank = QuestionBank.getInstance().getBank();

        if(multipleChoice){
           for(Question question : bank){
               if(question instanceof MultipleChoice){
                   possibleList.add(question);
               }
           }
        }
        if(freeResponse){
            for(Question question : bank){
                if(question instanceof FreeResponse){
                    possibleList.add(question);
                }
            }
        }
        if(trueFalse){
            for(Question question : bank){
                if(question instanceof TrueFalse){
                    possibleList.add(question);
                }
            }
        }
        if(fillInBlank){
            for(Question question : bank){
                if(question instanceof FillInTheBlank){
                    possibleList.add(question);
                }
            }
        }
        if(coding){
            for(Question question : bank){
                if(question instanceof Coding){
                    possibleList.add(question);
                }
            }
        }

        return possibleList;
    }

    /* This methods takes in a testLength and a time unit.
    *   It computes and returns the test length in minutes
    *
    */
    private static int computerTime(int testLength, String timeUnit){

        /*If the timeUnit is equal to minutes then the testLength is returned
        * If the timeUnit is equal to seconds then the testLength is divided by 60
        * If the timeUnit is equal to hours then the testLengt is multiplied by 60
        * */
        if(timeUnit.equals(minutes)){
            return testLength;
        }
        else if(timeUnit.equals(seconds)){
            return testLength / time;
        }
        else{
            return testLength * time;
        }
    }

}

