package TestTool.Model.Resource;

/**
* TestTaker is a type of user. TestTakers will have access to test taking and viewing their personal scores.
*/
public class TestTaker extends User {
    public TestTaker(final String password, final String login, final String name) {
        super(password, login, name);
    }

}