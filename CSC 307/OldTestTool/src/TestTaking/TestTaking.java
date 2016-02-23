package TestTaking;
import java.util.*;

/**
 * This class is the main class for the package, this class handles
 * all the utilities within the Test Taking UI. This class contains
 * three variables, Question, LoginName, and TimeLimit to keep track
 * of the basics of the test taking individual.
 */
public abstract class TestTaking {
	ArrayList<String> Question;
	String LoginName;
	int TimeLimit;


	/**
	 * @param int time represent miniutes a test taking is limited to
	 * setTimeLimit method set the time limit of the test.
	 */
	public abstract void setTimeLimit(int time);
	
	/**
	 * @param an arraylist of questions that need to be set in the test UI
	 * getQuestion set the all the questions in a test to a local
	 * array list.
	 */
	public abstract void getQuestion(ArrayList<String> question);

	/**
	 * @param a string of student's name
	 * setLoginName method sets the name of the student to the
	 * LoginName variable
	 */

	public abstract void setLoginName (String name);

	/**
	 * @return the student's name in a form of String
	 */
	public abstract String returnLoginName();

	/**
	 * @param an int represent the the question the method call wants.
	 * @return a question based on the question number from the input.
	 */

	public abstract String returnQuestion(int questionNumber);

	/**
	 * @return a int of the set time limit of the test.
	 */
	public abstract int returnTimeLimit();

}
