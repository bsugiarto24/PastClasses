package TestTool.Model.TestBank;

import TestTool.Model.TestCreation.ActiveTest;

import java.util.ArrayList;

/**
 * Created by brvo on 11/29/15.
 */
public class ActiveTestBank {

    private static ActiveTestBank instance = new ActiveTestBank();
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
