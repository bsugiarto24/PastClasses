package TestTool.Model.TestBank;

import TestTool.Model.TestCreation.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by brvo on 11/24/15.
 */
public class TestBank {
    private ArrayList<Test> bank;

    public TestBank(){
        bank = new ArrayList<>();
    }

    public void add(Test test){
        bank.add(test);
    }

    public void delete(Test test){
        bank.remove(test);
    }

    public Test get(String name){
        for(Test test : bank){
            if(test.getName().equals(name)){
                return test;
            }
        }
        return null;
    }
}
