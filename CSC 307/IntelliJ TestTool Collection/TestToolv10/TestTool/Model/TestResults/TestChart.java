package TestTool.Model.TestResults;

import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.StudentTest;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestGrading.TestScore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class TestChart {

   public static final String firstPercentage = "0-59";
   public static final String secondPercentage = "60-69";
   public static final String thirdPercentage = "70-79";
   public static final String fourthPercentage = "80-89";
   public static final String fifthPercentage = "90-100";

   public static HashMap<String, Integer> creatChart(ActiveTest test){
      ArrayList<StudentTest> studentTests = test.getStudentTests();
      ArrayList<Double> percentages = new ArrayList<>();
      HashMap<String, Integer> percentageDivide;

      for(StudentTest studentTest: studentTests){
         TestScore score = studentTest.getScore();
         percentages.add(((score.getEarnedPoints() / score.getPossiblePoints()) * 100.0));

      }

      percentageDivide = getPercentage(percentages);

      return percentageDivide;
   }

   public static HashMap<String, Integer> getPercentage(ArrayList<Double> percentages){
      HashMap<String, Integer> percentageDivide = new HashMap<>();
      int first = 0;
      int second = 0;
      int third = 0;
      int fourth = 0;
      int fifth = 0;
      for(Double percent : percentages){
         if(percent < 60.0){
            first++;
         }
         else if(percent >= 60.0 && percent < 70.0){
            second++;
         }
         else if(percent >= 70.0 && percent < 80.0){
            third++;
         }
         else if(percent >= 80.0 && percent < 90.0){
            fourth++;
         }
         else if(percent >= 90.0){
            fifth++;
         }
      }
      percentageDivide.put(firstPercentage, first);
      percentageDivide.put(secondPercentage, second);
      percentageDivide.put(thirdPercentage, third);
      percentageDivide.put(fourthPercentage, fourth);
      percentageDivide.put(fifthPercentage, fifth);
      return percentageDivide;
   }

}