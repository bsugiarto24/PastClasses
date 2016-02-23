package TestTool.Model.Resource;

import java.util.Collection;

/**
 * Course represents a CalPoly course. A Course is associated with a collection of subjects.
 * EX: CSC 103 can be associated with data structures, algorithms, etc.
 */
public abstract class Course {
    /**
     * The identifier for the Course.
     */
    String course;
    /**
     * The collection of Subjects associated with the Course.
     */
    Collection<Subject> subject;

    /**
     * Sets the identifier of the Course.
     * @param course The identifier of the Course.
     */
    abstract void setCourse(String course);

    /**
     * Retrieves the identifier of the Course.
     * @return The identifier of the Course.
     */
    abstract String getName();

    /**
     * Adds a Subject to be associated with the Course.
     * @param subject A Subject to be associated with the Course.
     */
    abstract void addSubject(Subject subject);

    /**
     * Removes a Subject from the collection.
     * @param subject A Subject to be disassociated from the Course.
     */
    abstract void removeSubject(Subject subject);
}
