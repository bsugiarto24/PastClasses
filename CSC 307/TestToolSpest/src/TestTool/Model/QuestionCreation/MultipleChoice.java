package TestTool.Model.QuestionCreation;
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
   * pre: 
   // options does not point to null
   * options != null;
   * post:
   // options' sizes will increase by 1
   * options'.size() = options.size() + 1;
   */ 
   public abstract void addOption();
   /**
   * Sets one of the options
   * pre:
   // options does not point to null and choice is within the boundary of the options collection
   * choice != null && choice < options.size(); 
   * post:
   // entry of options at choice is equals to text and others are not touched
   forall(int i; i < options.size() && i != choice;
      options.get(i) == options'.get(i))
   &&
   options'.get(choice) == text;       
   */
   public abstract void setOption(int choice, String text);
   /**
   * Sets answer variable
   * pre: 
   // this.answer does not point to null and answer does not contain integer values greater than options' size
   answer != null &&
   forall(int i; i < answer.size(); 
      answer.get(i) < options.size());
   * post: 
   // this.answer contains all values in answer
   forall(int i; i < answer.size();
      this.answer'.contains(answer.get(i)));
   */ 
   public abstract void setAnswer(Collection<Integer> answer);
}