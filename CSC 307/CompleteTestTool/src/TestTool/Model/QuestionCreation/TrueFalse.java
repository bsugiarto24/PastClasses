package TestTool.Model.QuestionCreation;

/**
* TrueFalse is a type of question that has a boolean as an answer.
*/
public class TrueFalse extends Question {
   boolean answer;

   /**
   * Sets answer variable
   */ 
   public void setAnswer(boolean answer) {
	   this.answer = answer;
   }
}