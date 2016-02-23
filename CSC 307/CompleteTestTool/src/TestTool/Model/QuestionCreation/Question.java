package TestTool.Model.QuestionCreation;

import TestTool.Model.Resource.*;
import TestTool.Model.TestTaking.*;

import java.util.*;

/** 
 * A Question contains a type, the literal question, a point value, a subject the question
 * belongs to, its difficulty, the course the question belongs to, the date it's created, and 
 * the creator's login
 */
public class Question {
   String type;
   String question;
   double points;
   Subject subject;
   int difficulty;
   Course course;
   Date dayCreated;
   TestMaker creator;
   
   /**
   * Setter for Question type
   *
   * @param type A String that matches to a question type to be set as the question's new type.
   * pre: NONE;
   * post: 
      //the Question type is set to be the new type
    this.type.equals(type);
   */
   public void setType(String type) {
	   this.type = type;
   }
   
   /**
   * Setter for Question question
   * 
   * @param question A String to be set as the Question's new question
   * 
   * pre: NONE;
   * post: 
      //the Question's member variable question is equal to question
    this.question.equals(question);
   */
   public void setQuestion(String question) {
	   this.question = question;
   }
   
   /**
   * Setter for Question points
   * 
   * @param points A double to be set as the Question's new points value
   * 
   * pre: NONE;
   * post: 
      //the Question's member variable points is equal to points
    this.points == points );
   */
   public void setPoints(double points) {
	   this.points = points;
   }
   
   /**
   * Setter for Question subject 
   * 
   * @param subject A Subject that exists in our Subject Collection and is set to be Question's new subject
   * 
   * pre: NONE;
   * post: 
      //the Question's member variable subject is equal to subject
    this.subject.equals(subject);
   */
   public void setSubject(Subject subject) {
	   this.subject = subject;
   }
   
   /**
   * Setter for Question difficulty
   * 
   * @param difficulty An integer ranging from 1-10 to be set as Question's new difficulty value
   * 
   * pre: NONE;
   * post: 
      //the Question's member variable difficulty is equal to difficulty
    this.difficulty == difficulty;
   */
   public void setDifficulty(int difficulty) {
	   this.difficulty = difficulty;
   }
   
   /**
   * Setter for Question course
   * 
   * @param A Course that exists in our Course Collection that is set to be Question's new Course
   * 
   * pre: NONE;
   * post: 
      //the Question's member variable course is equal to course
    this.course.equals(course);
   */
   public void setCourse(Course course) {
	   this.course = course;
   }
   
   /**
    * Setter for Question date
    * 
    * @param a Date object representing the current date
    * 
    * pre: NONE;
    * post: 
       //the Question's member variable course is equal to date
     this.dayCreated.equals(date);
    */
    public void setDate(Date date) {
 	   this.dayCreated = date;
    }
   
   /** 
    * Compares a StudentAnswer to the Question's answer value
    * 
    * @param Answer object extracts answer variable from it, and compares to Question's own value
    * @return true if Answer's answer matches with Question's set answer, false otherwise
    * pre: 
   		// Question's member variable answer is not equal too null
    	this.question != null
    * post: NONE;
    */ 
   public boolean isCorrect(StudentAnswer a) {
	   System.out.println("Children classes should override Question.isCorrect()");
	   return false;
   }
   
   /**
    * Deletes the question from the Question Bank database
    * 
    * pre:
    	//The Question exists in the Question Bank database
    	QuestionBank qb.contains(this);
    * post:
    	//The Question no longer exists in the Question Bank database
    	QuestionBank !qb'.contains(this);
    * 
    */
   public static void deleteQuestion() {
	   System.out.println("In Question.deleteQuestion()");
   }
   
   /**
    * Saves the question to the Question Bank database
    * pre:
    	//The Questions' member variables have all been set
    	forall(Object x; this.has(x);
    		this.x != null);
    * post:
    	//The Question is saved to the question bank
    	QuestionBank qb'.contains(this);
    */
   public static void saveQuestion() {
	   System.out.println("In Question.saveQuestion()");
   }
   
   /**
    * Clears the information in the question
    *  pre: NONE;
    *  
    *  post:
    	// All member variables of Question are null;
    	forall(Object x; this.has(x);
    		this.x == null);
    */
   public static void clearQuestion() {
	   System.out.println("Children should override Question.clearQueston()");
   }
   
   public String getQuestion() {
	   return question;
   }
}