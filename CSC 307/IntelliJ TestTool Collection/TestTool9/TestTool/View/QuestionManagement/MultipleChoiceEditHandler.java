package TestTool.View.QuestionManagement;

import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.TestMaker;
import TestTool.Model.Resource.User;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.CheckBoxTableCell;

public class MultipleChoiceEditHandler extends MultipleChoiceHandler {

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
	private Button deleteChoiceButton;
	@FXML 
	private Button addChoiceButton;
	@FXML
	private TableView<Option> choiceTable;
	@FXML
    private TableColumn<Option, String> choiceColumn;
	@FXML
	private TableColumn<Option, Boolean> answerColumn;
	
	MultipleChoice question;
	private ObservableList<Option> answerChoiceList;

	public class Option {
		public SimpleStringProperty option;
		public SimpleBooleanProperty correct;
		
		public Option(SimpleStringProperty x) {
			option = x;
			correct = new SimpleBooleanProperty();
			correct.setValue(false);
		}
		
		public Option(SimpleStringProperty x, boolean t) {
			option = x;
			correct = new SimpleBooleanProperty();
			correct.setValue(t);
		}
		
		public String getOption() {
			return option.getValue();
		}
		public Boolean getCorrect() {
			return correct.get();
		}
		public void setCorrect(boolean x) {
			this.correct.set(x);
		}
		public SimpleStringProperty optionProperty() {
			return option;
		}
		public SimpleBooleanProperty correctProperty() {
			return correct;
		}
		public String toString() {
			return option.getValue() + " " + correct;
		}
	}
	
	@FXML
	private void initialize() {
		
	}

	public void init2() {

		questionText.setText(question.getQuestion());

		answerChoiceList = FXCollections.observableArrayList();
		SimpleStringProperty opt;
		for (int i = 0; i < question.getOptions().size(); i++) {
			opt = new SimpleStringProperty();
			opt.setValue(question.getOptions().get(i));
			answerChoiceList.add(new Option(opt, question.getAnswer().contains(i)));
		}
		choiceColumn.setCellValueFactory(new PropertyValueFactory<Option,String>("option"));
		choiceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		answerColumn.setCellValueFactory(new PropertyValueFactory<Option,Boolean>("correct"));
		answerColumn.setCellFactory(CheckBoxTableCell.forTableColumn(answerColumn));

		choiceColumn.setEditable(true);
		answerColumn.setEditable(true);
		choiceTable.setEditable(true);
		choiceTable.setItems(answerChoiceList);

		courseBox.setValue(question.getCourse().toString());
		courseBox.setItems(FXCollections.observableArrayList(courseCollection.getAllCourses()));

		subjectBox.setValue(question.getSubject().toString());
		subjectBox.setItems(FXCollections.observableArrayList(subjectCollection.getAllSubjects()));

		difficultyBox.setValue(question.getDifficulty());
		difficultyBox.setItems(
				FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));

		pointsText.setText("" + question.getPoints());
	}

	@FXML
	private void saveQuestion() {
		//Fill in Question object info
		//checks to make sure all info there
		if ((courseBox.getValue() == "-None-") ||
				(subjectBox.getValue() == "-None-") ||
				(answerChoiceList.size() == 0) ||
				(difficultyBox.getValue() == null) ||
				(pointsText.getText().isEmpty())||
				(questionText.getText().isEmpty())
				) {
			showErrorMessage("Missing info");
			System.out.println("Missing info");
		}
		else {
			try {
				Double.parseDouble(pointsText.getText());
			}
			catch(Exception e) {
				showErrorMessage("Only real numbers");
				System.out.println("Only real numbers allowed.");
			}
			boolean temp = false;

			//makes sure there is an answer set
			ArrayList<String> tempOption = new ArrayList<>();
			ArrayList<Integer> tempAnswer = new ArrayList<>();
			for(int i=0; i < answerChoiceList.size(); i++) {
				tempOption.add(answerChoiceList.get(i).option.getValue());
				if (answerColumn.getCellData(i) == true) {
					tempAnswer.add((Integer)i);
					temp = true;
				}
				question.setOption(tempOption);
				question.setAnswer(tempAnswer);
			}
			if (temp) {

				question.setType("Multiple Choice");
				question.setQuestion(questionText.getText());
				question.setPoints(Double.parseDouble(pointsText.getText()));
				Subject tempSubject = new Subject(subjectBox.getValue());
				question.setSubject(tempSubject);
				question.setDifficulty(difficultyBox.getValue());
				Course tempCourse = new Course(courseBox.getValue());
				question.setCourse(tempCourse);
				LocalDate tempDate = LocalDate.now();
				question.setDate(tempDate);
				question.setCreator((TestMaker)User.getUserLoggedIn());
				System.out.println(question.toString());

				System.out.println("made question");
				questionBank.addQuestion(question);
				System.out.println("added question to question bank");

			}
		}
		//System.out.println("EXIT");
	}
	
	public void setQuestion(MultipleChoice q) {
		question = q;
	}
	
}
