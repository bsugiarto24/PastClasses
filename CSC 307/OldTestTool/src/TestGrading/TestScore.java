package TestGrading;

import TestCreation.*;

import java.util.Collection;

import QuestionCreation.Question;

/**
 * TestScore holds the overall score and progress of scoring for a test. A TestScore is associated with a Test, which
 * holds all of the Questions to be scored. This class also holds a collection of QuestionScores.
 */
public abstract class TestScore {
    test test;
    Collection<QuestionScore> questionScores;
    int questionCount;
    int graded;
    int possiblePoints;
    int earnedPoints;

    /**
     * Sets the Test to be associated with the TestScore. There is only a setter since we would never
     * change the storage location of a Test's score. Upon setting the Test, the questionScores collection will be
     * updated by calling addQuestionScore for all the Questions in the Test. setQuestionCount will also be called.
     * @param test The test to be associated with the TestScore.
     */
    abstract void setTest(test test);

    /**
     * Creates and adds a new QuestionScore for the Question to the collection of QuestionScores. This will only be
     * called when the method setTest is called.
     * @param question The question to be added.
     */
    abstract void addQuestionScore(Question question);

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
