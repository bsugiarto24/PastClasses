package TestTool.View.QuestionManagement;

import TestTool.Model.QuestionCreation.*;

import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.TestMaker;
import TestTool.Model.Resource.User;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

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


	}	
	
	public void setQuestion(TrueFalse q) {
		System.out.println("InsetQues");
		question = q;
	}

	public void init2() {
		courseBox.setValue(question.getCourse().toString());
		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourses()));

		questionText.setText(question.getQuestion());

		pointsText.setText("" + question.getPoints());

		answerBox.setValue(question.getAnswer());
		answerBox.setItems(
				FXCollections.observableArrayList(true, false));

		subjectBox.setValue(question.getSubject().toString());
		subjectBox.setItems(FXCollections.observableArrayList(subjectCollection.getAllSubjects()));

		difficultyBox.setValue(question.getDifficulty());
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
			//COME BACK HERE TO PRINT OUT PROMPT
			showErrorMessage("Missing info");
			System.out.println("Missing info");
		}
		else {
			try {
				question.setType("True/False");
				question.setQuestion(questionText.getText());
				question.setAnswer(answerBox.getValue());
				System.out.println(pointsText.getText());
				question.setPoints(Double.parseDouble(pointsText.getText()));
				Subject tempSubject = new Subject(subjectBox.getValue());
				question.setSubject(tempSubject);
				question.setDifficulty(difficultyBox.getValue());
				Course tempCourse = new Course(courseBox.getValue());
				question.setCourse(tempCourse);
				LocalDate tempDate = LocalDate.now();
				question.setDate(tempDate);
				question.setCreator((TestMaker) User.getUserLoggedIn());
				System.out.println("Question created");

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
