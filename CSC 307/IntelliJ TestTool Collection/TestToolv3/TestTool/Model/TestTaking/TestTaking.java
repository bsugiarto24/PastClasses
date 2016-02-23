package TestTool.Model.TestTaking;

import TestTool.Model.QuestionCreation.*;
import TestTool.Model.TestCreation.*;
import TestTool.Model.TestBank.*;

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
	/*
	 * a array list TestQuestions is an array list of type Question that stores
	 * all the question of a given test.
	 */
	private static ArrayList<Question> TestQuestion;

	/*
	 * an array list of given tests of a specific student
	 */
	private static ArrayList<StudentTest> StudentAssignedTests;

	/*
	 * a string of student's name when they logged in
	 */
	private static String LoginName;




	/*
	 *TimeLimit holds the time limit that is set by the teacher on
	 * a specific test.
	 */
	private static int TimeLimit;

	/*
	 *testIndexNumber is the index number of a selected test
	 */

	private static int testIndexNumber;


	/*
	 * setLoginName takes in a String name and set it to
	 * LoginName
	 *
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
	 * returnLoginName returns the name that is logged in to the testtool
	 * @return LoginName
	 * post:
	 * LoginName == return;
	 */
	public static String returnLoginName() { return LoginName;}


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



	////////////////////


	/*
	 * Gets a array list test from StudentTestBank for specific person
	 * and assign to StudentAssignedTests
	 */
	public static void setStudentAssignedTests() {
		StudentAssignedTests = StudentTestBank.getInstance().getTests(LoginName);
	}

	/**
	 * returns an arraylist of assigned tests
	 * @return ArrayList<StudentTest>
	 */

	public static ArrayList<StudentTest> getStudentAssignedTests () {
		return StudentAssignedTests;
	}

	/**
	 * remove the test from array list with the testNumber
	 * @param testNumber
	 */
	public static void removeTest(int testNumber) {
		StudentAssignedTests.remove(testNumber);
	}



}
