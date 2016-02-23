package TestTool.Model.TestCreation;

import TestTool.Model.TestCreation.BasicTestCreation;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.TestCreation.BasicTestCreation;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class BasicTestCreationTest
{
    @Before
    public void setUp()
    {
        testObj = (TestTool.Model.TestCreation.BasicTestCreation)javaTestUtility.getSampleObject(clazz);

    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.TestCreation.BasicTestCreation.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/brvo/Documents/Cal Poly/CSC 307/milestone8/sourceFiles");
    private File sourceFile = new File("/Users/brvo/Documents/Cal Poly/CSC 307/milestone8/sourceFiles/src/TestTool/Model/TestCreation/BasicTestCreation.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.TestCreation.BasicTestCreation testObj;
    @Test
    public void genBasicTestTest_0() throws Exception
    {
        int testComboIndex;

        String methodId = "genBasicTest_int_int_int_int_int_java.lang.String_java.lang.String_java.lang.String_boolean_boolean_boolean_boolean_boolean";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "numQues", java.lang.Integer.class);
        List<java.lang.Integer> testPoints_1 = javaTestUtility.getSamplePrimitives(testObj, methodId, "avgDiff", java.lang.Integer.class);
        List<java.lang.Integer> testPoints_2 = javaTestUtility.getSamplePrimitives(testObj, methodId, "minRange", java.lang.Integer.class);
        List<java.lang.Integer> testPoints_3 = javaTestUtility.getSamplePrimitives(testObj, methodId, "maxRange", java.lang.Integer.class);
        List<java.lang.Integer> testPoints_4 = javaTestUtility.getSamplePrimitives(testObj, methodId, "testLength", java.lang.Integer.class);
        List<java.lang.String> testPoints_5 = javaTestUtility.getSampleObjects(testObj, methodId, "timeUnit", java.lang.String.class);
        List<java.lang.String> testPoints_6 = javaTestUtility.getSampleObjects(testObj, methodId, "subject", java.lang.String.class);
        List<java.lang.String> testPoints_7 = javaTestUtility.getSampleObjects(testObj, methodId, "course", java.lang.String.class);
        List<java.lang.Boolean> testPoints_8 = javaTestUtility.getSamplePrimitives(testObj, methodId, "multipleChoice", java.lang.Boolean.class);
        List<java.lang.Boolean> testPoints_9 = javaTestUtility.getSamplePrimitives(testObj, methodId, "freeResponse", java.lang.Boolean.class);
        List<java.lang.Boolean> testPoints_10 = javaTestUtility.getSamplePrimitives(testObj, methodId, "trueFalse", java.lang.Boolean.class);
        List<java.lang.Boolean> testPoints_11 = javaTestUtility.getSamplePrimitives(testObj, methodId, "fillInBlank", java.lang.Boolean.class);
        List<java.lang.Boolean> testPoints_12 = javaTestUtility.getSamplePrimitives(testObj, methodId, "coding", java.lang.Boolean.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size(), testPoints_1.size(), testPoints_2.size(), testPoints_3.size(), testPoints_4.size(), testPoints_5.size(), testPoints_6.size(), testPoints_7.size(), testPoints_8.size(), testPoints_9.size(), testPoints_10.size(), testPoints_11.size(), testPoints_12.size());

        int param_0;
        int param_1;
        int param_2;
        int param_3;
        int param_4;
        java.lang.String param_5;
        java.lang.String param_6;
        java.lang.String param_7;
        boolean param_8;
        boolean param_9;
        boolean param_10;
        boolean param_11;
        boolean param_12;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);
            param_1 = testPoints_1.get(combinations[testComboIndex][1]);
            param_2 = testPoints_2.get(combinations[testComboIndex][2]);
            param_3 = testPoints_3.get(combinations[testComboIndex][3]);
            param_4 = testPoints_4.get(combinations[testComboIndex][4]);
            param_5 = testPoints_5.get(combinations[testComboIndex][5]);
            param_6 = testPoints_6.get(combinations[testComboIndex][6]);
            param_7 = testPoints_7.get(combinations[testComboIndex][7]);
            param_8 = testPoints_8.get(combinations[testComboIndex][8]);
            param_9 = testPoints_9.get(combinations[testComboIndex][9]);
            param_10 = testPoints_10.get(combinations[testComboIndex][10]);
            param_11 = testPoints_11.get(combinations[testComboIndex][11]);
            param_12 = testPoints_12.get(combinations[testComboIndex][12]);

            testObj.genBasicTest(param_0, param_1, param_2, param_3, param_4, param_5, param_6, param_7, param_8, param_9, param_10, param_11, param_12);
            setUp();
        }
    }
    /*End generated tests*/
}
