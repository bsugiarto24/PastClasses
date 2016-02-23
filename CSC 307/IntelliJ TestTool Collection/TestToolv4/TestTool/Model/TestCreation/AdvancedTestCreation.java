package TestTool.Model.TestCreation;

import java.util.ArrayList;
import TestTool.Model.TestBank.*;
import TestTool.Model.QuestionBank.*;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.*;

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
	String subject;

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
        this.subject = subject;

        /* Sets the course to the value. */
        this.course = course;

        /* Sets the testoptions to the value. */
        advTestOpt = advOpt;

        /* Arraylist to hold all the questions the algorithm will randomly choose from
         * Questionbank.
         */
        ArrayList<Question> temp = new ArrayList<>();

        /* Keeps track of total number of questions. */
        int total = 0;

        /* Adds questions based on each of the AdvTestOpt */
        for (int i = 0; i < advTestOpt.size(); i++) {

            /* creates a new instance of bank options and puts the options in */
            BankOptions bOpt = new BankOptions();
            bOpt.setQuestionType(advTestOpt.get(i).getQuestionType());
            bOpt.setDiff(advTestOpt.get(i).getDifficulty());
            Course cour = new Course(course);
            bOpt.setCourse(cour);
            Subject subj = new Subject(advTestOpt.get(i).getSubSubject());
            bOpt.setSubj(subj);
            bOpt.setSearch("");

            /* Gets an arraylist of the filtered questions from the questionbank. */
            ArrayList<Question> instance = QuestionBank.getInstance().sortAndFilter(bOpt);

            /* Goes through the entire arraylist of filtered questions to add it to the final array. */
            for (int j = 0; j < instance.size(); j++) {
                temp.add(instance.get(j));

                /* increments total to count the total amount of questions added. */
                total++;
            }
        }

        /* Creates the new Test with the given parameters. */
        Test newTest = new Test(temp, advTestOpt.get(0).getDifficulty(), testLength, subject, testName, course);

        /* Adds the new test to the test bank arraylist. */
        TestBank.getInstance().getBank().add(newTest);

	}


}