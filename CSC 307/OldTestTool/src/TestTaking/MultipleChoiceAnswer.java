package TestTaking;

import java.util.Collection;

/**
 * This class allows students to answer Multiple Choice Questions. The class
 * contains a Collection<Integer> type so students are able to, when required,
 * to select multiple answers for one question.
 */

public abstract class MultipleChoiceAnswer extends StudentAnswer {
	Collection<Integer> MCAnswer;


	/**
	 * @return a Collection<Integer> of all the answers selected for one question.
	 */
	public abstract Collection<Integer> getMCAnswer();
}