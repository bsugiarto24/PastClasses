package TestTool.Model.TestCreation;

import TestTool.Model.TestCreation.AdvancedTestCreation;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.TestCreation.AdvancedTestCreation;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class AdvancedTestCreationTest
{
    @Before
    public void setUp()
    {
        testObj = (TestTool.Model.TestCreation.AdvancedTestCreation)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.TestCreation.AdvancedTestCreation.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/JonathanTan/College/Fall2015/CPE307/projectScene");
    private File sourceFile = new File("/Users/JonathanTan/College/Fall2015/CPE307/projectScene/src/TestTool/Model/TestCreation/AdvancedTestCreation.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.TestCreation.AdvancedTestCreation testObj;
    @Test
    public void AdvancedTestCreationTest_0() throws Exception
    {
        java.lang.String testUnits = getFieldValue(testObj, "testUnits", java.lang.String.class);
        java.lang.String subject = getFieldValue(testObj, "subject", java.lang.String.class);
        java.lang.String course = getFieldValue(testObj, "course", java.lang.String.class);
        int testLength = getFieldValue(testObj, "testLength", java.lang.Integer.class);

        int testComboIndex;

        String methodId = "TestTool.Model.TestCreation.AdvancedTestCreation_int_java.lang.String_java.lang.String_java.lang.String";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "length", java.lang.Integer.class);
        List<java.lang.String> testPoints_1 = javaTestUtility.getSampleObjects(testObj, methodId, "unit", java.lang.String.class);
        List<java.lang.String> testPoints_2 = javaTestUtility.getSampleObjects(testObj, methodId, "subj", java.lang.String.class);
        List<java.lang.String> testPoints_3 = javaTestUtility.getSampleObjects(testObj, methodId, "csr", java.lang.String.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size(), testPoints_1.size(), testPoints_2.size(), testPoints_3.size());

        int param_0;
        java.lang.String param_1;
        java.lang.String param_2;
        java.lang.String param_3;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);
            param_1 = testPoints_1.get(combinations[testComboIndex][1]);
            param_2 = testPoints_2.get(combinations[testComboIndex][2]);
            param_3 = testPoints_3.get(combinations[testComboIndex][3]);

            Assert.assertTrue(testLength == param_0);
            Assert.assertTrue(testUnits == param_1);
            Assert.assertTrue(subject == param_2);
            Assert.assertTrue(course == param_3);
            setUp();
        }
    }

    @Test
    public void genAdvTestTest_1() throws Exception
    {

        String methodId = "genAdvTest";

        testObj.genAdvTest();
        setUp();
    }
    /*End generated tests*/
}
