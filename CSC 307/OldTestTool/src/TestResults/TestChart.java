package TestResults;

import TestCreation.*;
import TestGrading.*;
import java.util.Collection;

/**
*Testchart is a child class of Chart. It specifically contains current 
*of type Test which is the question chosen by the user and a Collect of type
* StudentScore which is a collection of all answers given to for this question by students.
*/
public abstract class TestChart extends Chart {
   private test current;
   private Collection<QuestionScore> studentScores;

   
   /**
   * This method will use current and studentScores to create a chart and 
   *return one in the form of a TestChart.
   *
   */
   abstract TestChart createChart();
}