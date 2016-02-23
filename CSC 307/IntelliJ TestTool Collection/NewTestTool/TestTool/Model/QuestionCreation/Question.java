package TestTool.Model.QuestionCreation;

import TestTool.Model.Resource.*;
import TestTool.Model.TestGrading.QuestionScore;
import TestTool.Model.TestTaking.*;
import TestTool.Model.QuestionBank.*;

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
   QuestionScore score;
   
   /**
   * Setter for Question type
   *
   * @param type A String that matches to a question type to be set as the question's new type.
   * 
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
   * post: 
      //the Question's member variable points is equal to points
    this.points == points;
   */
   public void setPoints(double points) {
	   this.points = points;
   }
   
   public double getPoints() {
	   return points;
   }
   /**
   * Setter for Question subject 
   * 
   * @param subject A Subject that exists in our Subject Collection and is set to be Question's new subject
   * 
   * post: 
      //the Question's member variable subject is equal to subject
    this.subject.equals(subject);
   */
   public void setSubject(Subject subject) {
	   this.subject = subject;
   }
   
   public Subject getSubject() {
	   return subject;
   }
   
   /**
   * Setter for Question difficulty
   * 
   * @param difficulty An integer ranging from 1-10 to be set as Question's new difficulty value
   * 
   * post: 
      //the Question's member variable difficulty is equal to difficulty
    this.difficulty == difficulty;
   */
   public void setDifficulty(int difficulty) {
	   this.difficulty = difficulty;
   }
   
   public int getDifficulty() {
	   return difficulty;
   }
   
   /**
   * Setter for Question course
   * 
   * @param A Course that exists in our Course Collection that is set to be Question's new Course
   * 
   * post: 
      //the Question's member variable course is equal to course
    this.course.equals(course);
   */
   public void setCourse(Course course) {
	   this.course = course;
   }
   
   public Course getCourse() {
	   return course;
   }
   
   /**
    * Setter for Question date
    * 
    * @param a Date object representing the current date
    * 
    * post: 
       //the Question's member variable course is equal to date
     this.dayCreated.equals(date);
    */
    public void setDate(Date date) {
 	   this.dayCreated = date;
    }
   
    public Date getDate() {
    	return dayCreated;
    }
    
   /**
    * Deletes the question from the Question Bank database
    * 
    * pre:
    	//The Question exists in the Question Bank database
    	questionBank.contains(this);
    * post:
    	//The Question no longer exists in the Question Bank database
    	!questionBank'.contains(this);
    * 
    */
   public static void deleteQuestion() {
	   System.out.println("In Question.deleteQuestion()");
   }
   
   /**
    * Saves the question to the Question Bank database
    * pre:
    	//The Questions' member variables have all been set
    	(this.type.length() != 0) &&
    	(this.question.length() != 0) &&
    	(this.points != null) &&
    	(this.subject != null) &&
    	(this.difficulty != null) &&
    	(this.course != null) &&
    	(this.dayCreated != null) &&
    	(this.creator != null);
    * post:
    	//The Question is saved to the question bank
    	questionBank'.contains(this);
    */
   public static void saveQuestion() {
	   System.out.println("In Question.saveQuestion()");
   }
   
   /**
     post:
     	(this.type == null) &&
    	(this.question == null) &&
    	(this.points == null) &&
    	(this.subject == null) &&
    	(this.difficulty == null) &&
    	(this.course == null) &&
    	(this.dayCreated == null) &&
    	(this.creator == null);
    * 
    */
   public static void clearQuestion() {
	   System.out.println("Children should override Question.clearQuestion()");
   }
   
   /**   
    * @return this.question
    * 
     pre:
     	this.question != null;
    */
   public String getQuestion() {
	   return question;
   }
   
   public String getType() {
	   return type;
   }
   
   public void setScore(QuestionScore sc) {
	   score = sc;
   }
   
   public QuestionScore getScore() {
	   return this.score;
   }
}