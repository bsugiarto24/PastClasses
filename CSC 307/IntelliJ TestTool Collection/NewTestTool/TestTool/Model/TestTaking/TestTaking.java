package TestTool.Model.TestTaking;

import TestTool.Model.QuestionCreation.*;
import TestTool.Model.TestCreation.*;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.*;

/**
 * This class is the main class for the package, this class handles
 * all the utilities within the Test Taking UI. This class contains
 * three variables, Question, LoginName, and TimeLimit to keep track
 * of the basics of the test taking individual.
 */
public class TestTaking {
	public static Test ThisTest;
	private static ArrayList<Question> TestQuestion;
	private static ArrayList<Integer> UnansweredQuestionNumbers;


	private static ArrayList<StudentTest> StudentAssignedTests;

	private static ArrayList<String> Answers = StudentAnswer.getArrayAnswers();
	private static String LoginName;
	private static int TimeLimit;

	private static int testIndexNumber;


	/**
	 * @param name
	 * pre:
	 * name != null
	 *
	 * post:
	 * LoginName' == name;
	 */

	public static void setLoginName(String name) {
		LoginName = name;
	}

	/**
	 * @return LoginName
	 * post:
	 * LoginName == return;
	 */
	public static String returnLoginName() {
		return LoginName;
	}

	public static ArrayList<Integer> returnUnasweredQuestions() {
		return UnansweredQuestionNumbers;
	}


	public static boolean isFinished() {
		/*int j = 0;
		for (int i = 0; i < Answers.size(); i++) {
			if (Answers.get(i) == "null") {
				UnansweredQuestionNumbers.add(j,i);
				j++;
			}
		}
		if (UnansweredQuestionNumbers.get(0) == null) {
			return true;
		}
		return false;*/
		return true;
	}



	/////////////////////

	/**
	 * @param question
	 *
	 * pre:
	 * question != null;
	 */



	//set the question of selected test
	public static void setQuestion(ArrayList<Question> question) {
		TestQuestion = question;
	}

	//returns arrayList of questions
	public static ArrayList<Question> getTestQuestion() {
		return TestQuestion;
	}


	//Use this method to assign individual test to a student.
	public static void setStudentAssignedTests (ArrayList<StudentTest> test) {
		StudentAssignedTests = test;
	}

	// returns one test that is in the index of 'testNumber'
	public static Test getStudentAssignedTest(int testNumber) {
		return StudentAssignedTests.get(testNumber);
	}

	// removes the test of given index
	public static void removeTest(int testNumber) {
		StudentAssignedTests.remove(testNumber);
	}

	// sends the array list of Student Tests
	public static ArrayList<StudentTest> getListOfAssignedTests () {
		return StudentAssignedTests;
	}


}
