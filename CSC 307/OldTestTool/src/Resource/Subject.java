package Resource;

/**
 * Subject represents a CalPoly Subject.
 */
public abstract class Subject {
    /**
     * The identifier for the Subject.
     */
    String subject;

    /**
     * Sets the identifier of the Subject.
     * @param subject The identifier of the Subject.
     */
    abstract void setSubject(String subject);

    /**
     * Retrieves the identifier of the Subject.
     * @return The identifier of the Subject.
     */
    abstract String getName();
}
