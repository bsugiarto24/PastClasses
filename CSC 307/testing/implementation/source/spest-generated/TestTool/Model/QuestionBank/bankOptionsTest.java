package TestTool.Model.QuestionBank;

import TestTool.Model.QuestionBank.bankOptions;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.QuestionBank.bankOptions;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class bankOptionsTest
{
    @Before
    public void setUp()
    {
        testObj = (TestTool.Model.QuestionBank.bankOptions)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.QuestionBank.bankOptions.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/JonathanTan/College/Fall2015/CPE307/projectScene");
    private File sourceFile = new File("/Users/JonathanTan/College/Fall2015/CPE307/projectScene/src/TestTool/Model/QuestionBank/bankOptions.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.QuestionBank.bankOptions testObj;
    @Test
    public void setDiffTest_0() throws Exception
    {
        int difficulty = getFieldValue(testObj, "difficulty", java.lang.Integer.class);

        int testComboIndex;

        String methodId = "setDiff_int";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "a", java.lang.Integer.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        int param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setDiff(param_0);
            Assert.assertTrue(difficulty == param_0);
            setUp();
        }
    }

    @Test
    public void setSubjTest_1() throws Exception
    {
        java.lang.String subject = getFieldValue(testObj, "subject", java.lang.String.class);

        int testComboIndex;

        String methodId = "setSubj_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "a", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setSubj(param_0);
            Assert.assertTrue(subject.equals(param_0));
            setUp();
        }
    }

    @Test
    public void setCourseTest_2() throws Exception
    {
        java.lang.String course = getFieldValue(testObj, "course", java.lang.String.class);

        int testComboIndex;

        String methodId = "setCourse_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "a", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setCourse(param_0);
            Assert.assertTrue(course.equals(param_0));
            setUp();
        }
    }

    @Test
    public void setQuesTypeTest_3() throws Exception
    {
        java.lang.String questionType = getFieldValue(testObj, "questionType", java.lang.String.class);

        int testComboIndex;

        String methodId = "setQuesType_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "a", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setQuesType(param_0);
            Assert.assertTrue(questionType.equals(param_0));
            setUp();
        }
    }

    @Test
    public void setQuesLengthTest_4() throws Exception
    {
        java.lang.String questionLength = getFieldValue(testObj, "questionLength", java.lang.String.class);

        int testComboIndex;

        String methodId = "setQuesLength_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "a", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setQuesLength(param_0);
            Assert.assertTrue(questionLength.equals(param_0));
            setUp();
        }
    }

    @Test
    public void getDiffTest_5() throws Exception
    {

        String methodId = "getDiff";

        setUp();
    }

    @Test
    public void getSubjTest_6() throws Exception
    {

        String methodId = "getSubj";

        setUp();
    }

    @Test
    public void getCourseTest_7() throws Exception
    {

        String methodId = "getCourse";

        setUp();
    }

    @Test
    public void getQuesTypeTest_8() throws Exception
    {

        String methodId = "getQuesType";

        setUp();
    }

    @Test
    public void getQuesLengthTest_9() throws Exception
    {

        String methodId = "getQuesLength";

        setUp();
    }
    /*End generated tests*/
}
