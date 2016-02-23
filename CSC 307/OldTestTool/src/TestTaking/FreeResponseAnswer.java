package TestTaking;

/**
 * This class handles all the Free Response Answers from the student.
 * This includes essays and coding questions and as well as fill in
 * the blank questions.
 */
public abstract class FreeResponseAnswer extends StudentAnswer {
	String FRAnswer;

	/**
	 * @return a string of the Free Response answer
	 */

	public abstract String getFRQAnswer();
}
