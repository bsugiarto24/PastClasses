package QuestionCreation;

/**
* TrueFalse is a type of question that has a boolean as an answer.
*/
public abstract class TrueFalse extends Question {
   boolean answer;

   /**
   * Sets answer variable
   */ 
   public abstract void setAnswer(boolean answer);
}