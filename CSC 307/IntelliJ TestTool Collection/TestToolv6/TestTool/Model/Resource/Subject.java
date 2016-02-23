package TestTool.Model.Resource;

import java.io.Serializable;

/**
 * Subject represents a CalPoly Subject. Subjects are associated with Courses.
 * EX: Algorithms, Dynamic Programming, etc.
 *
 * Created by Michael Golahi (mgolahi@calpoly.edu) on 11/10/15.
 */
public class Subject implements Serializable{
    /**
     * The identifier for the Subject.
     */
    String subject;

    /**
     * Constructs a subject based on the passed in String.
     * @param s A String that identifes a Subject.
     */
    public Subject(String s) {
    	subject = s;
    }
    
    /**
     * Sets the identifier of the Subject.
     * @param subject The identifier of the Subject.
     */
    public void setSubject(String subject) {
    	this.subject = subject;
    }

    /**
     * Retrieves the identifier of the Subject.
     * @return The identifier of the Subject.
     */
    public String getName() {
    	return subject;
    }

    /**
     * Implemented so that Subject type can be used for TableColumns in JavaFX.
     * @return The String that represents a Subject.
     */
    @Override
    public String toString() {
        return subject;
    }
}
