package TestTool.Model.QuestionCreation;
import java.util.*;

/****
 * FreeResponse is a type of question. It has a collection of keywords that mark the TestTaker's answer as flagged for TestMaker to see
 *
 * @author Pierson Yieh (pyieh@calpoly.edu) 
 */
public class FreeResponse extends Question{
   /*String representation of the correct answer*/
   String answer;
   /*ArrayList of Strings which represent flags (key words) that are noted by the grader*/
   ArrayList<String> flags = new ArrayList<String>();
   /*The TestTaker's answer for this question*/
   String studentAnswer;
   
   /**
    * Setter for answer
    * 
    pre:
    //answer does not equal null
    	answer != null
    post:
    //this.answer equals answer
    	this.answer'.compareTo(answer) == 0;
    */
   public void setAnswer(String answer) {
	   this.answer = answer;
   }
   
   /**
    * Getter for answer
    * 
    * @return this.answer;
    */
   public String getAnswer(){ 
	   return answer;
   }
   
   /**
    * Setter for studentAnswer
    * 
    * @param s
    * 
    pre:
    //s is not equal to null
    	s != null;
    post:
    //student answer is equal to s
    	this.studentAnswer'.compareTo(s) == 0;
    */
   public void setStudentAnswer(String s) {
	   studentAnswer = s;
   }
   
   /**
    * Getter for studentAnswer
    * 
    * @return this.studentAnswer
    */
   public String getStudentAnswer() {
	   return studentAnswer;
   }
   
   /**
    * Setter for flags, delimits through flagString to get all the flags
    * 
    * @param flagString String containing all the flags, flags separated by ';' and/or a space 
    */
   public void setFlags(String flagString) {
	   /*String containing the delimiters to be used*/
	   String delims = "[ ;]+";
	   
	   /*Array containing all the flags*/
	   String[] tokens = flagString.split(delims);
	   
	   /*Add the flags to this.flags ArrayList*/
	   for (int i = 0; i < tokens.length; i++) {
		   flags.add(tokens[i]);
	   }
	   
   }

   public ArrayList<String> getFlags() {
      return flags;
   }

   public void setFlags(ArrayList<String> flags) {
      this.flags = flags;
   }
}