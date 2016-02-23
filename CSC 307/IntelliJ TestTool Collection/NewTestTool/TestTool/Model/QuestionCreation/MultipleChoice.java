package TestTool.Model.QuestionCreation;
import java.util.*;

import TestTool.Model.TestTaking.StudentAnswer;

/**
* Multiple Choice is a type of question. It has a collection of Strings that represent the different options for answers
* and a Collection of Integers that correspond to correct answers in the Collection of Strings.
*/
public class MultipleChoice extends Question {
   ArrayList<String> options = new ArrayList<String>();
   ArrayList<Integer> answer = new ArrayList<Integer>();
   ArrayList<Integer> studentAnswer;
   /**
   * Sets one of the options
    pre:
   // options does not point to null and choice is within the boundary of the options collection
   		choice != null && choice < options.size(); 
    post:
   // entry of options at choice is equals to text and others are not touched
   		forall(int i; i < options.size() && i != choice;
      		options.get(i) == options'.get(i))
   		&&
   		options'.get(choice) == text;       
   */
   public void setOption(ArrayList<String> x) {
	   options = x;
   }
   
   public ArrayList<String> getOptions() {
	   return options;
   }
   /**
   * Sets answer variable
    pre: 
   // this.answer does not point to null and answer does not contain integer values greater than options' size
   		answer != null &&
   		forall(int i; i < answer.size(); 
      		answer.get(i) < options.size());
    post: 
   // this.answer contains all values in answer
   		forall(int i; i < answer.size();
      		this.answer'.contains(answer.get(i)));
   */ 
   public void setAnswer(ArrayList<Integer> a) {
	   answer = a;
   }
   
   public ArrayList<Integer> getAnswer() {
	   return answer;
   }
   
   public void setStudentAnswer(ArrayList<Integer> a) {
	   studentAnswer = a;
   }
   
   public ArrayList<Integer> getStudentAnswer() {
	   return studentAnswer;
   }
   
   /**
    *  Clears Question's variables
     post:
     	(this.type == null) &&
     	(this.options == null) &&
     	(this.answer == null) &&
    	(this.question == null) &&
    	(this.points == null) &&
    	(this.subject == null) &&
    	(this.difficulty == null) &&
    	(this.course == null) &&
    	(this.dayCreated == null) &&
    	(this.creator == null);
    */
   public static void clearQuestion() {
	   System.out.println("In MultipleChoice.clearQuestion()");
   }
   
   /**
    * Compares StudentAnswer's answer to this.answer
    * 
    * @param a a StudentAnswer o
    * @return true if the StudentAnswer.answer contains the same values as this.answer
    * 
     pre: 
    	(a != null) &&
    	(this.answer != null);
    * 
    */
   
   public boolean isCorrect(StudentAnswer a) {
	   boolean temp = false;
	   int i,j;
	   if (studentAnswer == null) {
		   System.out.println("Student answer has not been set");
		   temp = false;
	   }
	   else {
		   for (i =0; i< answer.size(); i++) {
			   for (j = 0; j < studentAnswer.size(); j++) {
				   if (answer.get(i) == studentAnswer.get(i)) {
					   temp = true;
					   break;
				   }
			   }
			   if (j == studentAnswer.size()) { //went through studentAnswer and didnt find match for answer
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