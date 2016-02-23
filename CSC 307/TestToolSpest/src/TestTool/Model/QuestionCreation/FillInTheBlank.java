package TestTool.Model.QuestionCreation;

/**
* FillInTheBlank is a type of question that has a question, with a word missing. 
* The answer is a string
*/
public abstract class FillInTheBlank extends Question {
   String answer;
   
   /**
   * Sets answer
   */
   public abstract void setAnswer(String answer);
}