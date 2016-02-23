package TestTool.Model.QuestionCreation;
import java.util.*;

/**
* Coding is a type of question. It has a collection of keywords that mark the TestTaker's answer as flagged for TestMaker to see
*/
public class Coding extends Question {
   String answer;
   ArrayList<String> flags = new ArrayList<String>();
   
   /**
   * Sets answer
   */
   public void setAnswer(String answer) {
	   this.answer = answer;
   }
   
   /**
   * Delimits strings to put into flags collection
   */
   public void setFlags(String text) {
	   if (!flags.contains(text))
		   flags.add(text);
   }
}