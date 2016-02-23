package TestTool.Model.TestTaking;
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
	 * pre: NONE;
	 * post:
	 	//The TestTaking variable TimeLimit is set to a new time TimeLimit = time;
	 */
	public abstract void setTimeLimit(int time);
	
	/**
	 * @param an arraylist of questions that need to be set in the test UI
	 * getQuestion set the all the questions in a test to a local
	 * array list.
	 * pre: NONE;
	 * post: 
	 	//The TestTaking variable Question will be set to a new ArrayList of questions
	 	Question = new ArrayList<String>question.clone();
	 */
	public abstract void setQuestion(ArrayList<String> question);

	/**
	 * @param a string of student's name
	 * setLoginName method sets the name of the student to the
	 * LoginName variable
	 * pre: NONE;
	 * post:
	 	//The TestTaking variable LoginName will be set to a new String of student's name
	 	LoginName.equals(name);
	 */

	public abstract void setLoginName (String name);

	/**
	 * @return the student's name in a form of String
	 * pre:
	 	//Within TestTaking class, the LoginName String is not null
	 	!LoginName.isEmpty();
	 * post: NONE;
	 */
	public abstract String returnLoginName();

	/**
	 * @param an int represent the the question the method call wants.
	 * @return a question based on the question number from the input.
	 * pre:
	 	//The variable questionNumber is greater than 0
	 	questionNumber >= 0;
	 	//The ArrayList of questions have a question in the questionNumber index;
	 	!Question.get(questionNumber).isEmpty();
	 * post: NONE;
	 */

	public abstract String returnQuestion(int questionNumber);

	/**
	 * @return a int of the set time limit of the test.
	 * pre:
	 	//The variable TimeLimit is greater than 0
	 	TimeLimit > 0;
	 */
	public abstract int returnTimeLimit();

}
