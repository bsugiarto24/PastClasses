package TestTool.Model.QuestionCreation;

import TestTool.Model.Resource.*;
import TestTool.Model.TestGrading.QuestionScore;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.*;

/****
 *
 * A Question contains a type, the literal question, a point value, a subject the question
 * belongs to, its difficulty, the course the question belongs to, the date it's created, 
 * the creator's login, and the score a student earned on it.
 *
 * @author Pierson Yieh (pyieh@calpoly.edu) 
 *
 */

public class Question implements Serializable{
   /*String representation of the type of question this is*/
   protected String type;
   /*String representation of the literal question*/
   protected String question;
   /*The points this Question is worth*/
   protected double points;
   /*The Subject this Question is from, must be in the collection of Subjects*/
   protected Subject subject;
   /*The difficulty of the Question on a scale of 1 to 10*/
   protected int difficulty;
   /*The Course this Question is from, must be in the collection of Course*/
   protected Course course;
   /*The date the Question is created*/
   protected LocalDate dayCreated;
   /*The TestMaker who created the Question*/
   protected TestMaker creator;
   /*The QuestionScore object filled out by the TestMaker/TestProctor with information
       * necessary for grading*/
   protected QuestionScore score = new QuestionScore();
   
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
   
   /**
    * Getter for Question points
    * 
    * @return this.points
    * 
    */
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
   
   /**
    * Getter for Question subject
    * 
    * @return this.subject
    * 
    */
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
   
   /**
    * Getter for Question difficulty
    * 
    * @return this.diffculty
    * 
    */
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
   
   /**
    * Getter for Question course
    * 
    * this.course
    * 
    */
   public Course getCourse() {
	   return course;
   }
   
   /**
    * Setter for Question date
    * 
    * @param date An object representing the current date
    * 
    * post: 
       //the Question's member variable course is equal to date
     this.dayCreated.equals(date);
    */
    public void setDate(LocalDate date) {
 	   this.dayCreated = date;
    }
   
    
    /**
     * Getter for Question dateCreated
     * 
     * @return this.dayCreated
     * 
     */
    public LocalDate getDate() {
    	return dayCreated;
    }
   
   /**   
    * Getter for Question question
    * 
    * @return this.question
    * 
     pre:
     	this.question != null;
    */
   public String getQuestion() {
	   return question;
   }
   
   /**
    * Getter for Question type
    * 
    * @return this.type
    * 
    */
   public String getType() {
	   return type;
   }

   /**
    * Getter for Question score
    * 
    * @return this.score
    * 
    */
   public QuestionScore getScore() {
	   return this.score;
   }


   public void setScore(QuestionScore score) {
      this.score = score;
   }

   /**
    * Setter for Question creator
    * 
    * @param x is the user who created the question
    */
   public void setCreator(TestMaker x) {
	   this.creator = x;
   }
   /**
    * Getter for Question creator
    * 
    * @return this.creator
    */
   public TestMaker getCreator() {
	   return this.creator;
   }

    /**
     * Overwriting the equals method
     */
    public boolean equals(Question ques) {

        /*Checks if the question, difficulty, subject, course, type of question are equal. */
        return this.question.equals(ques.question) &&
                this.difficulty == ques.difficulty &&
                this.subject.getName().equals(ques.subject.getName()) &&
                this.course.getName().equals(ques.course.getName()) &&
                this.getType().equals(this.getType());
    }
}