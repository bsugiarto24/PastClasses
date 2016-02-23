package TestTool.Model.QuestionCreation;
import java.util.*;

/**
* FreeResponse is a type of question. It has a collection of keywords that mark the TestTaker's answer as flagged for TestMaker to see
*/
public class FreeResponse extends Question{
   String answer;
   ArrayList<String> flags = new ArrayList<String>();
   String studentAnswer;
   
   /**
   * Sets answer
   */
   public void setAnswer(String answer) {
	   this.answer = answer;
   }
   
   public String getAnswer(){ 
	   return answer;
   }
   
   public void setStudentAnswer(String s) {
	   studentAnswer = s;
   }
   
   public String getStudentAnswer() {
	   return studentAnswer;
   }
   /**
   * Delimits strings to put into flags collection
   */
   public void setFlags(String flagString) {
	   String delims = "[ ;]+";
	   String[] tokens = flagString.split(delims);
	   for (int i = 0; i < tokens.length; i++) {
		   flags.add(tokens[i]);
	   }
	   
   }
}