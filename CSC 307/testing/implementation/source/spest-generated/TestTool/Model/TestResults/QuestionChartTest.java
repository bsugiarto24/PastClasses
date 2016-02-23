package TestTool.Model.TestResults;

import TestTool.Model.TestResults.QuestionChart;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.TestResults.QuestionChart;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class QuestionChartTest
{
    @Before
    public void setUp()
    {
    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.TestResults.QuestionChart.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/brvo/Documents/Cal Poly/CSC 307/milestone8/sourceFiles");
    private File sourceFile = new File("/Users/brvo/Documents/Cal Poly/CSC 307/milestone8/sourceFiles/src/TestTool/Model/TestResults/QuestionChart.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.TestResults.QuestionChart testObj;
    @Test
    public void createChartTest_0() throws Exception
    {

        java.lang.String ret;
        String methodId = "createChart";

        ret = testObj.createChart();
        Assert.assertTrue(ret.equals("../Resources/QuestionChart.png"));
        setUp();
    }

    @Test
    public void editQuestionTest_1() throws Exception
    {
        TestTool.Model.QuestionCreation.Question current = cloner.deepClone(getFieldValue(testObj, "current", TestTool.Model.QuestionCreation.Question.class));


        TestTool.Model.QuestionCreation.Question ret;
        String methodId = "editQuestion";

        ret = testObj.editQuestion();
        Assert.assertTrue(!(current.equals(ret)));
        setUp();
    }

    @Test
    public void setCurrentTest_2() throws Exception
    {
        TestTool.Model.QuestionCreation.Question current = cloner.deepClone(getFieldValue(testObj, "current", TestTool.Model.QuestionCreation.Question.class));


        String methodId = "setCurrent";

        testObj.setCurrent();
        Assert.assertTrue(current.equals(question));
        setUp();
    }
    /*End generated tests*/
}
