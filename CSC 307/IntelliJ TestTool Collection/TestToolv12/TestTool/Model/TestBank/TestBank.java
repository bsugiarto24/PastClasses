package TestTool.Model.TestBank;

import TestTool.Model.Resource.Course;
import TestTool.Model.TestCreation.Test;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void setBank(ArrayList<Test> tests){
        this.bank = tests;
    }

    /**
     * Resets the collection of Tests -- Used during testing to blow away collection and restart.
     */
    public void reset() {
        bank = new ArrayList<>();
    }
}
