package TestTool.Model.TestResults;


import TestTool.Model.QuestionCreation.Question;
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
    * pre: !current.equals(null) && !studentAnswers.equals(null)
    *
    * 
   */
   abstract QuestionChart createChart();

   /**
    * This method will take the current quesiton edit it and return a new question object.
    *
    * pre
    *    !current.equals(null)
    *
    * post
    *    !current.equals(return)
    *
    */
   public static Question editQuestion(){
      System.out.println("QuestionChart.editQuestion()");
      return null;
   }

   /**
    * This method will set a Question object and set it as the current Question.
    * pre
    *    question instanceof Question
    *
    * post
    *    current.equals(question)
    */
   public static void setCurrent(Question question){
      System.out.println("QuestionChart.setCurrent()");
   }


   
}