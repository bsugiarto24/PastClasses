package TestTool.Model.Resource;

/**
* TestMaker is a type of User and has access to Test Creation, Test Bank, Question Bank, Teacher Functions, and Statistics.
*/
public class TestMaker extends TestTaker {
    public TestMaker(final String password, final String login, final String name) {
        super(password, login, name);
    }
}