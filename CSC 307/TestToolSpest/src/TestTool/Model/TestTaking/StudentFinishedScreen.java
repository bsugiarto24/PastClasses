package TestTool.Model.TestTaking;

import TestTool.Model.TestTaking.StudentAnswer;
import TestTool.Model.TestTaking.StudentLogin;
import TestTool.Model.TestCreation.Test;
import java.util.*;

/**
 * Created by Dylan on 11/9/15.
 */
public abstract class StudentFinishedScreen extends StudentLogin {

    /*
     * @param testNum for test number
     * @return a String of question.
     */

    public abstract String getTestName(int testNum);


    /*
     * contains all datas that needed for Home Screen to populate
     */
    public static void takeStudentToHomeScreen() {
        System.out.println("took student to home screen");
    }
}
