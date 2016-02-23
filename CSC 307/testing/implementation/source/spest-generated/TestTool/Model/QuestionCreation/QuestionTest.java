package TestTool.Model.QuestionCreation;

import TestTool.Model.QuestionCreation.Question;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.QuestionCreation.Question;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class QuestionTest
{
    @Before
    public void setUp()
    {
        testObj = (TestTool.Model.QuestionCreation.Question)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.QuestionCreation.Question.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("C:\Users\Pierson\Documents\School\CPE307\TestTool");
    private File sourceFile = new File("C:\Users\Pierson\Documents\School\CPE307\TestTool\src\TestTool\Model\QuestionCreation\Question.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.QuestionCreation.Question testObj;
    @Test
    public void setTypeTest_0() throws Exception
    {
        java.lang.String type = getFieldValue(testObj, "type", java.lang.String.class);

        int testComboIndex;

        String methodId = "setType_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "type", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setType(param_0);
            Assert.assertTrue(type.equals(param_0));
            setUp();
        }
    }

    @Test
    public void setQuestionTest_1() throws Exception
    {
        java.lang.String question = getFieldValue(testObj, "question", java.lang.String.class);

        int testComboIndex;

        String methodId = "setQuestion_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "question", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setQuestion(param_0);
            Assert.assertTrue(question.equals(param_0));
            setUp();
        }
    }

    @Test
    public void setPointsTest_2() throws Exception
    {
        double points = getFieldValue(testObj, "points", java.lang.Double.class);

        int testComboIndex;

        String methodId = "setPoints_double";
        List<java.lang.Double> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "points", java.lang.Double.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        double param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setPoints(param_0);
            Assert.assertTrue(points == param_0);
            setUp();
        }
    }

    @Test
    public void setSubjectTest_3() throws Exception
    {
        TestTool.Model.Resource.Subject subject = cloner.deepClone(getFieldValue(testObj, "subject", TestTool.Model.Resource.Subject.class));

        int testComboIndex;

        String methodId = "setSubject_TestTool.Model.Resource.Subject";
        List<TestTool.Model.Resource.Subject> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "subject", TestTool.Model.Resource.Subject.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        TestTool.Model.Resource.Subject param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setSubject(param_0);
            Assert.assertTrue(subject.equals(param_0));
            setUp();
        }
    }

    @Test
    public void setDifficultyTest_4() throws Exception
    {
        int difficulty = getFieldValue(testObj, "difficulty", java.lang.Integer.class);

        int testComboIndex;

        String methodId = "setDifficulty_int";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "difficulty", java.lang.Integer.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        int param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setDifficulty(param_0);
            Assert.assertTrue(difficulty == param_0);
            setUp();
        }
    }

    @Test
    public void setCourseTest_5() throws Exception
    {
        TestTool.Model.Resource.Course course = cloner.deepClone(getFieldValue(testObj, "course", TestTool.Model.Resource.Course.class));

        int testComboIndex;

        String methodId = "setCourse_TestTool.Model.Resource.Course";
        List<TestTool.Model.Resource.Course> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "course", TestTool.Model.Resource.Course.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        TestTool.Model.Resource.Course param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setCourse(param_0);
            Assert.assertTrue(course.equals(param_0));
            setUp();
        }
    }

    @Test
    public void setDateTest_6() throws Exception
    {
        java.util.Date dayCreated = cloner.deepClone(getFieldValue(testObj, "dayCreated", java.util.Date.class));

        int testComboIndex;

        String methodId = "setDate_java.util.Date";
        List<java.util.Date> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "date", java.util.Date.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.util.Date param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setDate(param_0);
            Assert.assertTrue(dayCreated.equals(param_0));
            setUp();
        }
    }

    @Test
    public void deleteQuestionTest_7() throws Exception
    {

        String methodId = "deleteQuestion";

        testObj.deleteQuestion();
        Assert.assertTrue(!(javaTestUtility.getFieldValue(testObj, "questionBank", TestTool.Model.QuestionBank.questionBank.class).contains()));
        setUp();
    }

    @Test
    public void saveQuestionTest_8() throws Exception
    {

        String methodId = "saveQuestion";

        testObj.saveQuestion();
        Assert.assertTrue(javaTestUtility.getFieldValue(testObj, "questionBank", TestTool.Model.QuestionBank.questionBank.class).contains());
        setUp();
    }

    @Test
    public void clearQuestionTest_9() throws Exception
    {
        int difficulty = getFieldValue(testObj, "difficulty", java.lang.Integer.class);
        TestTool.Model.Resource.TestMaker creator = cloner.deepClone(getFieldValue(testObj, "creator", TestTool.Model.Resource.TestMaker.class));
        java.lang.String question = getFieldValue(testObj, "question", java.lang.String.class);
        TestTool.Model.Resource.Subject subject = cloner.deepClone(getFieldValue(testObj, "subject", TestTool.Model.Resource.Subject.class));
        TestTool.Model.Resource.Course course = cloner.deepClone(getFieldValue(testObj, "course", TestTool.Model.Resource.Course.class));
        java.lang.String type = getFieldValue(testObj, "type", java.lang.String.class);
        double points = getFieldValue(testObj, "points", java.lang.Double.class);
        java.util.Date dayCreated = cloner.deepClone(getFieldValue(testObj, "dayCreated", java.util.Date.class));


        String methodId = "clearQuestion";

        testObj.clearQuestion();
        Assert.assertTrue(type == null);
        Assert.assertTrue(question == null);
        Assert.assertTrue(points == null);
        Assert.assertTrue(subject == null);
        Assert.assertTrue(difficulty == null);
        Assert.assertTrue(course == null);
        Assert.assertTrue(dayCreated == null);
        Assert.assertTrue(creator == null);
        setUp();
    }

    @Test
    public void getQuestionTest_10() throws Exception
    {

        String methodId = "getQuestion";

        testObj.getQuestion();
        setUp();
    }
    /*End generated tests*/
}
