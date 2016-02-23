package TestCreation;

import QuestionCreation.*;
import java.util.Collection;

/**
* A test is a collection of questions and contains basic test
* information such as test difficulty, test time, and test subject.
*/
public abstract class test {
	public Collection<Question> question;
	public int difficulty;
	public int testTime;
	public String testTimeUnit;
	public String subject;
	public int averageScore;


	/**
	* Get the average difficulty level of this test.
	* @return the average difficulty of the test.
	*/
	public abstract int getDifficulty();

	/**
	* Set the average diffifulty level for this test.
	*
	*/
	public abstract void setDifficulty();

	/**
	* Get the time limit for the test
	* @return the time limit
	*/
	public abstract int getTestTime();

	/**
	* Set the time limit for the test.
	*
	*/
	public abstract void setTestTime();

	/**
	* Get the units in seconds, minutes, hours
	* @return the units for the test time.
	*/
	public abstract String getTestTimeUnit();

	/**
	* Set the time units for the test. Seconds, minutes, hours
	*
	*/
	public abstract void setTestTimeUnit();

	/**
	* Get subject of this test.
	* @return the type of test this is.
	*/
	public abstract String getSubject();

	/**
	* Set the subject for this test.
	*
	*/
	public abstract void setSubject();

	/**
	* Get the average score of the students that have taken the test.
	* @return the average score of results from this test.
	*/
	public abstract int getAverageScore();


}

