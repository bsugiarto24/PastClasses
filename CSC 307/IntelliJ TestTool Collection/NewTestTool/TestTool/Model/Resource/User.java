package TestTool.Model.Resource;

/**
* A user is anyone with the credentials to access the tool. They have a unique login and a password.
*/
public abstract class User {
    String login;
    String password;
    String name;
    static User loggedIn;


    public User(final String password, final String login, final String name) {
        this.password = password;
        this.login = login;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static User getUserLoggedIn(){
        return loggedIn;
    }

    public static void getUserLoggedIn(User loggedIn){
        User.loggedIn = loggedIn;
    }
}