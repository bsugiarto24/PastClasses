package TestTool.Model.TestTaking;

import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.TestCreation.Test;
import java.util.*;
/**
 * Created by Dylan on 11/9/15.
 */
public abstract class StudentTakingTest extends StudentLogin{


	/*
	 * @param an integer of questionNumber
	 * @return a String of a specific question based on the questionNumber
	 */
    public abstract String getQuestion(int questionNumber);


    /*
     * @param an integer testSerialNumber speicifically for a student
     * push their test answer to grading
     */
    public static void submitTest(int testSerialNumber) {
        System.out.println("student have submitted "+StudentLogin.testName[testSerialNumber - 1]);
    }

}
