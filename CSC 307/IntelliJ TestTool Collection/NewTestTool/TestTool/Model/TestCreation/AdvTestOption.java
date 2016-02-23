package TestTool.Model.TestCreation;

/**
 * Keeps track of the dynamic options in the advanced test.
 *
 *
 * Created by JonathanTan (jtan14@calpoly.edu) on 11/28/15.
 */
public class AdvTestOption {


    private int numberQuestions;
    private int difficulty;
    private String questionType;
    private String subSubject;

    public AdvTestOption(int numQ, int diff, String quesType, String subSubj) {
        numberQuestions = numQ;
        difficulty = diff;
        questionType = quesType;
        subSubject = subSubj;
    }

    public int getNumberQuestions() {
        return this.numberQuestions;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public String getSubSubject() {
        return this.subSubject;
    }

}
