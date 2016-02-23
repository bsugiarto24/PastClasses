package TestTool.Model.Resource;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The collection of Subjects available. Currently, this collection is a universal representation of the Subjects
 * available for one professors. However, we wish to implement this test tool for multiple professors, and as such,
 * a professor will have ownership over a SubjectCollection in a future implementation. This allows our tool to
 * distinguish which professor teaches which subjects.
 *
 * This is implemented using the singleton design pattern.
 *
 * Created by Michael Golahi (mgolahi@calpoly.edu) on 11/10/15.
 */
public class SubjectCollection {

    /**
     * Singleton instance of the SubjectCollection.
     */
    private static SubjectCollection instance = new SubjectCollection();

    /**
     * The collection of Subjects.
     */
    private HashMap<String, Subject> subjects;

    /**
     * Private constructor to instantiate the SubjectCollection.
     */
    private SubjectCollection() {
        subjects = new HashMap<>();
    }

    public HashMap<String, Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<String, Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * Add the given Subject to the SubjectCollection. The Subject's name must not be the same as a Subject already
     * in the collection.
     * @param subject The Subject to add to the collection.
     */
    public void addSubject(Subject subject){
        subjects.put(subject.getName(), subject);
    }

    /**
     * Find the Subject by the real-world name.
     * @param name The name of the subject.
     */
    public Subject findSubject(String name){
        return subjects.get(name);
    }

    /**
     * Change the given old Subject to the given new Subject. The old and new records must not be the same. The old
     * record must already be in the SubjectCollection. The new Subject must meet the same conditions as for the input
     * to the addSubject operation. Typically, the user runs the findSubject operation prior to changeSubject to locate
     * an existing record to be changed.
     * @param oldS Subject to replace.
     * @param newS Subject to add.

       pre:
        oldS != null && newS != null && !oldS.equals(newS) && subjects.containsValue(oldS) &&
        newS.getName() != null;
                   
       post:
        forall ( Subject s_other ;
            subjects'.containsValue(s_other) iff
                s_other.equals(newS) ||
                    (subjects.containsValue(s_other) &&
                        !s_other.equals(oldS)));
     */
    public void changeSubject(Subject oldS, Subject newS){
        if(oldS.getName().equals(newS.getName())) {
            subjects.remove(oldS.getName());
            subjects.put(newS.getName(), newS);
        }
    }

    /**
     * Delete the given Subject from the given SubjectCollection. The given Subject must already be in the
     * SubjectCollection. Typically the user runs the findSubject operation prior to deleteSubject to locate an existing
     * record to delete.
     * @param subject The subject to delete.
     */
    public void deleteSubject(Subject subject){
        subjects.remove(subject.getName());
        System.out.println(subjects);
    }

    /**
     * Gets all of the subjects in an ArrayList of Strings.
     * @return The ArrayList of all subjects.

       pre:
        subjects != null;

       post:
        forall ( Subject s_other ; subjects.containsValue(s_other) ;
            return.contains(s_other.toString()));
     */
    public ArrayList<String> getAllSubjects() {
        ArrayList<String> allSubjects = new ArrayList<>();

        for (Subject subject: subjects.values()) {
            allSubjects.add(subject.toString());
        }

        return allSubjects;
    }

    /**
     * Gets all of the subjects as their object references in the form of an ArrayList.
     * @return The ArrayList of all Subject object subjects.

       pre:
        subjects != null;

       post:
        forall ( Subject s_other ; subjects.containsValue(s_other) ;
            return.contains(s_other));
     */
    public ArrayList<Subject> getAllSubjectList() {
        ArrayList<Subject> allSubjects = new ArrayList<>();

        for (Subject subject: subjects.values()) {
            allSubjects.add(subject);
        }

        return allSubjects;
    }

    /**
     * Gets the singleton instance of the SubjectCollection.
     * @return The single HashMap instance.
     */
    public static SubjectCollection getInstance() {
        return instance;
    }
}
