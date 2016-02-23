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
		question = new TrueFalse();

		courseBox.setValue("-None-");
		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourses()));

		answerBox.setItems(FXCollections.observableArrayList(true,false));
		
		subjectBox.setValue("-None-");
		subjectBox.setItems(FXCollections.observableArrayList(subjectCollection.getAllSubjects()));
		
		difficultyBox.setItems(
		   FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
		
	}
	
	@FXML
	private void saveQuestion() {
		//Fill in Question object info
		//checks to make sure all info there
		if ((courseBox.getValue() == "-None-") ||
			(answerBox.getValue() == null) ||
			(subjectBox.getValue() == "-None-") ||
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
				//System.out.println(answerBox.getValue());
				//System.out.println(pointsText.getText());
				question.setPoints(Double.parseDouble(pointsText.getText()));
				Subject tempSubject = new Subject(subjectBox.getValue());
				question.setSubject(tempSubject);
				question.setDifficulty(difficultyBox.getValue());
				Course tempCourse = new Course(courseBox.getValue());
				question.setCourse(tempCourse);
				LocalDate tempDate = LocalDate.now();
				question.setDate(tempDate);
				question.setCreator((TestMaker)User.getUserLoggedIn());
				System.out.println("Question created");
				
				questionBank.addQuestion(question);
				System.out.println("added question to question bank");
			}
			catch(Exception e) {
				e.printStackTrace();
				//System.out.println("HERE2: " + answerBox.getValue().getClass());
				//Boolean temp = new Boolean(true);
				/*if (answerBox.getValue().getClass().equals(temp.getClass())) {
					System.out.println("Isa boolean");
				}*/
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