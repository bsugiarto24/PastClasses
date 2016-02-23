package TestTool.Model.QuestionCreation;
import java.util.Collection;

/**
* Coding is a type of question. It has a collection of keywords that mark the TestTaker's answer as flagged for TestMaker to see
*/
public abstract class Coding extends Question {
   String answer;
   Collection<String> flags;
   
   /**
   * Sets answer
   */
   public abstract void setAnswer(String answer);
   
   /**
   * Delimits strings to put into flags collection
   */
   public abstract void setFlags(String text);
}