package TestTool.View.QuestionManagement;

import java.util.Date;

import TestTool.Model.QuestionBank.QuestionBank;
import TestTool.Model.QuestionCreation.FreeResponse;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class CodingHandler extends QuestionEditorTopController {
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
		question = new FreeResponse();
		
		courseBox.setValue("-None-");
		//come back and fix with actual course list
		courseBox.setItems(tempCourseList);
		courseBox.getItems().add("-Add Course-");
		
		subjectBox.setValue("-None-");
		//come back and fix with actual subject list
		subjectBox.setItems(tempSubjectList);
		subjectBox.getItems().add("-Add subject-");
		
		difficultyBox.setItems(
	       FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
	}
	
	@FXML
	private void saveQuestion() {
		//Fill in Question object info
		//checks to make sure all info there
		if ((courseBox.getValue() == "-None-") ||
			(subjectBox.getValue() == "-None-") ||
			(difficultyBox.getValue() == null) ||
			(pointsText.getText().isEmpty())||
			(questionText.getText().isEmpty())
			) {
			//COME BACK HERE TO PRINT OUT PROMPT
			showErrorMessage("Missing Info");
			System.out.println("Missing info");
		}
		else {
			try {
				question.setType("Coding");
				question.setQuestion(questionText.getText());
				question.setPoints(Double.parseDouble(pointsText.getText()));
				Subject tempSubject = new Subject(subjectBox.getValue());
				question.setSubject(tempSubject);
				question.setDifficulty(difficultyBox.getValue());
				Course tempCourse = new Course(courseBox.getValue());
				question.setCourse(tempCourse);
				Date tempDate = new Date();
				question.setDate(tempDate);
				if (flagsText.getText().isEmpty() == false) {
					question.setFlags(flagsText.getText());
				}
				System.out.println("Question created");
				
				//come back and fill in testMaker info
				questionBank.addQuestion(question);
				System.out.println("added question to question bank");	
			}
			catch(Exception e) {
				//COME BACK AND PRINT ERROR MSG
				showErrorMessage("Only real numbers");
				System.out.println("Only real numbers allowed.");
			}
			
			
			
		}
	}

}
