package TestTool.Model.TestBank;

import TestTool.Model.Resource.Course;
import TestTool.Model.TestCreation.Test;

import java.util.ArrayList;

/**
 * Created by brvo on 11/24/15.
 */
public class TestBank {
    private static TestBank instance = new TestBank();
    private ArrayList<Test> bank = new ArrayList<>();

    private TestBank() {
        bank = new ArrayList<>();
    }

    public void add(Test test) {
        bank.add(test);
    }

    public void delete(Test test) {
        bank.remove(test);
    }

    public Test get(String name) {
        for (Test test : bank) {
            if (test.getName().equals(name)) {
                return test;
            }
        }
        return null;
    }

    public ArrayList<Test> getBank() {
        return bank;
    }

    public static TestBank getInstance() {
        return instance;
    }

    public ArrayList<Test> filter(String name, String subject, String course, int testLength, int diff){
        ArrayList<Test> filteredTests = new ArrayList<>();
        boolean flag = true;
        for(Test test: bank){
            flag = true;
            if(!name.isEmpty() && !test.getName().equals(name)){
                flag = false;
            }
            if(flag && subject != null && !test.getSubject().getName().equals(subject)){
                flag = false;
            }
            if(flag && course != null && !test.getCourse().getName().equals(course)){
                flag = false;
            }
            if(flag && testLength > 0 && test.getTimeLimit() != testLength){
                flag = false;
            }
            if(flag && diff > 0 && test.getDifficulty() != diff){
                flag = false;
            }
            if(flag){
                filteredTests.add(test);
            }
        }
        return filteredTests;
    }

    public ArrayList<Test> getTestForCourse(Course course){
        ArrayList<Test> testList = new ArrayList<>();
        for(Test test: bank){
            if(test.getCourse().equals(course)){
                testList.add(test);
            }
        }
        return testList;
    }
}
