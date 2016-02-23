package TestTool.Model.Resource;

/**
 * Subject represents a CalPoly Subject.
 */
public class Subject {
    /**
     * The identifier for the Subject.
     */
    String subject;

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
}
