package TestTool.Model.TestGrading;

import TestTool.Model.QuestionCreation.Question;

/**
 * QuestionScore keeps track of the Student's score per question. The QuestionScore contains a Question, to associate
 * a score to a specific question. The QuestionScore class will be used inside the TestScore class.
 */
public abstract class QuestionScore extends Question {
    /**
     * The number of points that the Student earned for the Question. Will be initialized to -1.
     */
    double pointsEarned;
    /**
     * A string that holds the feedback for a question.
     */
    String feedback;
    /**
     * A boolean that determines if the question has been assigned pointsEarned.
     */
    boolean isGraded;

    /**
     * Updates the points that the Student earned for the Question. The pointsEarned must be less than or equal to the
     * number of pointsPossible. This number cannot be less than 0.
     * @param points The number of points earned.
     *
     * pre:
     *  points >= 0 && points < this.points;
     *
     * post:
     *  this.pointsEarned == points;
     */
    abstract void setPointsEarned(int points);

    /**
     * Retrieves the number of points earned on a Question. If the pointsEarned has not been set, this method will
     * return -1.
     * @return The number of points earned.
     *
     * post:
     *  if (this.pointsEarned >= 0) (return == -1) else (return == this.pointsEarned);
     */
    abstract int getPointsEarned();

    /**
     * Sets the feedback for the QuestionScore.
     * @param feedback The feedback to be associated with the QuestionScore.
     *
     * post:
     *  this.feedback == feedback;
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

    public static void markCorrect() {
        System.out.println("marking correct!");
    }

    public static void markIncorrect() {
        System.out.println("marking incorrect!");
    }

    public static void save() {
        System.out.println("saving...");
    }

    public static void back() {
        System.out.println("going back...");
    }

}
