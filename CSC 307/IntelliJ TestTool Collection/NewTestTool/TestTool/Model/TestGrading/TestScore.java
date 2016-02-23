package TestTool.Model.TestGrading;

import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestCreation.StudentTest;
import TestTool.Model.TestCreation.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * TestScore holds the overall score and progress of scoring for a test. A TestScore is associated with a Test, which
 * holds all of the Questions to be scored. This class also holds a collection of QuestionScores.
 */
public class TestScore {
    int questionCount;
    int graded;
    double possiblePoints;
    double earnedPoints;

    public TestScore(StudentTest test) {
        this.questionCount = test.getQuestions().size();
        this.graded = 0;
        this.earnedPoints = 0;
        int possible = 0;
        for (Question question : test.getQuestions()) {
            possible += question.getPoints();
        }
        this.possiblePoints = possible;
    }

    /**
     * Sets the number of Questions that have been graded. Makes use of the isGraded boolean in the QuestionScore
     * class to synchronize the number of graded questions.
     */
    public void setGraded(int graded) {
        this.graded = graded;
    }

    /**
     * Gets the current progress of test grading
     * @return A decimal number representing the current progress.
     */
    public double getProgress() {
        return graded / questionCount;
    }
}
