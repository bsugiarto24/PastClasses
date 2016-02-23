package TestTaking;

/**
 * This class is focused on true and false type of questions. It extends StudentAnswer
 * class so that this class can be accessed through the parent relationship
 */

public abstract class TrueFalseAnswer extends StudentAnswer {
	boolean TFAnswer;

	/**
	 * @return True or False answer in a form of boolean.
	 */
	public abstract boolean getTFAnswerFromStudent();

}
