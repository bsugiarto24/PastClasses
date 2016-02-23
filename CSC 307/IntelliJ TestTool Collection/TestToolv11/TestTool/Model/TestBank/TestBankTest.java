package TestTool.Model.TestBank;

import TestTool.Model.QuestionCreation.Coding;
import TestTool.Model.QuestionCreation.FreeResponse;
import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.QuestionCreation.TrueFalse;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.SubjectCollection;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;


import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by brvo on 12/9/15.
 */
public class TestBankTest {


    @Before
    public void beforeClass() {
        SubjectCollection.getInstance().reset();
        CourseCollection.getInstance().reset();
        TestBank.getInstance().reset();

        //Subjects
        SubjectCollection.getInstance().addSubject(new Subject("Fundamentals"));

        //Course
        Course cpe101 = new Course("CPE101");
        Course cpe102 = new Course("CPE102");
        CourseCollection.getInstance().addCourse(cpe101);
        CourseCollection.getInstance().addCourse(cpe102);

        //Test 1 for course "CPE101"
        ArrayList<Question> qs1 = new ArrayList<>();
        TrueFalse a1 = new TrueFalse();
        a1.setQuestion("The Sacramento Kings are the best team in the NBA.");
        a1.setPoints(3);
        a1.setAnswer(true);
        qs1.add(a1);
        TrueFalse a2 = new TrueFalse();
        a2.setQuestion("The LA Lakers are still relevant.");
        a2.setPoints(5);
        a2.setAnswer(false);
        qs1.add(a2);

        TestTool.Model.TestCreation.Test test  = new TestTool.Model.TestCreation.Test(qs1, 5, 5,
                "Fundamentals", "Test1-CPE101", "CPE101");
        TestBank.getInstance().add(test);

        //Test 2 for course "CPE101"
        ArrayList<Question> qs2 = new ArrayList<>();
        FreeResponse a3 = new FreeResponse();
        a3.setQuestion("This is a sample question that I'm just making up right now.");
        a3.setPoints(10);
        a3.setAnswer("This is what the correct answer should be.");
        a3.setFlags("answer;correct");
        qs2.add(a3);
        test  = new TestTool.Model.TestCreation.Test(qs2, 5, 5, "Fundamentals", "Test2-CPE101", "CPE101");
        TestBank.getInstance().add(test);


        //Test 1 for course "CPE102"
        ArrayList<Question> qs3 = new ArrayList<>();
        Coding a4 = new Coding();
        a4.setQuestion("This is yet another great sample question by mgolahi.");
        a4.setPoints(15);
        a4.setStudentAnswer("stack.push()");
        a4.setFlags("hello;world");
        qs3.add(a4);
        test  = new TestTool.Model.TestCreation.Test(qs3, 5, 5, "Fundamentals", "Test1-CPE102", "CPE102");
        TestBank.getInstance().add(test);

    }

    @After
    public void afterClass(){
        SubjectCollection.getInstance().reset();
        CourseCollection.getInstance().reset();
        TestBank.getInstance().reset();

    }

    @org.junit.Test
    public void testGetTestForCourse101(){
        ArrayList<Test> expected = new ArrayList<>();
        ArrayList<Test> actual = new ArrayList<>();
        //Test 1 for course "CPE101"
        ArrayList<Question> qs1 = new ArrayList<>();
        TrueFalse a1 = new TrueFalse();
        a1.setQuestion("The Sacramento Kings are the best team in the NBA.");
        a1.setPoints(3);
        a1.setAnswer(true);
        qs1.add(a1);
        TrueFalse a2 = new TrueFalse();
        a2.setQuestion("The LA Lakers are still relevant.");
        a2.setPoints(5);
        a2.setAnswer(false);
        qs1.add(a2);

        TestTool.Model.TestCreation.Test test  = new TestTool.Model.TestCreation.Test(qs1, 5, 5,
                "Fundamentals", "Test1-CPE101", "CPE101");
        expected.add(test);

        //Test 2 for course "CPE101"
        ArrayList<Question> qs2 = new ArrayList<>();
        FreeResponse a3 = new FreeResponse();
        a3.setQuestion("This is a sample question that I'm just making up right now.");
        a3.setPoints(10);
        a3.setAnswer("This is what the correct answer should be.");
        a3.setFlags("answer;correct");
        qs2.add(a3);
        test  = new TestTool.Model.TestCreation.Test(qs2, 5, 5, "Fundamentals", "Test2-CPE101", "CPE101");
        expected.add(test);

        Course cpe101 = CourseCollection.getInstance().findCourse("CPE101");
        actual = TestBank.getInstance().getTestForCourse(cpe101);

        Assert.assertTrue(actual.size() == 2);
        assertEquals(expected.get(0).getName(), actual.get(0).getName());
        assertEquals(expected.get(0).getCourse(), actual.get(0).getCourse());
        assertEquals(expected.get(0).getDifficulty(), actual.get(0).getDifficulty());
        assertEquals(expected.get(0).getNumQuestions(), actual.get(0).getNumQuestions());
        assertEquals(expected.get(0).getTimeLimit(), actual.get(0).getTimeLimit());
        assertNotEquals(expected.get(0).getQuestions(), actual.get(0).getQuestions());

        assertEquals(expected.get(1).getName(), actual.get(1).getName());
        assertEquals(expected.get(1).getCourse(), actual.get(1).getCourse());
        assertEquals(expected.get(1).getDifficulty(), actual.get(1).getDifficulty());
        assertEquals(expected.get(1).getNumQuestions(), actual.get(1).getNumQuestions());
        assertEquals(expected.get(1).getTimeLimit(), actual.get(1).getTimeLimit());
        assertNotEquals(expected.get(1).getQuestions(), actual.get(1).getQuestions());

    }


    @org.junit.Test
    public void testGetTestForCourse102(){
        ArrayList<Test> expected = new ArrayList<>();
        ArrayList<Test> actual = new ArrayList<>();
        ArrayList<Question> qs3 = new ArrayList<>();
        Coding a4 = new Coding();
        a4.setQuestion("This is yet another great sample question by mgolahi.");
        a4.setPoints(15);
        a4.setStudentAnswer("stack.push()");
        a4.setFlags("hello;world");
        qs3.add(a4);
        TestTool.Model.TestCreation.Test test  = new TestTool.Model.TestCreation.Test(qs3, 5, 5, "Fundamentals", "Test1-CPE102", "CPE102");
        expected.add(test);

        Course cpe102 = CourseCollection.getInstance().findCourse("CPE102");
        actual = TestBank.getInstance().getTestForCourse(cpe102);

        Assert.assertTrue(actual.size() == 1);
        assertEquals(expected.get(0).getName(), actual.get(0).getName());
        assertEquals(expected.get(0).getCourse(), actual.get(0).getCourse());
        assertEquals(expected.get(0).getDifficulty(), actual.get(0).getDifficulty());
        assertEquals(expected.get(0).getNumQuestions(), actual.get(0).getNumQuestions());
        assertEquals(expected.get(0).getTimeLimit(), actual.get(0).getTimeLimit());
        assertNotEquals(expected.get(0).getQuestions(), actual.get(0).getQuestions());
    }
}
