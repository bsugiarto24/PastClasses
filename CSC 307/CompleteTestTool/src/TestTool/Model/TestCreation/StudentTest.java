package TestTool.Model.TestCreation;

import TestTool.Model.QuestionCreation.Question;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by brvo on 11/24/15.
 */
public class StudentTest extends Test {
    private String student;

    public StudentTest(ArrayList<Question> test, int difficulty, int timeLimit, String subject, String name,
                       String course, String student){
        super(test, difficulty, timeLimit, subject, name, course);
        this.student = student;
    }

    public String getStudent() {
        return student;
    }

}
