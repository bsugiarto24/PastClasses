package TestTool.Model.TestCreation;

/**
 * The TestCreationException acts as the exception thrown when a test object cannot be created.
 * It is caught in the view and then a ui alert is shown to the user.
 *
 *  Created by Brandon Vo (brvo@calpoly.edu) on 11/20/15.
 */
public class TestCreationException extends Exception{
    private String message;

    public TestCreationException(){
        super();
    }

    public TestCreationException(String message){
        super(message);
        this.message = message;
    }

    public TestCreationException(Throwable cause){
        super(cause);
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
