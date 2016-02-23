package TestTool.Model.TestBank;

import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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

    /*Remove an active test from the bank*/
    public void delete(ActiveTest test) {
        bank.remove(test);
    }

    /*Get a active test from the bank when given the quesiton name*/
    public ActiveTest get(String name, LocalDate date) {
        for (ActiveTest test : bank) {
            if (test.getTest().getName().equals(name) && date.equals(test.getDate())) {
                return test;
            }
        }
        return null;
    }

    public void setBank(ArrayList<ActiveTest> tests){
        this.bank = tests;
    }
}
