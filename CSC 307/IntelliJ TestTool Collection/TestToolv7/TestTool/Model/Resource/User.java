package TestTool.Model.Resource;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
* A user is anyone with the credentials to access the tool. They have a unique login and a password.
*/
public abstract class User implements Serializable{
    String login;
    String password;
    String name;
    ArrayList<Course> courses;
    static User loggedIn;

    public static HashMap<String, User> users = new HashMap<String, User>();


    public User(final String password, final String login, final String name) {
        this.password = password;
        this.login = login;
        this.name = name;
        courses = new ArrayList<Course>();
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
        users.put(user.login, user);
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

    public ArrayList<Course> getCourses() {return courses;}
}