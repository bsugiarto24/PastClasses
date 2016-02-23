package TestTool.Model.TestCreation;

import TestTool.Model.QuestionCreation.*;
import java.util.Collection;

/**
* A test is a collection of questions and contains basic test
* information such as test difficulty, test time, and test subject.
*/
public abstract class Test {
    Collection<Question> test;
    int difficulty;
    int time;
    String subject;

}

