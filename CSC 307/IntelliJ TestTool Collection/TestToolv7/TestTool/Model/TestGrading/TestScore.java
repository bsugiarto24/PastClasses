package TestTool.Model.TestGrading;

import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.TestCreation.StudentTest;

import java.io.Serializable;

/**
 * TestScore holds the overall score and progress of scoring for a test. A TestScore is always incorporated as a private
 * instance variable within a StudentTest, which holds all of the Questions to be scored.
 *
 * Created by Michael Golahi (mgolahi@calpoly.edu) on 11/10/15.
 */
public class TestScore implements Serializable {
    /**
     * The total count of questions in a StudentTest.
     */
    int totalCount;
    /**
     * The count of graded questions in a StudentTest - this variable will be updated whenever.
     */
    int gradedCount;
    /**
     * The number of points possible in a test (calculated by all the points for questions).
     */
    double possiblePoints;
    /**
     * The number of points earned in a test.
     */
    double earnedPoints;
    /**
     * A boolean set if all of the questions are graded.
     */
    boolean complete;

    /**
     * Initializes a TestScore based on a StudentTest
     * @param test Takes in a StudentTest
     */
    public TestScore(StudentTest test) {
        this.totalCount = test.getQuestions().size();
        this.gradedCount = 0;
        this.earnedPoints = 0;
        int possible = 0;
        /*Calculates the total number of possible points from all the questions in a StudentTest*/
        for (Question question : test.getQuestions()) {
            possible += question.getPoints();
        }
        this.possiblePoints = possible;
        this.complete = false;
    }

    /**
     * Sets the number of Questions that have been gradedCount. Makes use of the isGraded boolean in the QuestionScore
     * class to synchronize the number of gradedCount questions.
     */
    public void setGradedCount(int gradedCount) {
        this.gradedCount = gradedCount;
    }

    /**
     * Increments the number of graded questions (gradedCount) by 1
     */
    public void updateGradedCount() {
        this.gradedCount++;
    }

    public void setEarnedPoints(int points) {
        this.earnedPoints = points;
    }

    /**
     * Increments the earned points by the points parameter. To negate points, the user passes in a negative value.
     * @param points The number of points to update by
     */
    public void updateEarnedPoints(double points) {
        this.earnedPoints += points;
    }

    /**
     * Gets the current progress of test grading.
     * @return A decimal number representing the current progress.
     */
    public double getProgress() {
        return ((double)gradedCount) / totalCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getGradedCount() {
        return gradedCount;
    }

    public void setComplete() {
        complete = Double.compare(getProgress(), 1.0) == 0;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setEarnedPoints(final double earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public void setPossiblePoints(final double possiblePoints) {
        this.possiblePoints = possiblePoints;
    }

    public double getPossiblePoints() {
        return possiblePoints;
    }

    public double getEarnedPoints() {
        return earnedPoints;
    }
}
