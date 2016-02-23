package TestTool.View.TestGrading;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.StudentTest;
import TestTool.Model.TestGrading.Status;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by mgolahi on 11/8/15.
 */
public class TestGradingQuestionController implements Initializable {
    @FXML
    private StackPane titleStackPane;
    @FXML
    private Tab AGtab;
    @FXML
    private TableView<Question> AGtableView;
    @FXML
    private TableColumn<Question, String> AGpromptColumn;
    @FXML
    private TableColumn<Question, String> AGoptionsColumn;
    @FXML
    private TableColumn<Question, String> AGanswerColumn;
    @FXML
    private TableColumn<Question, String> AGpointsColumn;
    @FXML
    private Tab PGUtab;
    @FXML
    private TableView<Question> PGUtableView;
    @FXML
    private TableColumn<Question, String> PGUpromptColumn;
    @FXML
    private TableColumn<Question, String> PGUanswerColumn;
    @FXML
    private TableColumn<Question, String> PGUpointsColumn;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private StackPane overallProgressPane;

    private Text scoreField;
    private MainApp mainApp;
    private StudentTest studentTest;
    private ActiveTest activeTest;

    public TestGradingQuestionController(MainApp mainApp, StudentTest studentTest, ActiveTest activeTest) {
        this.mainApp = mainApp;
        this.studentTest = studentTest;
        this.activeTest = activeTest;

        if (activeTest.getStatus() == Status.NOT_STARTED) {
            activeTest.setStatus(Status.IN_PROGRESS);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeData();
        initializeText();
    }

    private void initializeText() {
        Label nameField = new Label(studentTest.getName() + " - " + studentTest.getStudent());
        nameField.setFont(Font.font(30));
        titleStackPane.getChildren().add(nameField);
    }

    protected void initializeData() {
        ObservableList<Question> AGtestList = FXCollections.observableArrayList();
        ObservableList<Question> PGUtestList = FXCollections.observableArrayList();
        for (Question question : studentTest.getQuestions()) {
            if (question.getScore().isAutoGraded()) {
                AGtestList.add(question);
            } else {
                PGUtestList.add(question);
            }
        }

        AGtableView.setItems(AGtestList);
        PGUtableView.setItems(PGUtestList);

        // Auto Graded Prompt Column
        AGpromptColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getQuestion());
        });
        AGpromptColumn.setCellFactory(c -> {
            return new TableCell<Question, String>() {
                private Text text;

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        text = new Text(item);
                        text.wrappingWidthProperty().bind(getTableColumn().widthProperty());
                        setGraphic(text);
                    }
                }
            };
        });

        // Partially Graded Prompt Column
        PGUpromptColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getQuestion());
        });
        PGUpromptColumn.setCellFactory(c -> {
            return new TableCell<Question, String>() {
                private Text text;

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        text = new Text(item);
                        text.wrappingWidthProperty().bind(getTableColumn().widthProperty());
                        setGraphic(text);
                    }
                }
            };
        });

        // Auto Graded Options Column
        AGoptionsColumn.setCellValueFactory(c -> {
            Question question = c.getValue();
            String optionString = "";
            if (question.getClass() == MultipleChoice.class) {
                MultipleChoice mc = (MultipleChoice) question;
                for (int i = 0; i < mc.getOptions().size(); i++) {
                    if (mc.getAnswer().contains(i)) {
                        optionString += "(";
                    }
                    optionString += mc.getOptions().get(i);
                    if (mc.getAnswer().contains(i)) {
                        optionString += ")";
                    }
                    if (i != mc.getOptions().size() - 1) {
                        optionString += "\n";
                    }
                }
            } else if (question.getClass() == FillInTheBlank.class) {
                FillInTheBlank fitb = (FillInTheBlank) question;
                optionString = fitb.getAnswer();
            } else if (question.getClass() == TrueFalse.class) {
                TrueFalse tf = (TrueFalse) question;
                if (tf.getAnswer()) {
                    optionString = "(True) / False";
                } else {
                    optionString = "True / (False)";
                }
            }
            return new ReadOnlyObjectWrapper<>(optionString);
        });
        AGoptionsColumn.setCellFactory(c -> {
            return new TableCell<Question, String>() {
                private Text text;

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        text = new Text(item);
                        text.wrappingWidthProperty().bind(getTableColumn().widthProperty());
                        setGraphic(text);
                    }
                }
            };
        });

        // Auto Graded Answer Column
        AGanswerColumn.setCellValueFactory(c -> {
            Question question = c.getValue();
            String answerString = "";
            if (question.getClass() == MultipleChoice.class) {
                MultipleChoice mc = (MultipleChoice) question;
                for (int i = 0; i < mc.getOptions().size(); i++) {
                    if (mc.getStudentAnswer().contains(i)) {
                        answerString += "(";
                    }
                    answerString += mc.getOptions().get(i);
                    if (mc.getStudentAnswer().contains(i)) {
                        answerString += ")";
                    }
                    if (i != mc.getOptions().size() - 1) {
                        answerString += "\n";
                    }
                }
            } else if (question.getClass() == FillInTheBlank.class) {
                FillInTheBlank fitb = (FillInTheBlank) question;
                answerString = fitb.getStudentAnswer();
            } else if (question.getClass() == TrueFalse.class) {
                TrueFalse tf = (TrueFalse) question;
                if (tf.getStudentAnswer()) {
                    answerString = "(True) / False";
                } else {
                    answerString = "True / (False)";
                }
            }
            return new ReadOnlyObjectWrapper<>(answerString);
        });
        AGanswerColumn.setCellFactory(c -> {
            return new TableCell<Question, String>() {
                private Text text;

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        text = new Text(item);
                        text.wrappingWidthProperty().bind(getTableColumn().widthProperty());
                        setGraphic(text);
                    }
                }
            };
        });

        // Partially Graded Answer Column
        PGUanswerColumn.setCellValueFactory(c -> {
            Question question = c.getValue();
            String answerString = "";
            if (question.getClass() == FreeResponse.class) {
                answerString = ((FreeResponse) question).getStudentAnswer();
            } else if (question.getClass() == Coding.class) {
                answerString = ((Coding) question).getStudentAnswer();
            }
            return new ReadOnlyObjectWrapper<>(answerString);
        });
        PGUanswerColumn.setCellFactory(c -> {
            return new TableCell<Question, String>() {
                private Text text;

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        text = new Text(item);
                        text.wrappingWidthProperty().bind(getTableColumn().widthProperty());
                        setGraphic(text);
                    }
                }
            };
        });

        // Auto Graded Points Column
        AGpointsColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(
                    Double.toString(c.getValue().getScore().getPointsEarned()) + " / " +
                            Double.toString(c.getValue().getPoints())
            );
        });
        AGpointsColumn.setCellFactory(c -> {
            return new TableCell<Question, String>() {
                private Text text;

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        text = new Text(item);
                        text.wrappingWidthProperty().bind(getTableColumn().widthProperty());
                        if (c.getTableView().getItems().get(getIndex()).getScore().isGraded()) {
                            text.setFont(Font.font(null, FontWeight.BOLD, 13));
                        }
                        setGraphic(text);
                    }
                }
            };
        });

        // Partially Graded Points Column
        PGUpointsColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(
                    Double.toString(c.getValue().getScore().getPointsEarned()) + " / " +
                            Double.toString(c.getValue().getPoints())
            );
        });
        PGUpointsColumn.setCellFactory(c -> {
            return new TableCell<Question, String>() {
                private Text text;

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!isEmpty()) {
                        text = new Text(item);
                        text.wrappingWidthProperty().bind(getTableColumn().widthProperty());
                        if (c.getTableView().getItems().get(getIndex()).getScore().isGraded()) {
                            text.setFont(Font.font(null, FontWeight.BOLD, 13));
                        }
                        setGraphic(text);
                    }
                }
            };
        });

        //Initialize the progress bar
        progressBar.setProgress(studentTest.getScore().getProgress());

        //Initialize the overall score
        Text newField = new Text(studentTest.getScore().getEarnedPoints() + "/" + studentTest.getScore().getPossiblePoints());
        newField.setFont(Font.font(null, FontWeight.BOLD, 13));
        overallProgressPane.getChildren().remove(scoreField);
        overallProgressPane.getChildren().add(newField);
        scoreField = newField;
    }

    @FXML
    private void handleBack() throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/TestGrading/TestGradingIndividual.fxml"));
        loader.setControllerFactory((cf) -> {
            return new TestGradingIndividualController(mainApp, activeTest);
        });
        AnchorPane curPane = loader.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    @FXML
    private void handleMarkCorrect() {
        Question question = null;
        if (AGtab.isSelected()) {
            question = AGtableView.getSelectionModel().getSelectedItem();
        } else if (PGUtab.isSelected()) {
            question = PGUtableView.getSelectionModel().getSelectedItem();
        }
        double pointsBefore = question.getScore().getPointsEarned();
        question.getScore().setPointsEarned(question.getPoints());
        if (!question.getScore().isGraded()) {
            question.getScore().setGraded();
            studentTest.getScore().updateGradedCount();
        }
        studentTest.getScore().updateEarnedPoints(question.getScore().getPointsEarned() - pointsBefore);
        initializeData();
    }

    @FXML
    private void handleMarkIncorrect() {
        Question question = null;
        if (AGtab.isSelected()) {
            question = AGtableView.getSelectionModel().getSelectedItem();
        } else if (PGUtab.isSelected()) {
            question = PGUtableView.getSelectionModel().getSelectedItem();
        }
        double pointsBefore = question.getScore().getPointsEarned();
        question.getScore().setPointsEarned(0);
        if (!question.getScore().isGraded()) {
            question.getScore().setGraded();
            studentTest.getScore().updateGradedCount();
        }
        studentTest.getScore().updateEarnedPoints(question.getScore().getPointsEarned() - pointsBefore);
        initializeData();
    }

    @FXML
    private void handleFeedback() throws Exception {
        Question question = null;
        if (AGtab.isSelected()) {
            question = AGtableView.getSelectionModel().getSelectedItem();
        } else if (PGUtab.isSelected()) {
            question = PGUtableView.getSelectionModel().getSelectedItem();
        }
        if (question != null) {
            goToFeedback(question);
        }
    }

    private void goToFeedback(Question question) throws Exception {
        FXMLLoader loader = null;
        if (PGUtab.isSelected()) {
            loader = new FXMLLoader(MainApp.class.getResource("View/TestGrading/FeedbackPopoverPGU.fxml"));
            loader.setControllerFactory((cf) -> {
                return new FeedbackPopoverPGUController(mainApp, activeTest, studentTest, question, this);
            });
        } else {
            loader = new FXMLLoader(MainApp.class.getResource("View/TestGrading/FeedbackPopoverAG.fxml"));
            loader.setControllerFactory((cf) -> {
                return new FeedbackPopoverAGController(mainApp, activeTest, studentTest, question, this);
            });
        }
        Parent newWindow = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newWindow));
        stage.show();
    }
}
