package TestTool.Model.TestResults;

import TestTool.Model.QuestionCreation.Coding;
import TestTool.Model.QuestionCreation.FreeResponse;
import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.QuestionCreation.TrueFalse;
import TestTool.Model.Resource.*;
import TestTool.Model.TestCreation.ActiveTest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by brvo on 12/8/15.
 */
public class TestChartTest {


    @Test
    public void testGetPercentage(){
        ArrayList<Double> percentages  = new ArrayList<>();;
        HashMap<String, Integer> expectedResult = new HashMap<>();
        HashMap<String, Integer> actualResult = new HashMap<>();
        percentages.add(0.0);
        percentages.add(33.3);
        expectedResult.put(TestChart.firstPercentage, 2);

        percentages.add(60.0);
        percentages.add(69.9);
        expectedResult.put(TestChart.secondPercentage, 2);

        percentages.add(70.0);
        percentages.add(73.6);
        percentages.add(79.6);
        expectedResult.put(TestChart.thirdPercentage, 3);

        percentages.add(80.0);
        percentages.add(81.1);
        percentages.add(82.1);
        percentages.add(83.1);
        percentages.add(84.1);
        percentages.add(85.1);
        percentages.add(86.1);
        percentages.add(87.1);
        percentages.add(88.1);
        percentages.add(89.1);
        expectedResult.put(TestChart.fourthPercentage, 10);

        percentages.add(90.0);
        percentages.add(95.2);
        percentages.add(100.0);
        expectedResult.put(TestChart.fifthPercentage, 3);
        actualResult = TestChart.getPercentage(percentages);

        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult.get(TestChart.firstPercentage), actualResult.get(TestChart.firstPercentage));
        assertEquals(expectedResult.get(TestChart.secondPercentage), actualResult.get(TestChart.secondPercentage));
        assertEquals(expectedResult.get(TestChart.thirdPercentage), actualResult.get(TestChart.thirdPercentage));
        assertEquals(expectedResult.get(TestChart.fourthPercentage), actualResult.get(TestChart.fourthPercentage));
        assertEquals(expectedResult.get(TestChart.fifthPercentage), actualResult.get(TestChart.fifthPercentage));

    }

    @Test
    public void testCreateChart() {
        HashMap<String, TestTaker> testTakers = new HashMap<>();
        TestTaker mgolahi = new TestTaker("123", "mgolahi", "Michael Golahi");
        TestTaker brvo = new TestTaker("123", "brvo", "Brandon Vo");
        TestTaker bsugiart = new TestTaker("123", "bsugiart", "Bryan Sugiarto");
        TestTaker jtan = new TestTaker("123", "jtan", "Jonathan Tan");
        TestTaker dsun = new TestTaker("123", "dsun", "Dylan Sun");
        TestTaker pyieh = new TestTaker("123", "pyieh", "Pierson Yieh");
        testTakers.put(mgolahi.getName(), mgolahi);
        testTakers.put(brvo.getName(), brvo);
        testTakers.put(bsugiart.getName(), bsugiart);
        testTakers.put(jtan.getName(), jtan);
        testTakers.put(dsun.getName(), dsun);
        testTakers.put(pyieh.getName(), pyieh);

        //Subjects
        Subject fund = new Subject("Fundamentals");
        SubjectCollection.getInstance().addSubject(fund);

        //Course
        Course cpe101 = new Course("CPE101");
        cpe101.addStudent(mgolahi);
        cpe101.addStudent(brvo);
        cpe101.addStudent(bsugiart);
        cpe101.addStudent(jtan);
        cpe101.addStudent(dsun);
        cpe101.addStudent(pyieh);
        cpe101.addSubject(fund);
        CourseCollection.getInstance().addCourse(cpe101);


        ArrayList<Question> qs1 = new ArrayList<>();
        //a1 should auto grade true
        TrueFalse a1 = new TrueFalse();
        a1.setQuestion("The Sacramento Kings are the best team in the NBA.");
        a1.setPoints(3);
        a1.setAnswer(true);
        qs1.add(a1);

        //a2 should auto grade false
        TrueFalse a2 = new TrueFalse();
        a2.setQuestion("The LA Lakers are still relevant.");
        a2.setPoints(5);
        a2.setAnswer(false);
        qs1.add(a2);

        //a3 is free response
        FreeResponse a3 = new FreeResponse();
        a3.setQuestion("This is a sample question that I'm just making up right now.");
        a3.setPoints(10);
        a3.setAnswer("This is what the correct answer should be.");
        a3.setFlags("answer;correct");
        qs1.add(a3);

        //a4 is coding
        Coding a4 = new Coding();
        a4.setQuestion("This is yet another great sample question by mgolahi.");
        a4.setPoints(15);
        a4.setStudentAnswer("stack.push()");
        a4.setFlags("hello;world");
        qs1.add(a4);


        ActiveTest test = new ActiveTest(new TestTool.Model.TestCreation.Test(qs1, 5, 5,
                "Fundamentals", "Midterm 1", "CPE101"), LocalDate.of(2015, 11, 29));

        //Student 1 earns 0%
        test.getStudentTests().get(0).getScore().setEarnedPoints(0);

        //Student 2 earns 100%
        test.getStudentTests().get(1).getScore().setEarnedPoints(33.0);

        //Student 3 earns 78%
        test.getStudentTests().get(2).getScore().setEarnedPoints(25.0);

        //Student 4 earns 100%
        test.getStudentTests().get(3).getScore().setEarnedPoints(33.0);

        //Student 5 earns 90.9%
        test.getStudentTests().get(4).getScore().setEarnedPoints(30.0);

        //Student 6 earns 60.6%
        test.getStudentTests().get(5).getScore().setEarnedPoints(20.0);

        HashMap<String, Integer> expectedResult = new HashMap<>();
        HashMap<String, Integer> actualResult = new HashMap<>();
        expectedResult.put(TestChart.firstPercentage, 1);
        expectedResult.put(TestChart.secondPercentage, 1);
        expectedResult.put(TestChart.thirdPercentage, 1);
        expectedResult.put(TestChart.fourthPercentage, 0);
        expectedResult.put(TestChart.fifthPercentage, 3);

        actualResult = TestChart.creatChart(test);

        assertEquals(expectedResult, actualResult);
        assertEquals(expectedResult.get(TestChart.firstPercentage), actualResult.get(TestChart.firstPercentage));
        assertEquals(expectedResult.get(TestChart.secondPercentage), actualResult.get(TestChart.secondPercentage));
        assertEquals(expectedResult.get(TestChart.thirdPercentage), actualResult.get(TestChart.thirdPercentage));
        assertEquals(expectedResult.get(TestChart.fourthPercentage), actualResult.get(TestChart.fourthPercentage));
        assertEquals(expectedResult.get(TestChart.fifthPercentage), actualResult.get(TestChart.fifthPercentage));

        SubjectCollection.getInstance().reset();
        CourseCollection.getInstance().reset();
    }

}
