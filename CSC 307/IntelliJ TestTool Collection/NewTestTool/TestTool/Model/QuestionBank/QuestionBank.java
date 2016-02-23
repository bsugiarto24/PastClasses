package TestTool.Model.QuestionBank;
import java.util.*;

import TestTool.Model.QuestionCreation.*;
import java.util.ArrayList;

/**
* Keeps all the question in a collection and gives the option to
* add or delete a question.
*/
public class QuestionBank {
    private static QuestionBank instance = new QuestionBank();

	ArrayList<Question> quesCollec;

    /**
     *
      post:
        quesCollec' != null;
     */
    private QuestionBank() {
        quesCollec = new ArrayList<Question>();
    }

	/**
	* Adds a question to the question collection.
    *r
     pre:
        a != null;

     post:
        quesCollec'.contains(a);
	*/
	public void addQuestion(Question a) {
        quesCollec.add(a);
    }

	/**
	* Deletes a question from the question collection.
    *
      pre:
        num > 0 &&
        quesCollec'.size() > 0 && a != null;

      post:
        quesCollec'.contains(a) == false;
	*/
	public void deleteQuestion(Question a) {
        boolean found = false;

        //Searching for the correct question to delete
        for (int i = 0; i < quesCollec.size(); i++) {
            if (a.equals(quesCollec.get(i))) {
                found = true;
                quesCollec.remove(i);
            }
        }

        //If not found then delete it
        if (!found) {
            System.out.println("Sorry Question Not Found");
        }
    }

	/**
	* Searches for a question from the question collection
	* and brings it to the top of the collection for viewing.
    *
      pre:
        quesCollec'.size() > 0;
	*/
	public void searchQuestion(String a) {
        System.out.println("In SearchQuestion");
    }

    /**
    * Sorts the questions in the collection based on the options.
    *
      pre:
        (temp.getDiff() != null) && (temp.getSubj() != null) && (temp.getCourseName() != null) &&
        (temp.getQuesType() != null) && (temp.getQuesLength() != null) && (quesCollec.length() > 0);
    */
	public void sortAndFilter(BankOptions temp) {
        System.out.println("In sortAndFilter");
    }

    public static QuestionBank getInstance() {
        return instance;
    }

    public ArrayList<Question> getBank(){
        return quesCollec;
    }
}
