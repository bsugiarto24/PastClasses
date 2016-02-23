package TestTool.View.QuestionManagement;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;

import java.awt.Event;
import java.util.Date;

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
	private TableView<SimpleStringProperty> choiceTable;
	@FXML
    private TableColumn<SimpleStringProperty, String> choiceColumn;
	@FXML
	private TableView<SimpleStringProperty> answerTable;
	@FXML
	private TableColumn<SimpleStringProperty, String> answerColumn;
	
	//need something for answer
	
	MultipleChoice question;
	private ObservableList<SimpleStringProperty> answerChoiceList;
	private ObservableList<SimpleStringProperty> answerCorrectList;
	
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
		answerChoiceList.add(new SimpleStringProperty("Hello world"));
		answerChoiceList.add(new SimpleStringProperty("This is a test"));
		choiceTable.setItems(answerChoiceList);
		choiceColumn.setCellValueFactory(cellData -> cellData.getValue());
		choiceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		choiceTable.setEditable(true);
		
		answerCorrectList = FXCollections.observableArrayList();
		answerCorrectList.add(new SimpleStringProperty(""));
		answerCorrectList.add(new SimpleStringProperty(""));
		answerTable.setItems(answerCorrectList);
		answerColumn.setCellValueFactory(cellData -> cellData.getValue());
		answerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		answerTable.setEditable(true);
		
	}
	
	@FXML
	private void handleAddChoiceButton() {
		answerChoiceList.add(new SimpleStringProperty(""));
		answerCorrectList.add(new SimpleStringProperty(""));
		
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
			System.out.println("Missing info");
		}
		else {
			try {
				Double.parseDouble(pointsText.getText());
			}
			catch(Exception e) {
				//COME BACK AND PRINT ERROR MSG
				System.out.println("Only real numbers allowed.");
			}
			boolean temp = false;
			
			for(int i=0; i < answerCorrectList.size(); i++) {
				question.addOption(answerChoiceList.get(i).getValue());
				if (answerCorrectList.get(i).isNotEmpty().get()) {
					question.setAnswer(i);
					temp = true;
				}
			}
			if (temp) {
				System.out.println("made question");
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
				//come back and fill in testMaker info
			}
		}
		System.out.println("EXIT");
	}
	
}
