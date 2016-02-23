package TestTool.Model.QuestionBank;
import java.util.*;

import TestTool.Model.QuestionCreation.*;
import java.util.ArrayList;
import TestTool.Model.Resource.*;
import java.time.LocalDate;

/**
* Keeps all the question in a collection and gives the option to
* add, delete, edit, or sort a question.
*
* Created by JonathanTan (jtan14@calpoly.edu) on 11/20/15.
*
*/
public class QuestionBank {

    /* The singleton so that other classes has access to the arraylist of questions */
    private static QuestionBank instance = new QuestionBank();

    /* The arrayList to hold all instances of questions created. This is the main array
     * that will be used to add, delete, edit, and sort questions. */
	ArrayList<Question> quesCollec;


    /**
     * THe initializer to initialize the arraylist of questions
      post:
        quesCollec != null;
     */
    private QuestionBank() {
        quesCollec = new ArrayList<Question>();
    }

	/**
	* Adds a question to the question collection.
    *
     pre:
        a != null;

     post:
        quesCollec.contains(a);
	*/
	public void addQuestion(Question a) {

        if (!quesCollec.contains(a))
            quesCollec.add(a);

    }

    /**
     * Deletes a question from the question collection.
     *
     pre:
     quesCollec.size() > 0 && a != null;

     post:
     quesCollec.contains(a) == false;
     */
    public void deleteQuestion(Question a) {

        /*Checks to see if the question is found. */
        boolean found = false;

        //Searching for the correct question to delete
        for (int i = 0; i < quesCollec.size(); i++) {

        /* If the question name is the same as the question name in the array, then
         * we have found our question.
         */
            if (a.equals(quesCollec.get(i))) {
                quesCollec.remove(i);
                found = true;
                break;
            }
        }

        /* If Question not found, then print message. */
        if (!found) {
            System.out.println("Sorry Question Not Found");
        }

    }

	/**
	* Deletes multiple questions from the question collection.
    *
      pre:
        quesCollec.size() > 0 && a != null;

      post:
        quesCollec.contains(a) == false;
	*/
	public void deleteQuestion(ArrayList<Question> a) {

        /* Goes through the array of questions deleting it form question bank */
        for (int count = 0; count < a.size(); count++) {

            //Searching for the correct question to delete
            for (int i = 0; i < quesCollec.size(); i++) {

            /* If the question name is the same as the question name in the array, then
             * we have found our question.
             */
                if (a.get(count).equals(quesCollec.get(i))) {
                    quesCollec.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Filters the arraylist being passed in by the difficulty number
     *
     * @param input the arraylist being passed in
     * @param diff the difficulty being filtered into the new array
     * @return the difficulty filtered arraylist
      pre:
        input.size() > 0 && diff != 0;
     */
    public ArrayList<Question> filterByDiff(ArrayList<Question> input, int diff) {

        /* The final filtered arraylist */
        ArrayList<Question> filtered = new ArrayList<Question>();

        /* Loops through the passed in array */
        for (int i=0; i < input.size(); i++) {

            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getDifficulty() == diff) {
                filtered.add(input.get(i));
            }
        }

        return filtered;
    }

    /**
     * Filters the array by subject
     * @param input the arraylist being passed in
     * @param subj the subject being filtered into the new array
     * @return the subject filtered arraylist
      pre:
        subj != null;
     */
    public ArrayList<Question> filterBySubj(ArrayList<Question> input, Subject subj) {

        /* The final filtered arraylist */
        ArrayList<Question> filtered = new ArrayList<Question>();

        /* Loops through the passed in array */
        for (int i=0; i < input.size(); i++) {

            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getSubject().getName().equals(subj.getName())) {
                filtered.add(input.get(i));
            }
        }

        return filtered;
    }

    /**
     * Filters the array by course
     * @param input the arraylist being passed in
     * @param course the course being filtered into the new array
     * @return the course filtered arraylist
      pre:
        course != null;
     */
    public ArrayList<Question> filterByCourse(ArrayList<Question> input, Course course) {

        /* The final filtered arraylist */
        ArrayList<Question> filtered = new ArrayList<Question>();

        /* Loops through the passed in array */
        for (int i=0; i < input.size(); i++) {

            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getCourse().getName().equals(course.getName())) {
                filtered.add(input.get(i));
            }
        }

        return filtered;
    }

    /**
     * Filters the array by Question Type
     * @param input the arraylist being passed in
     * @param quesType the question type being filtered into the new array
     * @return the subject filtered arraylist
      pre:
        quesType != null;
     */
    public ArrayList<Question> filterByQuestionType(ArrayList<Question> input, String quesType) {

        /* The final filtered arraylist */
        ArrayList<Question> filtered = new ArrayList<Question>();

        /* Loops through the passed in array */
        for (int i=0; i < input.size(); i++) {

            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getType().equals(quesType)) {
                filtered.add(input.get(i));
            }
        }

        return filtered;
    }

    /**
     * Filters the array by the search
     * @param input the arraylist being passed in
     * @param search the searchbox input being filtered into the new array
     * @return the searchbox filtered arraylist
      pre:
        search != null;
     */
    public ArrayList<Question> filterBySearch(ArrayList<Question> input, String search) {

        /* The final filtered arraylist */
        ArrayList<Question> filtered = new ArrayList<Question>();

        /* Loops through the passed in array */
        for (int i=0; i < input.size(); i++) {

            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getQuestion().contains(search)) {
                filtered.add(input.get(i));
            }
        }

        return filtered;
    }

    /**
     * Filters the Array by the start date;
     * @param input the arraylist being passed in
     * @param start the start date
     * @return the arraylist of questions that are after the start date.
     */
    public ArrayList<Question> filterByStart(ArrayList<Question> input, LocalDate start) {

        /* The final filtered arrayList */
        ArrayList<Question> filtered = new ArrayList<>();

        /* Go through the entire input arraylist checking each question. */
        for (int i = 0 ; i < input.size(); i++) {

            /* If the question date is after the start date, then add it to the new ArrayList. */
            if (input.get(i).getDate().compareTo(start) >= 0) {
                filtered.add(input.get(i));
            }
        }

        return filtered;
    }

    /**
     * Filters the Array by the end date;
     * @param input the arraylist being passed in
     * @param end the start date
     * @return the arraylist of questions that are after the start date.
     */
    public ArrayList<Question> filterByEnd(ArrayList<Question> input, LocalDate end) {

        /* The final filtered arrayList */
        ArrayList<Question> filtered = new ArrayList<>();

        /* Go through the entire input arraylist checking each question. */
        for (int i = 0 ; i < input.size(); i++) {

            /* If the question date is before the end date, then add it to the new ArrayList. */
            if (input.get(i).getDate().compareTo(end) <= 0) {
                filtered.add(input.get(i));
            }
        }

        return filtered;
    }

    /**
    * Sorts the questions in the collection based on the options.
    *
      pre:
        (temp.getDiff() != null) && (temp.getSubj() != null) && (temp.getCourseName() != null) &&
        (temp.getQuesType() != null) && (temp.getQuesLength() != null) && (quesCollec.size() != 0);
    */
	public ArrayList<Question> sortAndFilter(BankOptions temp) {

        /* The array being filtered */
        ArrayList<Question> newArr = new ArrayList<Question>();

        /* Adds all the questions into the question collection */
        for (int i = 0; i < quesCollec.size(); i++) {
            newArr.add(quesCollec.get(i));
        }

        /* checks to see if getDiff is actually set */
        if (temp.getDiff() != -1) {

            /* Calls the filter function to filter by Difficulty */
            newArr = filterByDiff(newArr, temp.getDiff());
        }

        System.out.println(temp.getSubj());
        System.out.println(temp.getSubj() == null);

        /* checks to see if the subject is set */
        if (temp.getSubj() != null && !temp.getSubj().getName().equals("None")) {

            /* Calls the filter functions to filter by Subject */
            newArr = filterBySubj(newArr, temp.getSubj());
        }

        /* checks to see if the coursename is set */
        if (!temp.getCourse().getName().equals("None")) {

            /* Calls the filter functions to filter by course */
            newArr = filterByCourse(newArr, temp.getCourse());
        }

        /* checks to see if the question type is set */
        if (!temp.getQuestionType().equals("None")) {

            /* Calls the filter functions to filter by question type. */
            newArr = filterByQuestionType(newArr, temp.getQuestionType());
        }

        /* checks to see if the search box is set */
        if (!(temp.getSearchBox().equals("") || temp.getSearchBox().equals("Search"))) {

            /* Calls the filter functions to filter by the search box. */
            newArr = filterBySearch(newArr, temp.getSearchBox());
        }

        /* checks to see if the start date is null */
        if (temp.getStart() != null) {
            /* Calls the filter functions to filter by the dates. */
            newArr = filterByStart(newArr, temp.getStart());
        }

        /* checks to see if the end date is null. */
        if (temp.getEnd() != null) {
            newArr = filterByEnd(newArr, temp.getEnd());
        }

        return newArr;
    }

    /**
     *
     * @return instance the instance of this class so that other classes have access to the questionbank
     *
      pre:
        instance != null;
     */
    public static QuestionBank getInstance() {
        return instance;
    }

    /**
     * Give the ArrayList of questions that are currently in the QuestionBank
     * @return quesCollec the arraylist of questions in the questionBank
     */
    public ArrayList<Question> getBank(){
        return quesCollec;
    }

    public void setBank(ArrayList<Question> questions){
        this.quesCollec = questions;
    }
}
