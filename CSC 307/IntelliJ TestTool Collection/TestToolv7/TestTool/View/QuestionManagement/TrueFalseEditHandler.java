package TestTool.View.QuestionManagement;

import TestTool.Model.QuestionCreation.*;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TrueFalseEditHandler extends TrueFalseHandler {
	
	@FXML
	private TextArea questionText; 
	@FXML
	private ComboBox<String> courseBox;
	@FXML
	private ComboBox<Boolean> answerBox;
	@FXML
	private Button saveButton;
	@FXML 
	private ComboBox<String> subjectBox;
	@FXML
	private ComboBox<Integer> difficultyBox;
	@FXML
	private TextArea pointsText;
	
	TrueFalse question;
	
	@FXML
	private void initialize() {
		
		courseBox.setValue(question.getCourse().toString());
		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourses()));
		
		answerBox.setValue(question.getAnswer());
		answerBox.setItems(
		   FXCollections.observableArrayList(true, false));
		
		subjectBox.setValue(question.getSubject().toString());
		subjectBox.setItems(FXCollections.observableArrayList(subjectCollection.getAllSubjects()));
		
		difficultyBox.setValue(question.getDifficulty());
		difficultyBox.setItems(
		   FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
	}	
	
	public void setQuestion(TrueFalse q) {
		question = q;
	}
}
