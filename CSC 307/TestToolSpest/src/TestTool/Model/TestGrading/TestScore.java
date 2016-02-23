package TestTool.Model.TestGrading;

import TestTool.Model.TestCreation.Test;

import java.util.Collection;

/**
 * TestScore holds the overall score and progress of scoring for a test. A TestScore is associated with a Test, which
 * holds all of the Questions to be scored. This class also holds a collection of QuestionScores.
 */
public abstract class TestScore extends Test {
    Collection<QuestionScore> questionScores;
    int questionCount;
    int graded;
    int possiblePoints;
    int earnedPoints;

    /**
     * Initializes the questionScores collection based on the Questions associated with the Test.
     */
    abstract void addQuestionScores();

    /**
     * Sets the number of Questions to be graded. This method is called only when setTest is called.
     * @param graded The number of Questions to be graded.
     */
    abstract void setQuestionCount(int graded);

    /**
     * Sets the number of Questions that have been graded. Makes use of the isGraded boolean in the QuestionScore
     * class to synchronize the number of graded questions.
     */
    abstract void setGraded();

    /**
     * Gets the current progress of test grading
     * @return A decimal number representing the current progress.
     */
    abstract double getProgress();
}
