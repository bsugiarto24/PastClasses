package TestTool.Model.AdministrativeDetails;

import TestTool.Model.AdministrativeDetails.CourseView;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.AdministrativeDetails.CourseView;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class CourseViewTest
{
    @Before
    public void setUp()
    {
    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.AdministrativeDetails.CourseView.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/bsugiarto/Desktop/CSC 307/TestTool2");
    private File sourceFile = new File("/Users/bsugiarto/Desktop/CSC 307/TestTool2/src/TestTool/Model/AdministrativeDetails/CourseView.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.AdministrativeDetails.CourseView testObj = (TestTool.Model.AdministrativeDetails.CourseView)javaTestUtility.getSampleObject(clazz);


    @Test
    public void addTest_0() throws Exception
    {
        java.util.ArrayList<TestTool.Model.Resource.Course> courses = cloner.deepClone(getFieldValue(testObj, "courses", java.util.ArrayList.class));

        int testComboIndex;

        String methodId = "add_TestTool.Model.Resource.Course";
        List<TestTool.Model.Resource.Course> testPoints_0 = javaTestUtility.getSampleObjects(testObj, methodId, "obj", TestTool.Model.Resource.Course.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        TestTool.Model.Resource.Course param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.add(param_0);
            Assert.assertTrue(javaTestUtility.getFieldValue(testObj, "courses", java.util.ArrayList.class).size() == courses.size() + 1);
            setUp();
        }
    }

    @Test
    public void moreDetailsTest_1() throws Exception
    {
        int testComboIndex;

        String methodId = "moreDetails_int";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "index", java.lang.Integer.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        int param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.moreDetails(param_0);
            setUp();
        }
    }

    @Test
    public void expandTest_2() throws Exception
    {
        int testComboIndex;

        String methodId = "expand_int";
        List<java.lang.Integer> testPoints_0 = javaTestUtility.getSamplePrimitives(testObj, methodId, "index", java.lang.Integer.class);
        int[][] combinations = CombinationSupport.getCombinations(testPoints_0.size());

        int param_0;
        for(testComboIndex = 0; testComboIndex < combinations.length; testComboIndex++)
        {
            param_0 = testPoints_0.get(combinations[testComboIndex][0]);

            testObj.expand(param_0);
            setUp();
        }
    }
    /*End generated tests*/
}