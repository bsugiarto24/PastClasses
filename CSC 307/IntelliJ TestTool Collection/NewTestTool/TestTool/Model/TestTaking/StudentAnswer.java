package TestTool.Model.TestTaking;

import java.util.*;
import TestTool.Model.QuestionCreation.Question;

/**
 * StudentAnswer Class is a class that allows individual question types 
 * to be linked together. It act as a parent class so it will be easier
 * to access the different question types. This class have a variable
 * named "QuestionNumber". It is used to keep track of which number the 
 * question is student answering and which question the software is
 * checking.
*/

public class StudentAnswer extends TestTaking {

    private static ArrayList<Question> StudentTestQuestions = TestTaking.getTestQuestion();
    private static ArrayList<String> StudentTestAnswers = new ArrayList<String>();

    public static ArrayList<String> getArrayAnswers() {
        return StudentTestAnswers;

    }

    public static String getOneStringAnswer(int index) {
        return StudentTestAnswers.get(index);
    }

    public static void setAnswers(int index, String answer) {
        if (answer != "none") {
            StudentTestAnswers.add(index, answer);
        }
        else {
            StudentTestAnswers.add(index, "null");
        }
    }
}