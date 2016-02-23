package TestTool.Model.TestBank;

import TestTool.Model.Resource.Course;
import TestTool.Model.TestCreation.Test;

import java.util.ArrayList;

/**
 * A TestBank is a collection of Test objects in an arraylist.
 * It is also a singleton
 *
 *  Created by Brandon Vo (brvo@calpoly.edu) on 11/20/15.
 */
public class TestBank {

    /*A singleton that allows other classes to access the testbank*/
    private static TestBank instance = new TestBank();

    /*The actual testbank which is an arrylist of test objects*/
    private ArrayList<Test> bank = new ArrayList<>();

    private TestBank() {
        bank = new ArrayList<>();
    }

    /*Adds a test object to the bank*/
    public void add(Test test) {
        bank.add(test);
    }

    /*Remove a test from the bank*/
    public void delete(Test test) {
        bank.remove(test);
    }

    /*Get a test from the bank when given the quesiton name*/
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

    /*Takes in the filter options and then returns an ArrayList of test objects*/
    public ArrayList<Test> filter(String name, String subject, String course, int testLength, int diff){

        /*ArrayList of tests that contains the newly filtered tests*/
        ArrayList<Test> filteredTests = new ArrayList<>();

        /*Boolean value to denote if a Test passes the filter*/
        boolean flag = true;

        /*For all Tests in bank*/
        for(Test test: bank){
            flag = true;

            /*Checks if the name filter is in use and if it is if it equals the test name*/
            if(!name.isEmpty() && !test.getName().equals(name)){
                flag = false;
            }


            /*Checks if the subject filter is in use and if it is if it equals the subject*/
            if(flag && subject != null && !test.getSubject().getName().equals(subject)){
                flag = false;
            }


            /*Checks if the course filter is in use and if it is if it equals the test course/
            if(flag && course != null && !test.getCourse().getName().equals(course)){
                flag = false;
            }


            /*Checks if the test length filter is in use and if it is if it equals the test length*/
            if(flag && testLength > 0 && test.getTimeLimit() != testLength){
                flag = false;
            }


            /*Checks if the difficulty filter is in use and if it is if it equals the test difficulty*/
            if(flag && diff > 0 && test.getDifficulty() != diff){
                flag = false;
            }

            /*This denotes that it passes all of the tests and then adds the test to the filteredTests list*/
            if(flag){
                filteredTests.add(test);
            }
        }
        return filteredTests;
    }

    /*Returns a list of test objects for a particular test
    * This method is used in the Course View
    * */
    public ArrayList<Test> getTestForCourse(Course course){
        ArrayList<Test> testList = new ArrayList<>();

        /*For all tests in bank*/
        for(Test test: bank){

            /*If the test's course is equal to the course passed in then add it to the list*/
            if(test.getCourse().equals(course)){
                testList.add(test);
            }
        }
        return testList;
    }
}
