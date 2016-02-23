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
	
	//need something for answer
	
	MultipleChoice question;
	private ObservableList<Option> answerChoiceList;
	//private ObservableList<SimpleStringProperty> answerCorrectList;

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
		
	}
	
	@FXML
	private void printArrayStuff() {
		System.out.println(answerChoiceList.toString());
	}
	
	public void setQuestion(MultipleChoice q) {
		question = q;
	}
	
}
