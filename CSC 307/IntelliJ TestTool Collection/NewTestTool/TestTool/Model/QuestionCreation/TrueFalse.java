package TestTool.Model.QuestionCreation;

import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.QuestionBank.*;

/**
* TrueFalse is a type of question that has a boolean as an answer.
*/
public class TrueFalse extends Question {
   boolean answer;
   boolean studentAnswer;
   
   /**
   * Sets answer variable
   * 
    post: 
   		this.answer == answer;
   */ 
   public void setAnswer(boolean answer) {
	   this.answer = answer;
   }
   
   public boolean getAnswer() {
	   return answer;
   }
   
   public void setStudentAnswer(boolean sAnswer) {
	   this.studentAnswer = sAnswer;
   }
   
   public boolean getStudentAnswer() {
	   return studentAnswer;
   }
   /**
    *  Clears Question's variables
     post:
     	(this.type == null) &&
    	(this.question == null) &&
    	(this.points == null) &&
    	(this.subject == null) &&
    	(this.difficulty == null) &&
    	(this.course == null) &&
    	(this.dayCreated == null) &&
    	(this.creator == null);
    */
   public static void clearQuestion() {
	   System.out.println("In TrueFalse.clearQuestion()");
   }
   
   /**
    * Compares StudentAnswer's answer to this.answer
    pre: 
    	(a != null) &&
    	(this.answer != null);
    * 
    */
   public boolean isCorrect() {
	   return answer == studentAnswer;
   }
}