package TestCreation;

import java.util.Collection;
//import TestCreation.*;

/**
*The TestBank acts as a Collection for created tests. This testbank is 
*referenced when the user choses to use an existing test. Thie class also 
*acts a parent class for the Graded Test Bank.
*
*/
public abstract class TestBank{
   
   private Collection<test> testBank;

   /**
   *This method takes in a test of Type test and adds it to the testBank collection.
   *
   */   
   public abstract void addToBank(test test);

   /**
   *This method takes in an int which is the index where the selected 
   *test exisits in the testBank collection.
   */
   public abstract void getFromBank(int index);
   
}