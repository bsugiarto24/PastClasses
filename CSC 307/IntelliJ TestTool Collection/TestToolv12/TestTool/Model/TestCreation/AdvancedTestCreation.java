package TestTool.Model.TestCreation;

import java.util.ArrayList;
import TestTool.Model.TestBank.*;
import TestTool.Model.QuestionBank.*;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.*;
import java.time.LocalDate;
import java.util.Random;

/**
 * Stores the settings to create an advanced test and has a function
 * to create that advanced test.
 *
 * Created by JonathanTan (jtan14@calpoly.edu) on 11/20/15.
 *
 */

public class AdvancedTestCreation {

    /* The name of the Test */
    String testName;

    /* The Number Test Length of the test */
    int testLength;

    /* The unit test length of the test. */
    String testUnits;

    /* The subject of the test so the generator knows which bank to pull from */
    ArrayList<String> subject;

    /* The course number of the subject */
    String course;

    /* An arraylist to keep track of all the options for different questions the user has selected */
    ArrayList<AdvTestOption> advTestOpt;

    /**
     * Generates a test based on the settings specified in the variables.
     *
     * @return returns a random test based on the settings.
     *
    Pre:
    testName != null && testLength != 0 && testUnits != null && subject != null && course != null
     */
    public void genAdvTest(String testName, int testLengthNum, String testLengthUnit, String course, ArrayList<AdvTestOption> advOpt) {

        /* sets the test name to the value. */
        this.testName = testName;

        /* sets the testlength to the value. */
        testLength = testLengthNum;

        /* Sets the testUnit to the value. */
        testUnits = testLengthUnit;

        /* Sets the subject to the value. */
        subject = new ArrayList<String>();

        /* Sets the course to the value. */
        this.course = course;

        /* Sets the testoptions to the value. */
        advTestOpt = advOpt;

        /* Arraylist to hold all the questions the algorithm will randomly choose from
         * Questionbank.
         */
        ArrayList<Question> temp = new ArrayList<>();

        /* Keeps track of total number of questions. */
        int totalQues = 0;

        /* Keep track of total difficuty. */
        int totalDiff = 0;

        /* Adds questions based on each of the AdvTestOpt */
        for (int i = 0; i < advTestOpt.size(); i++) {

            /* creates a new instance of bank options and puts the options in */
            BankOptions bOpt = new BankOptions();
            bOpt.setQuestionType(advTestOpt.get(i).getQuestionType());
            bOpt.setDiff(advTestOpt.get(i).getDifficulty());
            Course cour = new Course(course);
            bOpt.setCourse(cour);
            Subject subj = new Subject(advTestOpt.get(i).getSubSubject());
            subject.add(subj.getName());
            bOpt.setSubj(subj);
            bOpt.setSearch("");

            /* Checks to see if start datebox is null. If it isn't then set it to the value */
            if (advTestOpt.get(i).getStart() != null) {
                bOpt.setStart(advTestOpt.get(i).getStart());
            }

            /* Otherwise set it to null. */
            else {
                bOpt.setStart(null);
            }

            /* Checks to see if end datebox is null. If it isn't then set it to the value */
            if (advTestOpt.get(i).getEnd() != null) {
                bOpt.setEnd(advTestOpt.get(i).getEnd());
            }

            /* Otherwise set it to null. */
            else {
                bOpt.setEnd(null);
            }

            /* Gets an arraylist of the filtered questions from the questionbank. */
            ArrayList<Question> instance = QuestionBank.getInstance().sortAndFilter(bOpt);

            /* counts the number of questions added so that if it reaches limit, it stops */
            int quesAdd = 0;

            /* Creates a random instance to get a random index */
            Random random = new Random();

            /* Goes through the entire arraylist of filtered questions to add it to the final array based
            *  On the specified question limit or if the filtered array runs out of questions to put in.
            */
            while (instance.size() > 0 && quesAdd <= advOpt.get(i).getNumberQuestions()) {

                /* Gets a random number from 0 to the size of the array-1, inclusive*/
                int ran = random.nextInt(instance.size());

                /* adds the question onto the final array */
                temp.add(instance.get(ran));

                /* Adds the difficulty of the question onto total difficulty.*/
                totalDiff += instance.get(ran).getDifficulty();

                /*removes the question from the array so that a question isn't repeated again. */
                instance.remove(ran);

                /* a question has been added so counter to keep track of question added for this option increases. */
                quesAdd++;

                /* increment total questions added. */
                totalQues++;
            }
        }

        int avgDiff;

        if (totalQues != 0)
            avgDiff = (Integer) (totalDiff / totalQues);

        else
            avgDiff = 1;


        for (int i =0; i < subject.size(); i ++) {
            System.out.println(subject.get(i));
        }

        /* Creates the new Test with the given parameters. */
        Test newTest = new Test(temp, avgDiff, testLength, subject, testName, course);

        /* Adds the new test to the test bank arraylist. */
        TestBank.getInstance().getBank().add(newTest);

    }

}