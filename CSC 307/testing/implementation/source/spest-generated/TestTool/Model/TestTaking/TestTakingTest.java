package TestTool.Model.TestTaking;

import TestTool.Model.TestTaking.TestTaking;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.TestTaking.TestTaking;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class TestTakingTest
{
    @Before
    public void setUp()
    {
        testObj = (TestTool.Model.TestTaking.TestTaking)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.TestTaking.TestTaking.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/Dylan/Documents/CalPoly/Fall2015/CSC307");
    private File sourceFile = new File("/Users/Dylan/Documents/CalPoly/Fall2015/CSC307/UI/SceneBuilder/TestTool/TestTool/Model/TestTaking/TestTaking.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.TestTaking.TestTaking testObj;
    @Test
    public void setTimeLimitTest_0() throws Exception
    {
        int TimeLimit = getFieldValue(testObj, "TimeLimit", java.lang.Integer.class);

        int testComboIndex;

        String methodId = "setTimeLimit_int";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "time", java.lang.Integer.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        int param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setTimeLimit(param_0);
            Assert.assertTrue(TimeLimit == param_0);
            setUp();
        }
    }

    @Test
    public void setQuestionTest_1() throws Exception
    {
        int testComboIndex;

        String methodId = "setQuestion_java.util.ArrayList";
        List<java.util.ArrayList> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "question", java.util.ArrayList.class, TestTool.Model.QuestionCreation.Question.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.util.ArrayList<TestTool.Model.QuestionCreation.Question> param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setQuestion(param_0);
            setUp();
        }
    }

    @Test
    public void setLoginNameTest_2() throws Exception
    {
        java.lang.String LoginName = getFieldValue(testObj, "LoginName", java.lang.String.class);

        int testComboIndex;

        String methodId = "setLoginName_java.lang.String";
        List<java.lang.String> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "name", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        java.lang.String param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.setLoginName(param_0);
            Assert.assertTrue(LoginName == param_0);
            setUp();
        }
    }

    @Test
    public void returnLoginNameTest_3() throws Exception
    {
        java.lang.String LoginName = getFieldValue(testObj, "LoginName", java.lang.String.class);


        java.lang.String ret;
        String methodId = "returnLoginName";

        ret = testObj.returnLoginName();
        Assert.assertTrue(LoginName == ret);
        setUp();
    }
    /*End generated tests*/
}
