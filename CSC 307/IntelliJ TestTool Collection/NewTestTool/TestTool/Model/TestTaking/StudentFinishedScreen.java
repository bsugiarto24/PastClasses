package TestTool.Model.TestTaking;

import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.TestTaking.StudentLogin;
import TestTool.Model.TestCreation.Test;
import java.util.*;

/**
 * Created by Dylan on 11/9/15.
 */
public class StudentFinishedScreen extends TestTaking {


    //removes the test from the array list of assigned tests.
    public static void removeTookedTest() {
        removeTest(StudentLogin.returnTestNum());
    }

    /*
     * contains all datas that needed for Home Screen to populate
     */
    public static void takeStudentToHomeScreen() {
        System.out.println("took student to home screen");
    }
}
