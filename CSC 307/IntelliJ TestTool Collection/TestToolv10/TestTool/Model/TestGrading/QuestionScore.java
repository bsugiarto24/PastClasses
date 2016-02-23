package TestTool.Model.TestGrading;

import java.io.Serializable;

/**
 * QuestionScore keeps track of the Student's score per question. A QuestionScore is always incorporated as a private
 * instance variable within a Question.
 *
 * Created by Michael Golahi (mgolahi@calpoly.edu) on 11/10/15.
 */
public class QuestionScore implements Serializable {
    /**
     * The number of points that the Student earned for the Question. Will be initialized to -1.
     */
    double pointsEarned;
    /**
     * A string that holds the feedback for a question.
     */
    String feedback;
    /**
     * A boolean that determines if the question has been assigned pointsEarned. This is set to true if a grader scores
     * the test in any way (auto graded, manually grading by inputting points, manually grading by marking correct,
     * manually grading by marking incorrect, etc).
     */
    boolean isGraded;
    /**
     * Boolean that determines if the question qualifies for auto grading (T/F, MC, FITB).
     */
    boolean autoGraded;

    /**
     * Creates an instance of a QuestionScore.
     */
    public QuestionScore() {
        this.pointsEarned = 0;
        this.feedback = null;
        this.isGraded = false;
    }

    /**
     * Updates the points that the Student earned for the Question. The pointsEarned must be less than or equal to the
     * number of pointsPossible. This number cannot be less than 0.
     * @param points The number of points earned.
     *
     */
    public void setPointsEarned(double points) {
        this.pointsEarned = points;
    }

    /**
     * Retrieves the number of points earned on a Question.
     * @return The number of points earned.
     *
     */
    public double getPointsEarned() {
        return pointsEarned;
    }

    /**
     * Sets the feedback for the QuestionScore.
     * @param feedback The feedback to be associated with the QuestionScore.
     *
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * Retrieves the feedback for the QuestionScore. If feedback has not been set, this method will return null.
     * @return The current feedback.
     *
     */
    public String getFeedback(){
        return feedback;
    }

    /**
     * Clears the feedback for the QuestionScore.
     */
    public void clearFeedback() {
        this.feedback = null;
    }

    /**
     * Sets the QuestionScore's boolean to true. This method will be called when setPointsEarned is called.
     */
    public void setGraded() {
        isGraded = true;
    }

    /**
     * Set's the auto graded boolean to true.
     */
    public void setAutoGraded() {
        autoGraded = true;
    }

    public boolean isGraded() {
        return isGraded;
    }

    public boolean isAutoGraded() {
        return autoGraded;
    }
}
