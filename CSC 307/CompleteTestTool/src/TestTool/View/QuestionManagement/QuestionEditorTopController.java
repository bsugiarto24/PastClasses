package TestTool.View.QuestionManagement;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import TestTool.*;
import TestTool.Model.QuestionCreation.*;
import TestTool.View.TestCreation.RanTestController;

public class QuestionEditorTopController {
	
	protected static MainApp mainApp;
	protected static Question question;
	private FXMLLoader loader;
	
	protected ObservableList<String> tempCourseList = 
	   FXCollections.observableArrayList("Course1", "Course2", "Course3");
			
	protected ObservableList<String> tempSubjectList = 
	   FXCollections.observableArrayList("Subject1", "Subject2", "Subject3");
	
	/*Question Type Selection Event Handlers*/
	@FXML
	public void handleSelectTrueFalseType() {
		try {
			loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/QuestionManagement/TrueFalse.fxml"));
			AnchorPane newScreen = (AnchorPane) loader.load();
			TrueFalseHandler tfHandler = loader.getController();
			tfHandler.setQuestion(new TrueFalse());
			tfHandler.getQuestion().setType("True/False");	
			tfHandler.setMain(mainApp);

			// Set new screen into center of root layout
			mainApp.rootLayout.setCenter(newScreen);

			mainApp.primaryStage.show();
		}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	@FXML
	public void handleSelectMultipleChoiceType() {
		try {
			loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/QuestionManagement/MultipleChoice.fxml"));
			AnchorPane newScreen = (AnchorPane) loader.load();
			MultipleChoiceHandler mcHandler = loader.getController();
			mcHandler.setMain(mainApp);
			mcHandler.setQuestion(new MultipleChoice());
			mcHandler.getQuestion().setType("Multiple Choice");

			// Set new screen into center of root layout
			mainApp.rootLayout.setCenter(newScreen);

			mainApp.primaryStage.show();
		}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	@FXML
	public void handleSelectFreeResponseType() {
		try {
			loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/QuestionManagement/FreeResponse.fxml"));
			AnchorPane newScreen = (AnchorPane) loader.load();
			FreeResponseHandler frHandler = loader.getController();
			frHandler.setQuestion(new FreeResponse());
			frHandler.getQuestion().setType("Free-Response");
			frHandler.setMain(mainApp);
			
			// Set new screen into center of root layout
			mainApp.rootLayout.setCenter(newScreen);

			mainApp.primaryStage.show();
		}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	@FXML
	public void handleSelectCodingType() {		
		try {
			loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/QuestionManagement/Coding.fxml"));
			AnchorPane newScreen = (AnchorPane) loader.load();
			CodingHandler cHandler = loader.getController();
			cHandler.setQuestion(new Coding());
			cHandler.getQuestion().setType("Coding");
			cHandler.setMain(mainApp);
			
			// Set new screen into center of root layout
			mainApp.rootLayout.setCenter(newScreen);

			mainApp.primaryStage.show();
		}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	@FXML
	public void handleSelectFillInTheBlankType() {
		try {
			loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/QuestionManagement/FillInTheBlank.fxml"));
			AnchorPane newScreen = (AnchorPane) loader.load();
			FillInTheBlankHandler fibHandler = loader.getController();
			fibHandler.setQuestion(new FillInTheBlank());
			fibHandler.getQuestion().setType("Fill-In-The-Blank");
			fibHandler.setMain(mainApp);
			
			// Set new screen into center of root layout
			mainApp.rootLayout.setCenter(newScreen);

			mainApp.primaryStage.show();
		}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
	}
	
	@FXML
	public void handleDelete() {
		Question.deleteQuestion();
	}
	
	@FXML
	public void handleSave() {
		Question.saveQuestion();
	}
	
	@FXML
	public void handleClear() {
		Question.clearQuestion();
	}
	
	public void setMain(MainApp a) {
        mainApp = a;
    }
	
	public static MainApp getMain(){
		return mainApp;
	}
	
	public void setQuestion(Question q) {
		question = q;
	}
	
	public static Question getQuestion() {
		return question;
	}
}
