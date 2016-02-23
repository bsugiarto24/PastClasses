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
    private File rootDirectory = new File("/Users/bsugiarto/Desktop/CSC 307/TestTool2");
    private File sourceFile = new File("/Users/bsugiarto/Desktop/CSC 307/TestTool2/src/TestTool/Model/TestResults/QuestionChart.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.TestResults.QuestionChart testObj = (TestTool.Model.TestResults.QuestionChart)javaTestUtility.getSampleObject(clazz);


    @Test
    public void createChartTest_0() throws Exception
    {

        String methodId = "createChart";

        Object[] paramValues = {};
        Class[] paramClasses = {};

        getMethodValue(testObj, "createChart", paramValues, paramClasses);
        setUp();
    }
    /*End generated tests*/
}
