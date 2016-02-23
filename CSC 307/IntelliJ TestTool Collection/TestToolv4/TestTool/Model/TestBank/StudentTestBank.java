package TestTool.Model.TestBank;

import TestTool.Model.TestCreation.StudentTest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A StudentTestBank is a collection of StudentTest objects in a hashmap.
 * The key is the name of the student and the value is the list of StudentTest objects assigned to each student
 * It is also a singleton
 *
 *  Created by Brandon Vo (brvo@calpoly.edu) on 11/20/15.
 */
public class StudentTestBank {

    /*The singleton of the ActiveTestBank*/
    private static StudentTestBank instance = new StudentTestBank();

    /*The hashmap that acts as the bank*/
    private HashMap<String, ArrayList<StudentTest>> bank;

    private StudentTestBank(){
        bank = new HashMap<>();
    }

    public void add(StudentTest test){
        String student = test.getStudent().trim().toLowerCase();
        ArrayList<StudentTest> tests = new ArrayList<>();
        if(bank.containsKey(student)){
            tests = bank.get(student);
            tests.add(test);
            bank.put(student, tests);
        }
        else{
            tests.add(test);
            bank.put(student, tests);
        }
    }

    public void removeTest(StudentTest test){
        String student = test.getStudent().trim().toLowerCase();
        if(!bank.containsKey(student)){
            throw new RuntimeException("Student does not exist");
        }

        ArrayList<StudentTest> tests;
        tests = bank.get(student);
        tests.remove(test);
        bank.put(student, tests);
    }

    public void removeAllTests(String name){
        String student = name.trim().toLowerCase();
        ArrayList<StudentTest> tests;
        if(!bank.containsKey(student)){
            throw new RuntimeException("Student does not exist");
        }
        tests = bank.get(student);
        tests.clear();
        bank.put(student, tests);

    }

    public void removeStudent(String name){
        String student = name.trim().toLowerCase();
        if(!bank.containsKey(student)){
            throw new RuntimeException("Student does not exist");
        }
        bank.remove(student);
    }

    public ArrayList<StudentTest> getTests(String name){
        String student = name.trim().toLowerCase();
        if(!bank.containsKey(student)){
            throw new RuntimeException("Student does not exist");
        }
        return bank.get(student);
    }

    public HashMap<String, ArrayList<StudentTest>> getBank(){
        return bank;
    }

    public static StudentTestBank getInstance() {
        return instance;
    }
}
