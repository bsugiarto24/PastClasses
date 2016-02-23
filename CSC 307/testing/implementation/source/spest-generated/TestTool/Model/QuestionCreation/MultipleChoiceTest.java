package TestTool.Model.QuestionCreation;

import TestTool.Model.QuestionCreation.MultipleChoice;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.QuestionCreation.MultipleChoice;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class MultipleChoiceTest
{
    @Before
    public void setUp()
    {
        testObj = (TestTool.Model.QuestionCreation.MultipleChoice)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.QuestionCreation.MultipleChoice.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("C:\Users\Pierson\Documents\School\CPE307\TestTool");
    private File sourceFile = new File("C:\Users\Pierson\Documents\School\CPE307\TestTool\src\TestTool\Model\QuestionCreation\MultipleChoice.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.QuestionCreation.MultipleChoice testObj;
    @Test
    public void addOptionTest_0() throws Exception
    {
        java.util.ArrayList<java.lang.String> options = cloner.deepClone(getFieldValue(testObj, "options", java.util.ArrayList.class));

        int testComboIndex;

        String methodId = "addOption_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "x", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.addOption(param_0);
            Assert.assertTrue(javaTestUtility.getFieldValue(testObj, "options", java.util.ArrayList.class).size() == options.size() + 1);
            setUp();
        }
    }

    @Test
    public void setOptionTest_1() throws Exception
    {
        java.util.ArrayList<java.lang.String> options = cloner.deepClone(getFieldValue(testObj, "options", java.util.ArrayList.class));

        int testComboIndex;

        String methodId = "setOption_int_java.lang.String";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "choice", java.lang.Integer.class);
        List<java.lang.String> testPoints_1 = javaTestUtility.getSampleObjects(testObj, methodId, "text", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size(), testPoints_1.size());

        Class[] parameterClasses = {int.class,java.lang.String.class};
        List<java.lang.Integer> is_0 = javaTestUtility.getUniversalValues(testObj, methodId, 0);
        boolean forall_9 = true;
        int param_0;
        java.lang.String param_1;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);
            param_1 = testPoints_1.get(combinations[testComboIndex][1]);

            testObj.setOption(param_0, param_1);
            for(int i : is_0)
            {
                forall_9 = forall_9 && (options.get(i) == javaTestUtility.getFieldValue(testObj, "options", java.util.ArrayList.class).get(i));
            }
            Assert.assertTrue(forall_9);
            Assert.assertTrue(javaTestUtility.getFieldValue(testObj, "options", java.util.ArrayList.class).get(param_0) == param_1);

            setUp();
        }
    }

    @Test
    public void setAnswerTest_2() throws Exception
    {
        java.util.ArrayList<java.lang.Integer> answer = cloner.deepClone(getFieldValue(testObj, "answer", java.util.ArrayList.class));

        int testComboIndex;

        String methodId = "setAnswer_int";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "choice", java.lang.Integer.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        Class[] parameterClasses = {int.class};
        List<java.lang.Integer> is_0 = javaTestUtility.getUniversalValues(testObj, methodId, 0);
        boolean forall_10 = true;
        List<java.lang.Integer> is_1 = javaTestUtility.getUniversalValues(testObj, methodId, 1);
        boolean forall_11 = true;
        int param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setAnswer(param_0);
            for(int i : is_0)
            {
                forall_10 = forall_10 && (answer.get(i) < options.size());
            }
            Assert.assertTrue(forall_10);
            for(int i : is_1)
            {
                forall_11 = forall_11 && (javaTestUtility.getFieldValue(testObj, "answer", java.util.ArrayList.class).contains(answer.get(i)));
            }
            Assert.assertTrue(forall_11);

            setUp();
        }
    }

    @Test
    public void clearQuestionTest_3() throws Exception
    {
        int difficulty = getFieldValue(testObj, "difficulty", java.lang.Integer.class);
        TestTool.Model.Resource.TestMaker creator = cloner.deepClone(getFieldValue(testObj, "creator", TestTool.Model.Resource.TestMaker.class));
        java.util.ArrayList<java.lang.Integer> answer = cloner.deepClone(getFieldValue(testObj, "answer", java.util.ArrayList.class));
        java.lang.String question = getFieldValue(testObj, "question", java.lang.String.class);
        TestTool.Model.Resource.Subject subject = cloner.deepClone(getFieldValue(testObj, "subject", TestTool.Model.Resource.Subject.class));
        java.util.ArrayList<java.lang.String> options = cloner.deepClone(getFieldValue(testObj, "options", java.util.ArrayList.class));
        TestTool.Model.Resource.Course course = cloner.deepClone(getFieldValue(testObj, "course", TestTool.Model.Resource.Course.class));
        java.lang.String type = getFieldValue(testObj, "type", java.lang.String.class);
        double points = getFieldValue(testObj, "points", java.lang.Double.class);
        java.util.Date dayCreated = cloner.deepClone(getFieldValue(testObj, "dayCreated", java.util.Date.class));


        String methodId = "clearQuestion";

        testObj.clearQuestion();
        Assert.assertTrue(type == null);
        Assert.assertTrue(options == null);
        Assert.assertTrue(answer == null);
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
    public void isCorrectTest_4() throws Exception
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
