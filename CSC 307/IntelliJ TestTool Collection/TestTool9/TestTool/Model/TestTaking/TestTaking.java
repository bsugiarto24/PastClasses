package TestTool.Model.TestTaking;

import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.TestTaker;
import TestTool.Model.Resource.User;
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


	/**
	 *
	 * pre:
	 		AnswerInTest.size() >= 0 &&
	 		totalFRQCount >= 0
	 * @param AnswerInTest
	 * @param totalFRQCount
	 * @return boolean
	 */
	public static boolean isFinished(ArrayList<Boolean> AnswerInTest, int totalFRQCount) {
		int total = AnswerInTest.size() + totalFRQCount;

		//check if the finished question count matches the given question count
		if (total != (StudentAssignedTests.get(StudentLogin.returnTestNum()).getQuestions().size())) {
			return false;
		}
		return true;
	}


	/**
	 *
	 * @return integer
	 * returns the total amount of question in the attempting test
	 */
	public static int getTotalQuestions() {
		return StudentAssignedTests.get(StudentLogin.returnTestNum()).getQuestions().size();
	}

	/*
	 * Gets a array list test from StudentTestBank for specific person
	 * and assign to StudentAssignedTests
	 */
	public static void setStudentAssignedTests() {
		StudentAssignedTests = new ArrayList<StudentTest>();
		for (int i = 0; i < StudentTestBank.getInstance().getTests(LoginName).size(); i++) {
			StudentAssignedTests.add(i, StudentTestBank.getInstance().getTests(LoginName).get(i));

		}
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


	/*
	 * Initializes the TestTaking backend model, this is being called so it will allow TestTaking class to retrieve
	 * the tests assgined to one student
	 */
	public static void initialize() {

		//check if the user is an instance of test taker
		if (User.getUserLoggedIn() instanceof TestTaker) {
			//gets the user's login name
			TestTaking.setLoginName(User.getUserLoggedIn().getName());
			//gets all the tests the user have been assigned
			setStudentAssignedTests();
		}
	}



}
