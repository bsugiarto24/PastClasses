package TestTool.Model.AdministrativeDetails;

import java.util.ArrayList;

/**
 * 
 * This class represents the Input Form.
 * @author bsugiarto
 *
 */
public abstract class InputForm {

	
	private ArrayList<String> input;
	
	/**
	 * This function displays the invalid input window.
	 */
	public abstract void input(int id, String input);
	
	/**
	 * This function gets the message for the invalid input window.
	 */
	public abstract void get(int id);
	
}
