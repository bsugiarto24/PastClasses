package TestTool.Model.QuestionCreation;

import TestTool.Model.QuestionCreation.TrueFalse;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.QuestionCreation.TrueFalse;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class TrueFalseTest
{
    @Before
    public void setUp()
    {
        testObj = (TestTool.Model.QuestionCreation.TrueFalse)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.QuestionCreation.TrueFalse.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("C:\Users\Pierson\Documents\School\CPE307\TestTool");
    private File sourceFile = new File("C:\Users\Pierson\Documents\School\CPE307\TestTool\src\TestTool\Model\QuestionCreation\TrueFalse.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.QuestionCreation.TrueFalse testObj;
    @Test
    public void setAnswerTest_0() throws Exception
    {
        boolean answer = getFieldValue(testObj, "answer", java.lang.Boolean.class);

        int testComboIndex;

        String methodId = "setAnswer_boolean";
        List<java.lang.Boolean> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "answer", java.lang.Boolean.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        boolean param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setAnswer(param_0);
            Assert.assertTrue(answer == param_0);
            setUp();
        }
    }

    @Test
    public void clearQuestionTest_1() throws Exception
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
    public void isCorrectTest_2() throws Exception
    {
        int testComboIndex;

        String methodId = "isCorrect_TestTool.Model.TestTaking.StudentAnswer";
        List<TestTool.Model.TestTaking.StudentAnswer> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "a", TestTool.Model.TestTaking.StudentAnswer.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        TestTool.Model.TestTaking.StudentAnswer param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.isCorrect(param_0);
            setUp();
        }
    }
    /*End generated tests*/
}
