package TestTool.Model.QuestionBank;
import java.util.*;

import TestTool.Model.QuestionCreation.*;

/**
* Keeps all the question in a collection and gives the option to
* add or delete a question.
*/
public abstract class questionBank {

	//public Collection<Question> quesCollec;

	/**
	* Adds a question to the question collection.
	*/
	public abstract void addQuestion(Question a);

	/**
	* Deletes a question from the question collection.
    *
      Pre:
        quesCollec.size() > 0
	*/
	public abstract void deleteQuestion(Question a);

	/**
	* Searches for a question from the question collection
	* and brings it to the top of the collection for viewing.
    *
      Pre:
        quesCollec.size() > 0
	*/
	public abstract void searchQuestion(String a);

    /**
    * Sorts the questions in the collection based on the options.
    *
      Pre:
        temp.getDiff() != null && temp.getSubj != null && temp.getCourse() != null &&
        temp.getQuesType() != null && temp.getQuesLength() != null && quesCollec.length() > 0

      Post:
        forall (int i; i < quesCollec.length(); return quesCollec.sortAndFilter())

    */
	public abstract void sortAndFilter(bankOptions temp);
}