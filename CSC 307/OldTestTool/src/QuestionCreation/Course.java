package QuestionCreation;

import java.util.Collection;

import Resource.Subject;

/**
 *
 */
public abstract class Course {
    String course;
    Collection<Subject> subject;

    abstract void setCourse(String course);
}
