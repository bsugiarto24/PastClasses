package TestTool.View.QuestionManagement;

import TestTool.Model.QuestionCreation.FillInTheBlank;
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
import java.util.Scanner;

public class FillInTheBlankEditHandler extends FillInTheBlankHandler {
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
	private TextArea answerText;
	
	FillInTheBlank question;
	
	
	@FXML
	private void initialize() {

	}

	public void init2() {
		questionText.setText(question.getQuestion());

		answerText.setText(question.getAnswer());

		courseBox.setValue(question.getCourse());
		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourseList()));

		subjectBox.setValue(question.getSubject());
		subjectBox.setItems(FXCollections.observableArrayList(question.getCourse().getSubjects()));

		difficultyBox.setValue(question.getDifficulty());
		difficultyBox.setItems(
				FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));

		pointsText.setText("" + question.getPoints());
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
				(pointsText.getText().isEmpty()) ||
				(questionText.getText().isEmpty()) ||
				(answerText.getText().isEmpty())
				) {
			showErrorMessage("Missing Info");
			System.out.println("Missing info");
		}
		else {
			Scanner scanner = new Scanner(questionText.getText());
			boolean hasBlank = false;
			while (scanner.hasNext()) {
				if (scanner.next().compareTo("_") == 0) {
					hasBlank = true;
					break;
				}
			}
			if (hasBlank) {
				try {
					question.setType("Fill-In-The-Blank");
					question.setQuestion(questionText.getText());
					question.setPoints(Double.parseDouble(pointsText.getText()));
					question.setCourse(courseBox.getValue());
					question.setSubject(subjectBox.getValue());
					question.setDifficulty(difficultyBox.getValue());
					question.setAnswer(answerText.getText());
					LocalDate tempDate = LocalDate.now();
					question.setDate(tempDate);
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
			else {
				showErrorMessage("Missing blank");
			}
		}
	}
	
	public void setQuestion(FillInTheBlank q) {
		question = q;
	}
}
