package TestTool.Model.TestCreation;

import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.SubjectCollection;
import TestTool.Model.TestGrading.QuestionScore;

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


    public Test(ArrayList<Question> questions, int difficulty, int timeLimit, String subject, String name, String course) {
        this.questions = getNewQuestions(questions);
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

    public int getNumQuestions() {
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


    public ArrayList<Question> getNewQuestions(ArrayList<Question> questions) {
        ArrayList<Question> newQuestions = new ArrayList<>();
        for (Question question : questions) {
           if (question instanceof Coding) {
                Coding quest = new Coding();
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setCreator(question.getCreator());
                quest.setScore(new QuestionScore());
                quest.setAnswer(((Coding) question).getAnswer());
                quest.setFlags(((Coding) question).getFlags());
                newQuestions.add(quest);

            } else if (question instanceof FillInTheBlank) {
                FillInTheBlank quest = new FillInTheBlank();
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setCreator(question.getCreator());
                quest.setScore(new QuestionScore());
                quest.setAnswer(((FillInTheBlank) question).getAnswer());
                newQuestions.add(quest);

            } else if (question instanceof FreeResponse) {
                FreeResponse quest = new FreeResponse();
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setCreator(question.getCreator());
                quest.setScore(new QuestionScore());
                quest.setAnswer(((FreeResponse) question).getAnswer());
                quest.setFlags(((FreeResponse) question).getFlags());
                newQuestions.add(quest);

            } else if (question instanceof MultipleChoice) {
                MultipleChoice quest = new MultipleChoice();
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setCreator(question.getCreator());
                quest.setScore(new QuestionScore());
                quest.setAnswer(((MultipleChoice) question).getAnswer());
                quest.setOption(((MultipleChoice) question).getOptions());
                newQuestions.add(quest);

            } else if (question instanceof TrueFalse) {
                TrueFalse quest = new TrueFalse();
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setScore(new QuestionScore());
                quest.setCreator(question.getCreator());
                quest.setAnswer(((TrueFalse) question).getAnswer());
                newQuestions.add(quest);
            }
        }
        return newQuestions;
    }
}

