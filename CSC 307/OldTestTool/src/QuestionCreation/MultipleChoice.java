package QuestionCreation;
import java.util.Collection;

/**
* Multiple Choice is a type of question. It has a collection of Strings that represent the different options for answers
* and a Collection of Integers that correspond to correct answers in the Collection of Strings.
*/
public abstract class MultipleChoice extends Question {
   Collection<String> options;
   Collection<Integer> answer;
   
   /**
   * Adds choice to list of options
   */ 
   public abstract void addOption();
   /**
   * Sets one of the options
   */
   public abstract void setOption(int choice, String text);
   /**
   * Sets answer variable
   */ 
   public abstract void setAnswer(Collection<Integer> answer);
}