package TestTool.Model.TestCreation;

import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestGrading.TestScore;

import java.util.ArrayList;

/**
 * An studentTest contains the test and the name of the student. It extends the Test class.
 *
 *  Created by Brandon Vo (brvo@calpoly.edu) on 11/20/15.
 */
public class StudentTest extends Test {

    /*The name of the student */
    private String student;

    /*The score of the test after it has been graded*/
    private TestScore score;


    public StudentTest(ArrayList<Question> questions, int difficulty, int timeLimit, String subject, String name,
                       String course, String student){
        super(questions, difficulty, timeLimit, subject, name, course);
        this.student = student;
        this.score = new TestScore(this);
    }

    public StudentTest(Test test, String student){
        super(test.getQuestions(), test.getDifficulty(), test.getTimeLimit(), test.getSubject().getName(),
                test.getName(), test.getCourse().getName());
        this.student = student;
        this.score = new TestScore(this);
    }

    public String getStudent() {
        return student;
    }

    public TestScore getScore() {
        return score;
    }

}
