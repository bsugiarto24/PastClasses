package TestTool.View.TestGrading;

import TestTool.MainApp;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.StudentTest;
import TestTool.Model.TestGrading.Status;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by mgolahi on 11/8/15.
 */
public class TestGradingQuestionController {
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

    @FXML
    private void initialize() {
        initializeText();
        initializeData();
    }

    private void initializeText() {
        Label nameField = new Label(studentTest.getName() + " - " + studentTest.getStudent());
        nameField.setFont(Font.font(30));
        titleStackPane.getChildren().add(nameField);
    }

    private void initializeData() {
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

        //Set the table's columns
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

        AGoptionsColumn.setCellValueFactory(c -> {
            Question question = c.getValue();
            String optionString = "";
            if (question.getClass() == MultipleChoice.class) {
                MultipleChoice mc = (MultipleChoice) question;
                for (int i = 0; i < mc.getOptions().size(); i++) {
                    if (mc.getAnswer().get(i) == 1) {
                        optionString += "(";
                    }
                    optionString += mc.getOptions().get(i);
                    if (mc.getAnswer().get(i) == 1) {
                        optionString += ")";
                    }
                    if (i != mc.getOptions().size() - 1) {
                        optionString += "\n";
                    }
                }
            } else if (question.getClass() == FillInTheBlank.class) {
                // TODO: Implement logic here when Pierson finishes it.
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

        AGanswerColumn.setCellValueFactory(c -> {
            Question question = c.getValue();
            String answerString = "";
            if (question.getClass() == MultipleChoice.class) {
                MultipleChoice mc = (MultipleChoice) question;
                for (int i = 0; i < mc.getOptions().size(); i++) {
                    if (mc.getStudentAnswer().get(i) == 1) {
                        answerString += "(";
                    }
                    answerString += mc.getOptions().get(i);
                    if (mc.getStudentAnswer().get(i) == 1) {
                        answerString += ")";
                    }
                    if (i != mc.getOptions().size() - 1) {
                        answerString += "\n";
                    }
                }
            } else if (question.getClass() == FillInTheBlank.class) {
                // TODO: Implement logic here when Pierson finishes it.
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

        PGUanswerColumn.setCellValueFactory(c -> {
            Question question = c.getValue();
            String answerString = "";
            if (question.getClass() == FreeResponse.class) {
                answerString = ((FreeResponse)question).getStudentAnswer();
            } else if (question.getClass() == Coding.class) {
                answerString = ((Coding)question).getStudentAnswer();
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
    }

    private void handleCheck(ActionEvent a) {

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
        studentTest.getScore().updateEarnedPoints(pointsBefore - question.getScore().getPointsEarned());
        initializeData();
    }

    @FXML
    private void handleFeedback() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("View/TestGrading/FeedbackPopover.fxml"));
        Parent newWindow = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(newWindow));
        stage.show();
    }
}
