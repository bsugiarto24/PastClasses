package TestTool.Model.AdministrativeDetails;

import javafx.scene.control.Alert;


/**
 * 
 * This class represents a window which pops up to notify an error.
 *
 * Created by Bryan Sugiarto (bsugiart@calpoly.edu) on 11/2/15.
 */
public class InvalidInput {

	/* An Alert box to display */
	private Alert alert;

	/**
	 * The constructor to create
	 * @param title A String for the window's title.
	 * @param content A String for the window's content.
     */
	public InvalidInput(String title, String content) {
		alert = new Alert(Alert.AlertType.ERROR);

		/* set title and content */
		alert.setTitle(title);
		alert.setContentText(content);

		/* displays alert */
		display();
	}

	/**
	 * Displays alert box.
	 */
	public void display() {
		/* checks if null */
		if(alert != null)
			alert.showAndWait();
	}

	/**
	 * Sets Alert title to inputted string.
	 * @param title A String to set the Alert title.
     */
	public void setTitle(String title){
		alert.setTitle(title);
	}


	/**
	 * This function returns the alert box
	 * @return alert An Alert object to be returned.
	 */
	public Alert getAlert() {
		return alert;
	}

}
