package TestTool.View.QuestionManagement;

import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.*;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TrueFalseHandler extends QuestionEditorTopController {
	
	@FXML
	private TextArea questionText; 
	@FXML
	private ComboBox<Course> courseBox;
	@FXML
	private ComboBox<Boolean> answerBox;
	@FXML
	private Button saveButton;
	@FXML 
	private ComboBox<Subject> subjectBox;
	@FXML
	private ComboBox<Integer> difficultyBox;
	@FXML
	private TextArea pointsText;
	
	TrueFalse question;
	
	@FXML
	private void initialize() {
		question = new TrueFalse();

		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourseList()));

		answerBox.setItems(FXCollections.observableArrayList(true,false));
		
		difficultyBox.setItems(
		   FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
		
	}
	
	@FXML
	private void onSelectCourse() {
		subjectBox.setItems(FXCollections.observableArrayList(courseBox.getValue().getSubjects()));
	}
	
	@FXML
	private void saveQuestion() {
		//Fill in Question object info
		//checks to make sure all info there
		if ((courseBox.getValue() == null) ||
			(answerBox.getValue() == null) ||
			(subjectBox.getValue() == null) ||
			(difficultyBox.getValue() == null) ||
			(pointsText.getText().isEmpty())||
			(questionText.getText().isEmpty())
		    ) {
			showErrorMessage("Missing info");
			System.out.println("Missing info");
		}
		else {
			try {
				question.setType("True/False");
				question.setQuestion(questionText.getText());
				question.setAnswer(answerBox.getValue());
				question.setPoints(Double.parseDouble(pointsText.getText()));
				question.setCourse(courseBox.getValue());
				question.setSubject(subjectBox.getValue());
				question.setDifficulty(difficultyBox.getValue());
				LocalDate tempDate = LocalDate.now();
				question.setDate(tempDate);
				question.setCreator((TestMaker)User.getUserLoggedIn());
				System.out.println("Question created");
				
				questionBank.addQuestion(question);
				System.out.println("added question to question bank");
			}
			catch(Exception e) {
				showErrorMessage("Only real numbers");
				System.out.println("Only real numbers allowed.");
			}			
		}
	}	
	
	@FXML
	private void handleClear() {
		handleSelectTrueFalseType();
	}
}
