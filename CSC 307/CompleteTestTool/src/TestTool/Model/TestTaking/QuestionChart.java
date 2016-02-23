package TestTool.Model.TestTaking;

import TestTool.Model.TestResults.*;

import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.TestTaking.StudentAnswer;

import java.util.Collection;

/**
*QuestionChart is a child class of Chart. It specifically contains current 
*of type Question which is the question chosen by the user and a Collect of type
* StudentAnswer which is a collection of all answers given to for this question by students.
*/
public abstract class QuestionChart extends Chart {
   
   private Question current;
   private Collection<StudentAnswer> studentAnswers;

   
   /**
   * This method will use current and studentAnswers to create a chart and 
   *return one in the form of a QuestionChart.
   *
      pre: !this.current.equals(null)
            &&
            !this.studentAnswers.equals(null);

      post:
        return.equals("../Resources/QuestionChart.png");


   */
    public String createChart(){
       System.out.println("QuestionChart.createChart()");
       return "return";
    }

   /**
    * This method will take the current quesiton edit it and return a new question object.
    *
       pre:
         !this.current.equals(null);

       post:
        !this.current.equals(return);

    */
   public Question editQuestion(){
      System.out.println("QuestionChart.editQuestion()");
      return null;
   }

   /**
      This method will set a Question object and set it as the current Question.

      post:
          this.current.equals(question);
    */
   public void setCurrent(){
      System.out.println("QuestionChart.setCurrent()");
   }


   
}