package TestResults;


import QuestionCreation.*;
import TestTaking.*;
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
   */
   abstract QuestionChart createChart();
   
}