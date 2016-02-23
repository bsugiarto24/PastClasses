package TestTool.Model.TestBank;

import TestTool.Model.TestCreation.ActiveTest;

import java.util.ArrayList;

/**
 * A ActiveTestBank is a collection of ActiveTest objects in an arraylist.
 * It is also a singleton
 *
 *  Created by Brandon Vo (brvo@calpoly.edu) on 11/20/15.
 */
public class ActiveTestBank {

    /*The singleton of the ActiveTestBank*/
    private static ActiveTestBank instance = new ActiveTestBank();

    /*The list of ActiveTest objects that acts as the bank*/
    ArrayList<ActiveTest> bank;

    private ActiveTestBank(){
        bank = new ArrayList<>();
    }

    public ArrayList<ActiveTest> getBank(){
        return bank;
    }

    public static ActiveTestBank getInstance() {
        return instance;
    }
}
