package TestTool.Model.QuestionCreation;

/****
 * 
 * TrueFalse is a type of question that has a boolean as an answer.
 * 
 * @author Pierson Yieh (pyieh@calpoly.edu) 
 * 
 */
public class TrueFalse extends Question {
   /*The correct answer to this TrueFalse question*/
   protected boolean answer;
   /*The TestTaker's answer for this question when it was on a test*/
   protected Boolean studentAnswer;
   
   /**
    * Setter for TrueFalse answer
    * 
     post: 
   		this.answer == answer;
    */ 
   public void setAnswer(boolean answer) {
	   this.answer = answer;
   }
   
   /**
    * Getter for TrueFalse answer
    * 
    * @return this.answer
    * 
    */
   public boolean getAnswer() {
	   return answer;
   }
   
   /**
    * Setter for TrueFalse studentAnswer
    * 
     post: 
   		this.studentAnswer == sAnswer;
    */ 
   public void setStudentAnswer(boolean sAnswer) {
	   this.studentAnswer = sAnswer;
   }
   
   /**
    * Getter for TrueFalse studentAnswer
    * 
    * @return this.studentAnswer
    * 
    */
   public boolean getStudentAnswer() {
	   return studentAnswer;
   }
   
   /**
    * Compares this.studentAnswer to this.answer
    * 
    * @return true if studentAnswer is equal to answer, false otherwise 
    * 
    pre: 
    	this.studentAnswer != null;
    * 
    */
   public boolean isCorrect() {
	   return answer == studentAnswer;
   }
}