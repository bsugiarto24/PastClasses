package TestTool.Model.Resource;

/**
* A user is anyone with the credentials to access the tool. They have a unique login and a password.
*/
public abstract class User {
   String login;
   String password;
   String name;


    public String getName() {
        return name;
    }
}