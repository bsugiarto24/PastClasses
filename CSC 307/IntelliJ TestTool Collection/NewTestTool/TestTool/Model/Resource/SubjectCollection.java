package TestTool.Model.Resource;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The collection of Subjects available. Currently, this collection is a universal representation of the Subjects
 * available for one professors. However, we wish to implement this test tool for multiple professors, and as such,
 * a professor will have ownership over a SubjectCollection in a future implementation. This allows our tool to
 * distinguish which professor teaches which subjects.
 */
public class SubjectCollection {

    private static SubjectCollection instance = new SubjectCollection();

    /**
     * The collection of Subjects.
     */
    private HashMap<String, Subject> subjects;

    private SubjectCollection() {
        subjects = new HashMap<>();
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
     * @param oldC Subject to replace.
     * @param newC Subject to add.
     */
    public void changeSubject(Subject oldC, Subject newC){
        if(oldC.getName().equals(newC.getName())) {
            subjects.remove(oldC.getName());
            subjects.put(newC.getName(), newC);
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
    }

    public ArrayList<String> getAllSubjects() {
        ArrayList<String> allSubjects = new ArrayList<>();

        for (Subject subject: subjects.values()) {
            allSubjects.add(subject.toString());
        }

        return allSubjects;
    }

    public static SubjectCollection getInstance() {
        return instance;
    }
}
