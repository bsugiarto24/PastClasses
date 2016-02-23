package TestTool.View.TestCreation;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.Subject;
import TestTool.Model.TestCreation.Test;
import TestTool.View.QuestionBank.EditTestQuesBankController;
import TestTool.View.QuestionManagement.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import TestTool.*;
import TestTool.View.TestBank.*;

/**
 * Created by mgolahi on 12/6/15.
 */
public class TestEditController implements Initializable {

    private Test test;
    private MainApp mainApp;

    @FXML
    private TextField testNameField;
    @FXML
    private TextField minutesField;
    @FXML
    private ComboBox<Integer> difficultyDropdown;
    @FXML
    private TableView<Question> questionTable;
    @FXML
    private TableColumn<Question, String> questionColumn;
    @FXML
    private TableColumn<Question, Integer> difficultyColumn;
    @FXML
    private TableColumn<Question, Subject> subjectColumn;
    @FXML
    private TableColumn<Question, Course> courseColumn;
    @FXML
    private TableColumn<Question, String> typeColumn;
    @FXML
    private TableColumn<Question, LocalDate> dateColumn;
    @FXML
    private TableColumn<Question, Double> pointsColumn;

    public TestEditController(final Test test, final MainApp mainApp) {
        this.test = test;
        this.mainApp = mainApp;
    }

    @FXML
    private void backToTestMain() throws Exception {
        FXMLLoader load = new FXMLLoader(MainApp.class.getResource("View/TestBank/testbank.fxml"));
        AnchorPane curPane = (AnchorPane) load.load();

        TestBankController ranTest = load.getController();
        ranTest.setMain(mainApp);

        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        testNameField.setText(test.getName());
        minutesField.setText(String.valueOf(test.getTimeLimit()));
        difficultyDropdown.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        difficultyDropdown.getSelectionModel().select(new Integer(test.getDifficulty()));
        initializeQuestions();
    }

    private void initializeQuestions() {
        ObservableList<Question> testList = FXCollections.observableArrayList();
        test.getQuestions().forEach(testList::add);
        //Set the table's items
        questionTable.setItems(testList);

        questionColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getQuestion());
        });

        difficultyColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getDifficulty());
        });
        subjectColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getSubject());
        });
        courseColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getCourse());
        });
        typeColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getType());
        });
        dateColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<LocalDate>(c.getValue().getDate());
        });
        pointsColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<Double>(c.getValue().getPoints());
        });
    }

    @FXML
    private void handleSave() {
        String testName = testNameField.getText();
        int minutes = 0;
        int difficulty = difficultyDropdown.getValue();
        if (testName == null || testName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Test Name Invalid");
            alert.setContentText("Please enter a value to name the test.");
            alert.showAndWait();
            return;
        }
        try {
            minutes = Integer.parseInt(minutesField.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input");
            alert.setHeaderText("Time Limit Invalid");
            alert.setContentText("Please enter a valid value for a time limit (integer).");
            alert.showAndWait();
            return;
        }
        test.setName(testName);
        test.setTimeLimit(minutes);
        test.setDifficulty(difficulty);
    }

    @FXML
    private void handleRemove() {
        Question question = questionTable.getSelectionModel().getSelectedItem();
        if (question != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Selection");
            alert.setHeaderText("Delete a Question");
            alert.setContentText("Are you sure you wish to delete the question?\n" + question.getQuestion());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                test.getQuestions().remove(question);
                initializeQuestions();
            }
        }
    }

    @FXML
    private void handleEdit() throws Exception {
        Question question = questionTable.getSelectionModel().getSelectedItem();
        if (question != null) {
            Class questionClass = question.getClass();
            if (questionClass == Coding.class) {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/QuestionManagement/TestEditCodingEdit.fxml"));
                AnchorPane newScreen = (AnchorPane) loader.load();
                TestEditCodingEditHandler codeHandler = loader.getController();

                codeHandler.setQuestion((Coding) question);
                codeHandler.setTest(test);
                codeHandler.init2();
                codeHandler.setMain(mainApp);

                mainApp.rootLayout.setCenter(newScreen);
                mainApp.primaryStage.show();

            } else if (questionClass == FillInTheBlank.class) {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/QuestionManagement/TestEditFillInTheBlankEdit.fxml"));
                AnchorPane newScreen = (AnchorPane) loader.load();
                TestEditFillInTheBlankEditHandler fillHandler = loader.getController();

                fillHandler.setQuestion((FillInTheBlank) question);
                fillHandler.setTest(test);
                fillHandler.init2();
                fillHandler.setMain(mainApp);

                mainApp.rootLayout.setCenter(newScreen);
                mainApp.primaryStage.show();

            } else if (questionClass == FreeResponse.class) {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/QuestionManagement/TestEditFreeResponseEdit.fxml"));
                AnchorPane newScreen = (AnchorPane) loader.load();
                TestEditFreeResponseEditHandler freeHandler = loader.getController();

                freeHandler.setQuestion((FreeResponse) question);
                freeHandler.setTest(test);
                freeHandler.init2();
                freeHandler.setMain(mainApp);

                mainApp.rootLayout.setCenter(newScreen);
                mainApp.primaryStage.show();
            } else if (questionClass == MultipleChoice.class) {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/QuestionManagement/TestEditMultipleChoiceEdit.fxml"));
                AnchorPane newScreen = (AnchorPane) loader.load();
                TestEditMultipleChoiceEditHandler mceHandler = loader.getController();
                mceHandler.setQuestion((MultipleChoice) question);
                mceHandler.setTest(test);
                mceHandler.init2();
                mceHandler.setMain(mainApp);

                mainApp.rootLayout.setCenter(newScreen);
                mainApp.primaryStage.show();
            } else if (questionClass == TrueFalse.class) {
                FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/QuestionManagement/TestEditTrueFalseEdit.fxml"));
                AnchorPane newScreen = (AnchorPane) loader.load();
                TestEditTrueFalseEditHandler tfHandler = loader.getController();
                tfHandler.setQuestion((TrueFalse) question);
                tfHandler.setTest(test);
                tfHandler.init2();
                tfHandler.setMain(mainApp);

                mainApp.rootLayout.setCenter(newScreen);
                mainApp.primaryStage.show();
            }

        }
    }

    @FXML
    private void handleAdd() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/QuestionBank/EditTestQuesBank.fxml"));
        loader.setControllerFactory((cf) -> {
            return new EditTestQuesBankController(mainApp, test);
        });
        AnchorPane curPane = loader.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }
}
