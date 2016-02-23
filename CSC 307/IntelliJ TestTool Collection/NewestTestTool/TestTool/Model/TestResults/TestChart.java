package TestTool.Model.TestResults;

import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestGrading.TestScore;

import java.util.Collection;

/**
*Testchart is a child class of Chart. It specifically contains current 
*of type Test which is the question chosen by the user and a Collect of type
* StudentScore which is a collection of all answers given to for this question by students.
*/
public abstract class TestChart extends Chart {
   private Test current;
   private Collection<TestScore> studentScores;

   
   /**
   * This method will use current and studentScores to create a chart and 
   *return one in the form of a TestChart.
   *
   */
   abstract TestChart createChart();

   public static void exportChart(){
      System.out.println("TestChart.exportChart()");
   }

   public static void setCurrent(){
      System.out.println("TestChart.setCurrent()");
   }
}