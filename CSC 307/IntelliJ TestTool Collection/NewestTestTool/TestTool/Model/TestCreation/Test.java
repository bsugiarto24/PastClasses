package TestTool.Model.TestCreation;

import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.SubjectCollection;

import java.util.ArrayList;

/**
* A test is a collection of questions and contains basic test
* information such as test difficulty, name, course, subject, number of questions, and time.
 *
 *  Created by Brandon Vo (brvo@calpoly.edu) on 11/20/15.
*/
public class Test {

    /*The list of questions for the test*/
    private ArrayList<Question> questions;

    /*The name of the test*/
    private String name;

    /*The course the test falls under*/
    private Course course;

    /*The subject the test covers*/
    private Subject subject;

    /*The number of questions on the test*/
    private int numQuestions;

    /*The difficulty of the test*/
    private int difficulty;

    /*The time limit of the test in minutes*/
    private int timeLimit;


    public Test(ArrayList<Question> questions, int difficulty, int timeLimit, String subject, String name, String course){
        this.questions = questions;
        this.numQuestions = questions.size();
        this.difficulty = difficulty;
        this.timeLimit = timeLimit;
        this.subject = SubjectCollection.getInstance().findSubject(subject);
        this.course = CourseCollection.getInstance().findCourse(course);
        this.name = name;
    }


    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getNumQuestions(){
        return numQuestions;
    }

    public String getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    public Course getCourse() {
        return course;
    }


}

