package TestTool.Model.QuestionCreation;

/**
* FillInTheBlank is a type of question that has a question, with a word missing. 
* The answer is a string
*/
public class FillInTheBlank extends Question {
   String answer;
   
   /**
   * Sets answer
   */
   public void setAnswer(String answer) {
	   System.out.println("Filler");
   }
}