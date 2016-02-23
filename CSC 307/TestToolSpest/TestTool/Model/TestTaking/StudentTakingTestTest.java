package TestTool.Model.TestTaking;

import TestTool.Model.TestTaking.StudentTakingTest;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.TestTaking.StudentTakingTest;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class StudentTakingTestTest
{
    @Before
    public void setUp()
    {
    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.TestTaking.StudentTakingTest.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/bsugiarto/Desktop/CSC 307/TestTool2");
    private File sourceFile = new File("/Users/bsugiarto/Desktop/CSC 307/TestTool2/src/TestTool/Model/TestTaking/StudentTakingTest.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.TestTaking.StudentTakingTest testObj = (TestTool.Model.TestTaking.StudentTakingTest)javaTestUtility.getSampleObject(clazz);

    /*End generated tests*/
}
