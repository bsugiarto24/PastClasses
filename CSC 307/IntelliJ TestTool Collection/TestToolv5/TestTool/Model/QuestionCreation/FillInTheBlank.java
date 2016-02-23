package TestTool.Model.QuestionCreation;

/****
 * FillInTheBlank is a type of question that has a question, with a word missing. 
 * The answer is a string
 * 
 * @author Pierson Yieh (pyieh@calpoly.edu) 
 */
public class FillInTheBlank extends Question {
   /*String representation of the correct answer*/
   String answer;
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
    * Compares this.studentAnswer to this.answer
    * 
    * @return true if the studentAnswer matches the answer, false otherwise
    pre:
    	this.studentAnswer != null;
    */
   public boolean isCorrect() {
	   return (this.answer.compareToIgnoreCase(this.studentAnswer) == 0); 
   }
}