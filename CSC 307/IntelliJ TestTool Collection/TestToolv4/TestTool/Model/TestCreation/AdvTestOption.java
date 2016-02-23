package TestTool.Model.TestCreation;

/**
 * Keeps track of the dynamic options in the advanced test.
 *
 * Created by JonathanTan (jtan14@calpoly.edu) on 11/28/15.
 */
public class AdvTestOption {

    /* The number of questions in the test. */
    private int numberQuestions;

    /* The difficulty of the question. */
    private int difficulty;

    /* The question Type. */
    private String questionType;

    /* The subSubject of the question. */
    private String subSubject;

    /*
     * The advanced test option constructor.
     */
    public AdvTestOption(int numQ, int diff, String quesType, String subSubj) {
        numberQuestions = numQ;
        difficulty = diff;
        questionType = quesType;
        subSubject = subSubj;
    }

    /**
     * gives thes number of questions setting
     * @return the number of questions
     */
    public int getNumberQuestions() {
        return this.numberQuestions;
    }

    /**
     * The difficulty of the question
     * @return the difficulty number of the question
     */
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * The question type of question setting
     * @return the question type of setting.
     */
    public String getQuestionType() {
        return this.questionType;
    }

    /**
     * The subsubject of the question setting
     * @return the question type of the subject.
     */
    public String getSubSubject() {
        return this.subSubject;
    }

}
