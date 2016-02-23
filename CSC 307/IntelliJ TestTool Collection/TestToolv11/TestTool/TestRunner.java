package TestTool;

import TestTool.Model.AdministrativeDetails.CourseViewTest;
import TestTool.Model.Resource.ResourceTestSuite;
import TestTool.Model.TestBank.TestBankTest;
import TestTool.Model.TestResults.TestChartTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {

        System.out.println("Junit for TestChart.java - Brandon Vo");
        Result result = JUnitCore.runClasses(TestChartTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());


        System.out.println("Junit for TestBank.java - Brandon Vo");
        result = JUnitCore.runClasses(TestBankTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());


        System.out.println("Junit for CourseCollection.java and SubjectCollection.java - Michael Golahi");
        result = JUnitCore.runClasses(ResourceTestSuite.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());


        System.out.println("Junit for TestBank.java - Bryan Sugiarto");
        result = JUnitCore.runClasses(CourseViewTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());

    }
}