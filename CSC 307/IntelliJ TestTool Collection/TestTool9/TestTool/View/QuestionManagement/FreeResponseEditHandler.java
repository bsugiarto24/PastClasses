package TestTool.View.QuestionManagement;

import TestTool.Model.QuestionBank.QuestionBank;
import TestTool.Model.QuestionCreation.FreeResponse;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.TestMaker;
import TestTool.Model.Resource.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.time.LocalDate;

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

	}

	public void init2() {
		questionText.setText(question.getQuestion());

		courseBox.setValue(question.getCourse().toString());
		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourses()));


		subjectBox.setValue(question.getSubject().toString());
		subjectBox.setItems(FXCollections.observableArrayList(subjectCollection.getAllSubjects()));


		difficultyBox.setValue(question.getDifficulty());
		difficultyBox.setItems(
				FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));

		pointsText.setText(""+question.getPoints());

		flagsText.setText("" + question.getFlags());
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
			showErrorMessage("Missing Info");
			System.out.println("Missing info");
		}
		else {
			try {
				question.setType("Free-Response");
				question.setQuestion(questionText.getText());
				question.setPoints(Double.parseDouble(pointsText.getText()));
				Subject tempSubject = new Subject(subjectBox.getValue());
				question.setSubject(tempSubject);
				question.setDifficulty(difficultyBox.getValue());
				Course tempCourse = new Course(courseBox.getValue());
				question.setCourse(tempCourse);
				LocalDate tempDate = LocalDate.now();
				question.setDate(tempDate);
				if (flagsText.getText().isEmpty() == false) {
					question.setFlags(flagsText.getText());
				}
				question.setCreator((TestMaker) User.getUserLoggedIn());
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
	
	public void setQuestion(FreeResponse q) {
		question = q;
	}

}
