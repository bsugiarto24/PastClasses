package TestTool.Model.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mgolahi on 12/9/15.
 */
public class SubjectCollectionTest {
    /**
     * Resets the SubjectCollection (to remove conflicts) and then adds 2 Subjects - CPE101 and CPE 102.
     */
    @Before
    public void init() {
        SubjectCollection.getInstance().reset();
        Subject CPE101 = new Subject("Programming Languages");
        SubjectCollection.getInstance().addSubject(CPE101);

        Subject CPE102 = new Subject("Fundamentals");
        SubjectCollection.getInstance().addSubject(CPE102);
    }

    /**
     * Resets the SubjectCollection to avoid conflicts in between tests.
     */
    @After
    public void cleanup() {
        SubjectCollection.getInstance().reset();
    }

    @Test
    public void testAdd() {
        /*Create a new subject*/
        Subject newSubject = new Subject("Test Subject");
        /*Copy the old collection to use for verification*/
        HashMap<String, Subject> oldCollection = new HashMap<>(SubjectCollection.getInstance().getSubjects());

        /*Add the new Subject*/
        SubjectCollection.getInstance().addSubject(newSubject);
        /*Verify the new Subject has been added*/
        Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsValue(newSubject));
        Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsKey(newSubject.toString()));

        /*Verify the old collection's data persisted*/
        for (Map.Entry entry : oldCollection.entrySet()) {
            Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsValue(entry.getValue()));
        }
    }

    @Test
    public void testChangeSubjectValid() {
        /*Find an existing subject with a given name*/
        Subject oldC = SubjectCollection.getInstance().findSubject("Programming Languages");
        /*Create a new subject with the same name*/
        Subject newC = new Subject("Programming Languages");
        /*Copy the old collection to use for verification*/
        HashMap<String, Subject> oldCollection = new HashMap<>(SubjectCollection.getInstance().getSubjects());

        SubjectCollection.getInstance().changeSubject(oldC, newC);
        /*Verify the new Subject has been added*/
        Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsValue(newC));
        /*Verify the old subject has been deleted*/
        Assert.assertFalse(SubjectCollection.getInstance().getSubjects().containsValue(oldC));
        /*Verify the key (which should be the same as the old subject) still exists*/
        Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsKey(newC.toString()));

        /*Verify the old collection's data persisted*/
        for (Map.Entry entry : oldCollection.entrySet()) {
            if (!entry.getValue().equals(oldC)) {
                Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsValue(entry.getValue()));
            }
        }
    }

    @Test
    public void testChangeSubjectInvalid() {
        /*Find an existing subject with a given name*/
        Subject oldC = SubjectCollection.getInstance().findSubject("Programming Languages");
        /*Create a new subject with a different name*/
        Subject newC = new Subject("Nothing Relevant");
        /*Copy the old collection to use for verification*/
        HashMap<String, Subject> oldCollection = new HashMap<>(SubjectCollection.getInstance().getSubjects());

        SubjectCollection.getInstance().changeSubject(oldC, newC);
        /*Verify the new Subject has not been added*/
        Assert.assertFalse(SubjectCollection.getInstance().getSubjects().containsValue(newC));
        Assert.assertFalse(SubjectCollection.getInstance().getSubjects().containsKey(newC.toString()));
        /*Verify the old Subject has persisted*/
        Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsValue(oldC));
        Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsKey(oldC.toString()));

        /*Verify the old collection's data persisted*/
        for (Map.Entry entry : oldCollection.entrySet()) {
            Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsValue(entry.getValue()));
        }
    }

    @Test
    public void testGetAllSubjects() {
        ArrayList<String> allSubjectsString = SubjectCollection.getInstance().getAllSubjects();
        /*Verify all of the collection's data has been pulled*/
        for (String subject : allSubjectsString) {
            Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsKey(subject));
        }
    }

    @Test
    public void testGetAllSubjectList() {
        ArrayList<Subject> allSubjectsString = SubjectCollection.getInstance().getAllSubjectList();
        /*Verify all of the collection's data has been pulled*/
        for (Subject subject : allSubjectsString) {
            Assert.assertTrue(SubjectCollection.getInstance().getSubjects().containsValue(subject));
        }
    }
}
