package TestTool.Model.TestCreation;

import TestTool.Model.QuestionCreation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
* A test is a collection of questions and contains basic test
* information such as test difficulty, test time, and test subject.
*/
public class Test {
    private ArrayList<Question> test;
    private int difficulty;
    private int timeLimit;
    private String subject;
    private String name;
    private String course;

    public Test(ArrayList<Question> test, int difficulty, int timeLimit, String subject, String name, String course){
        this.test = test;
        this.difficulty = difficulty;
        this.timeLimit = timeLimit;
        this.subject = subject;
        this.name = name;
        this.course = course;
    }

    public ArrayList<Question> getTest() {
        return test;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getCourse() {
        return course;
    }
}

