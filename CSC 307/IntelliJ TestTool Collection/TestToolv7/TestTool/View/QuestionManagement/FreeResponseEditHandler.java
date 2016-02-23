package TestTool.View.QuestionManagement;

import TestTool.Model.QuestionBank.QuestionBank;
import TestTool.Model.QuestionCreation.FreeResponse;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class FreeResponseEditHandler extends FreeResponseHandler {
	
	@FXML
	private TextArea questionText; 
	@FXML
	private ComboBox<String> courseBox;
	@FXML
	private Button saveButton;
	@FXML 
	private ComboBox<String> subjectBox;
	@FXML
	private ComboBox<Integer> difficultyBox;
	@FXML
	private TextArea pointsText;
	@FXML
	private TextArea flagsText;
	
	FreeResponse question;
	QuestionBank questionBank = QuestionBank.getInstance();
	
	@FXML
	private void initialize() {
		questionText.setText(question.getQuestion());
		
		courseBox.setValue(question.getCourse().toString());
		//come back and fix with actual course list
		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourses()));

		
		subjectBox.setValue(question.getSubject().toString());
		//come back and fix with actual subject list
		subjectBox.setItems(FXCollections.observableArrayList(subjectCollection.getAllSubjects()));

		
		difficultyBox.setValue(question.getDifficulty());
		difficultyBox.setItems(
	       FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
	}
	
	public void setQuestion(FreeResponse q) {
		question = q;
	}

}
