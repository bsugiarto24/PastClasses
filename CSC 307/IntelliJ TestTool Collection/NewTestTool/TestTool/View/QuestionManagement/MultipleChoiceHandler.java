package TestTool.View.QuestionManagement;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import TestTool.Model.QuestionBank.*;

import java.awt.Event;
import java.util.ArrayList;
import java.util.Date;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.CheckBox;

public class MultipleChoiceHandler extends QuestionEditorTopController {

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
	QuestionBank questionBank = QuestionBank.getInstance();
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
		question = new MultipleChoice();
		
		courseBox.setValue("-None-");
		//come back and fix with actual course list
		courseBox.setItems(tempCourseList);
		courseBox.getItems().add("-Add Course-");
		
		//come back for answer
		
		subjectBox.setValue("-None-");
		//come back and fix with actual subject list
		subjectBox.setItems(tempSubjectList);
		subjectBox.getItems().add("-Add subject-");
		
		difficultyBox.setItems(
		   FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10));
		
		answerChoiceList = FXCollections.observableArrayList();
		answerChoiceList.add(new Option(new SimpleStringProperty("Hello world")));
		answerChoiceList.add(new Option(new SimpleStringProperty("This is a test")));
		choiceColumn.setCellValueFactory(new PropertyValueFactory<Option,String>("option"));
		choiceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		/*answerCorrectList = FXCollections.observableArrayList();
		answerCorrectList.add(new SimpleStringProperty(""));
		answerCorrectList.add(new SimpleStringProperty(""));*/
		
		
		
		/*answerColumn.setCellValueFactory(cellData -> cellData.getValue());
		answerColumn.setCellFactory(TextFieldTableCell.forTableColumn());*/
		
		answerColumn.setCellValueFactory(new PropertyValueFactory<Option,Boolean>("correct"));
		answerColumn.setCellFactory(CheckBoxTableCell.forTableColumn(answerColumn));
		
		choiceColumn.setEditable(true);
		answerColumn.setEditable(true);
		choiceTable.setEditable(true);
		choiceTable.setItems(answerChoiceList);
		//choiceTable.getColumns().addAll(choiceColumn,answerColumn);
		
		//answerTable.setEditable(true);
		
	}
	
	@FXML
	private void handleAddChoiceButton() {
		answerChoiceList.add(new Option(new SimpleStringProperty("-new choice-")));
		//answerCorrectList.add(new SimpleStringProperty(""));
		
	}
	
	@FXML
	private void handleDeleteChoiceButton() {
		ObservableList<Option> select, all;
		all = choiceTable.getItems();
		select = choiceTable.getSelectionModel().getSelectedItems();
		
		select.forEach(all::remove);
		
	}
	
	@FXML
	private void printArrayStuff() {
		System.out.println(answerChoiceList.toString());
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
			//COME BACK HERE TO PRINT OUT PROMPT
			showErrorMessage("Missing info");
			System.out.println("Missing info");
		}
		else {
			try {
				Double.parseDouble(pointsText.getText());
			}
			catch(Exception e) {
				//COME BACK AND PRINT ERROR MSG
				showErrorMessage("Only real numbers");
				System.out.println("Only real numbers allowed.");
			}
			boolean temp = false;
			
			
			for(int i=0; i < answerChoiceList.size(); i++) {
				//System.out.println(i);
				ArrayList<String> tempOption = new ArrayList<>();
				ArrayList<Integer> tempAnswer = new ArrayList<>();
				tempOption.add(answerChoiceList.get(i).option.getValue());
				if (answerColumn.getCellData(i) == true) {
					tempAnswer.add((Integer)i);
					temp = true;
				}
				question.setOption(tempOption);
				question.setAnswer(tempAnswer);
				//System.out.println("" + i + answerColumn.getCellData(i));
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
				Date tempDate = new Date();
				question.setDate(tempDate);
				
				System.out.println(question.toString());
				System.out.println("made question");
				//come back and fill in testMaker info
				questionBank.addQuestion(question);
				System.out.println("added question to question bank");
				
			}
		}
		System.out.println("EXIT");
	}
	
}
