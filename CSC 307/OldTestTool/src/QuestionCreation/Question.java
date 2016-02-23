package QuestionCreation;
import java.util.Date;

import Resource.Subject;
import UIOverview.*;
import TestTaking.*;

/** 
 * A Question contains a type, the literal question, a point value, a subject the question
 * belongs to, its difficulty, the course the question belongs to, the date it's created, and 
 * the creator's login
 */
public abstract class Question {
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
   */
   public abstract void setType(String type);
   
   /**
   * Setter for Question question
   */
   public abstract void setQuestion(String question);
   
   /**
   * Setter for Question points
   */
   public abstract void setPoints(double points);
   
   /**
   * Setter for Question subject 
   */
   public abstract void setSubject(Subject subject);
   
   /**
   * Setter for Question difficulty
   */
   public abstract void setDifficulty(int difficulty);
   
   /**
   * Setter for Question course
   */
   public abstract void setCourse(Course course);
   
   /**
   * @param Answer object extracts answer variable from it, and compares to Question's own value
   * @return true if Answer's answer matches with Question's set answer, false otherwise
   */ 
   public abstract boolean isCorrect(StudentAnswer a);
}