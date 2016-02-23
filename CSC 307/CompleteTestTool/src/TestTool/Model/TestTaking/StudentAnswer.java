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

public abstract class StudentAnswer {

    private Collection<Question> CurrentStudentTest;
    String [] StudentSavedAnswers;

    public void setStudetQuestion(Collection<Question> ThisTestQuestions){
        CurrentStudentTest = ThisTestQuestions;
    }


    //store answers
    public static void saveAnswer(int index, String Answer) {


    }

}