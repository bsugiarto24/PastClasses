package TestGrading;

import QuestionCreation.Question;

/**
 * QuestionScore keeps track of the Student's score per question. The QuestionScore contains a Question, to associate
 * a score to a specific question. The QuestionScore class will be used inside the TestScore class.
 */
public abstract class QuestionScore {
    /**
     * The Question associated with the score.
     */
    Question question;
    /**
     * The number of points possible that the Student can earn for the Question.
     */
    int pointsPossible;
    /**
     * The number of points that the Student earned for the Question.
     */
    int pointsEarned;
    /**
     * A string that holds the feedback for a question.
     */
    String feedback;
    /**
     * A boolean that determines if the question has been assigned pointsEarned.
     */
    boolean isGraded;

    /**
     * Sets the Question to be associated with the QuestionScore. There is only a setter since we would never
     * change the storage location of a Question's score.
     */
    abstract void setQuestion();

    /**
     * Updates the possible points that the Student can earn for the Question. This number will be retrieved from the
     * Question associated with the QuestionScore.
     * @param points The number of possible points.
     */
    abstract void setPointsPossible(int points);

    /**
     * Retrieves the possible number of points earned on a Question.
     * @return The number of possible points.
     */
    abstract int getPointsPossible();

    /**
     * Updates the points that the Student earned for the Question. The pointsEarned must be less than or equal to the
     * number of pointsPossible. This number cannot be less than 0.
     * @param points The number of points earned.
     */
    abstract void setPointsEarned(int points);

    /**
     * Retrieves the number of points earned on a Question. If the pointsEarned has not been set, this method will
     * return -1.
     * @return The number of points earned.
     */
    abstract int getPointsEarned();

    /**
     * Sets the feedback for the QuestionScore.
     * @param feedback The feedback to be associated with the QuestionScore.
     */
    abstract void addFeedback(String feedback);

    /**
     * Retrieves the feedback for the QuestionScore. If feedback has not been set, this method will return null.
     * @return The current feedback.
     */
    abstract String getFeedback();

    /**
     * Edits the feedback for the QuestionScore. This method will make use of the getFeedback method to first retrieve
     * the current feedback, then update it with the new feedback.
     * @param feedback The updated feedback.
     */
    abstract void editFeedback(String feedback);

    /**
     * Clears the feedback for the QuestionScore.
     */
    abstract void clearFeedback();

    /**
     * Sets the QuestionScore's boolean to true. This method will be called when setPointsEarned is called.
     */
    abstract void setGraded();
}
