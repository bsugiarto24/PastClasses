package TestResults;

import java.util.Collection;

/**
*A Chart has cotains current and studentScores. Current is an object which 
*represents the type of chart which will be produced. StudentScores 
*is a collection that contains individual student data which will translate 
*to data for the chart.
*
*/
public abstract class Chart{
   Object current;
   private Collection<Object> studentScores;

   /**
   *This method is acts as a setter for the current private instance variable.
   */
   abstract void setCurrent(Object current);

   /**
   *This method is acts as a setter for the studentScores private instance variable.
   */
   abstract void setScores(Collection<Object> studentScores);
   
   /**
   * This method is acts as a getter for the current private instance variable.
   */
   abstract Object getCurrent();

   /**
   * This method is acts as a getter for the studentScores private instance variable.
   */
   abstract Collection<Object> getScores();
}