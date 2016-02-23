package TestTool.Model.QuestionCreation;
import java.util.*;


/****
 * Multiple Choice is a type of question. It has a collection of Strings that represent the different options for answers
 * and a Collection of Integers that correspond to correct answers in the Collection of Strings.
 *
 * @author Pierson Yieh (pyieh@calpoly.edu) 
 */
public class MultipleChoice extends Question {
   /*The list of options for the MultipleChoice question*/
   ArrayList<String> options = new ArrayList<String>();
   /*The list of numbers corresponding to the correct options for the answer*/
   ArrayList<Integer> answer = new ArrayList<Integer>();
   /*The list of numbers corresponding to the options the TestTaker chose*/
   ArrayList<Integer> studentAnswer;
   /**
    * Seter for options
    * 
    * @param x ArrayList of Strings corresponding to the options for this question
    * 
     pre:
     // x does not point to null
   		x != nul;
     post:
     // all entries are equal to the new parameter entries 
   		forall(int i; i < options'.size(); options'.get(i) == x.get(i))     
    */
   public void setOption(ArrayList<String> x) {
	   options = x;
   }
   /**
    * Getter for options
    * 
    * @return this.options
    */
   public ArrayList<String> getOptions() {
	   return options;
   }
   
   /**
   * Sets answer variable
   * 
   * @param a is an ArrayList of Integers corresponding to the correct options 
   * 
    pre: 
    // a is not null and does not contain integer values greater than options' size or negative
   		a != null &&
   		forall(int i; i < a.size(); 
      		a.get(i) < options.size() && a.get(i) >= 0);
    post: 
    // this.answer contains all values in a
   		forall(int i; i < a.size();
      		this.answer'.contains(a.get(i)));
   */ 
   public void setAnswer(ArrayList<Integer> a) {
	   answer = a;
   }
   
   /**
    * Getter for answer 
    * 
    * @return this.answer
    */
   public ArrayList<Integer> getAnswer() {
	   return answer;
   }
   
   /**
    * Sets studentAnswer variable
    * 
    * @param a is an ArrayList of Integers corresponding to the options chosen by the TestTaker 
    * 
     pre: 
     // a is not null and does not contain integer values greater than options' size or negative
    		a != null &&
    		forall(int i; i < a.size(); 
       		a.get(i) < options.size() && a.get(i) >= 0);
     post: 
     // this.answer contains all values in a
    		forall(int i; i < a.size();
       		this.studentAnswer'.contains(a.get(i)));
    */ 
   public void setStudentAnswer(ArrayList<Integer> a) {
	   studentAnswer = a;
   }
   
   /**
    * Getter for studentAnswer 
    * 
    * @return this.studentAnswer
    */
   public ArrayList<Integer> getStudentAnswer() {
	   return studentAnswer;
   }
   
   
   /**
    * Compares this.studentAnswer to this.answer
    * 
    * @return true if the studentAnswer contains the same values as answer
    * 
     pre: 
    	this.studentAnswer != null;
    * 
    */
   
   public boolean isCorrect() {
	   /*final return value*/
	   boolean temp = false;
	   /*integer values to iterate through answer (i) and studentAnswer (j)*/
	   int i,j;
	   /*checks to see if studentAnswer has been set*/
	   if (studentAnswer == null) {
		   System.out.println("Student answer has not been set");
		   temp = false;
	   }
	   /*checks to see if answer has been set*/
	   else if (answer == null) {
		   System.out.println("answer has not been set");
		   temp = false;
	   }
	   else {
		   for (i = 0; i< answer.size(); i++) {
			   for (j = 0; j < studentAnswer.size(); j++) {
				   if (answer.get(i) == studentAnswer.get(i)) {
					   temp = true;
					   break;
				   }
			   }
			 //went through studentAnswer and didn't find match for answer
			   if (j == studentAnswer.size()) {
				   temp = false;
				   break;
			   }
		   }
	   }
	   return temp;
   }
   
   public String toString() {
	   String ret = "";
	   ret += "Type: " + type;
	   ret += "\nQuestion: " + question;
	   ret += "\nOptions: " + options.toString();
	   ret += "\nAnswer: " + answer.toString();
	   return ret;
   }
}