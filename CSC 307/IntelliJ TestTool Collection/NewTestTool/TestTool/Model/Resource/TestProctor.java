package TestTool.Model.Resource;

/**
* TestProctor is a type of user. TestProctors will have access to some Teacher functions (such as test grading) and Statistics.
*/
public abstract class TestProctor extends User {
    public TestProctor(final String password, final String login, final String name) {
        super(password, login, name);
    }
}