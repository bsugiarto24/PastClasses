package TestTool.View.QuestionManagement;

import TestTool.Model.QuestionCreation.Coding;
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

public class CodingEditHandler extends CodingHandler {
	@FXML
	private TextArea questionText; 
	@FXML
	private ComboBox<Course> courseBox;
	@FXML
	private Button saveButton;
	@FXML 
	private ComboBox<Subject> subjectBox;
	@FXML
	private ComboBox<Integer> difficultyBox;
	@FXML
	private TextArea pointsText;
	@FXML
	private TextArea flagsText;
	
	Coding question;

	@FXML
	private void initialize() {

	}

	public void init2() {
		questionText.setText(question.getQuestion());

		courseBox.setValue(question.getCourse());
		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourseList()));

		subjectBox.setValue(question.getSubject());
		subjectBox.setItems(FXCollections.observableArrayList(question.getCourse().getSubjects()));

		difficultyBox.setValue(question.getDifficulty());
		difficultyBox.setItems(
				FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));

		pointsText.setText(""+question.getPoints());

		flagsText.setText("" + question.getFlags());
	}
	
	public void setQuestion(Coding q) {
		question = q;
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
				(subjectBox.getValue() == null) ||
				(difficultyBox.getValue() == null) ||
				(pointsText.getText().isEmpty())||
				(questionText.getText().isEmpty())
				) {
			showErrorMessage("Missing Info");
			System.out.println("Missing info");
		}
		else {
			try {
				question.setType("Coding");
				question.setQuestion(questionText.getText());
				question.setPoints(Double.parseDouble(pointsText.getText()));
				question.setCourse(courseBox.getValue());
				question.setSubject(subjectBox.getValue());
				question.setDifficulty(difficultyBox.getValue());
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
}
