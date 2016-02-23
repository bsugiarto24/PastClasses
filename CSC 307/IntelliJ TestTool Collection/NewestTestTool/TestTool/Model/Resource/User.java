package TestTool.Model.Resource;

import java.util.HashMap;

/**
* A user is anyone with the credentials to access the tool. They have a unique login and a password.
*/
public abstract class User {
    String login;
    String password;
    String name;
    static User loggedIn;
    static HashMap<String, User> users = new HashMap<String, User>();


    public User(final String password, final String login, final String name) {
        this.password = password;
        this.login = login;
        this.name = name;
        addToDB(this);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    private void addToDB(User user) {
        users.put(user.getLogin(),user);
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }


    public static User getUserLoggedIn(){
        return loggedIn;
    }

    public static void setUserLoggedIn(User loggedIn){
        User.loggedIn = loggedIn;
    }
}