package TestTool.Model.AdministrativeDetails;

import TestTool.Model.AdministrativeDetails.StudentView;
import testing.CombinationSupport;

import org.junit.runner.RunWith;
import testing.runner.SpestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import testing.JavaTestUtility;
import format.ClassNameFormat;
import TestTool.Model.AdministrativeDetails.StudentView;

import java.io.File;
import com.rits.cloning.Cloner;

import java.util.*;

import static testing.JavaTestUtility.getFieldValue;

@RunWith(SpestRunner.class)
public class StudentViewTest
{
    @Before
    public void setUp()
    {
    }

    /*Start generated tests*/
    private Class clazz = TestTool.Model.AdministrativeDetails.StudentView.class;

    private Cloner cloner = new Cloner();
    private File rootDirectory = new File("/Users/bsugiarto/Desktop/CSC 307/TestTool2");
    private File sourceFile = new File("/Users/bsugiarto/Desktop/CSC 307/TestTool2/src/TestTool/Model/AdministrativeDetails/StudentView.java");
    private JavaTestUtility javaTestUtility = new JavaTestUtility(rootDirectory, sourceFile, false);
    private TestTool.Model.AdministrativeDetails.StudentView testObj = (TestTool.Model.AdministrativeDetails.StudentView)javaTestUtility.getSampleObject(clazz);

    /*End generated tests*/
}
