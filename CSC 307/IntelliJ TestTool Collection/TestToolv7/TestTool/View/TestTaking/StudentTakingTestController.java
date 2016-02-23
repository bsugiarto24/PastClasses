package TestTool.View.TestTaking;


import TestTool.MainApp;
import TestTool.Model.TestTaking.StudentLogin;
import TestTool.Model.TestTaking.StudentTakingTest;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.TestTaking.TestTaking;
import com.sun.tools.javac.comp.Check;
import com.sun.tools.javac.util.Name;
import javafx.animation.AnimationTimer;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.*;


/**
 * Created by Dylan on 11/8/15.
 */
public class StudentTakingTestController {

    @FXML
    private ArrayList<TextArea> FreeResponseAnswer;
    @FXML
    private Button submit;

    @FXML
    private VBox QuestionVBox;

    @FXML
    private ArrayList<TableView<String>> TrueFalseSelectionTable;

    @FXML
    private TableColumn<String, String> TrueFalseAnswerColumn;

    @FXML
    private ScrollPane QuestionScrollPane;

    private ObservableList<String> QuestionAnswersList;


    FXMLLoader loader = new FXMLLoader();

    public BorderPane rootLayout;

    private MainApp mainApp;

    private ArrayList<Question> temp;

    private ArrayList<Question> questions = StudentTakingTest.returnQuestions();

    private ArrayList<Integer> FRQIndex;

    private ArrayList<Boolean> FinishedQuestions;

    private static boolean selected = false;


    public void setStudentLoginController(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    private int previousQuestionIndex = 0;


    @FXML
    private void initialize() {

        FRQIndex = new ArrayList<Integer>();
        TrueFalseSelectionTable = new ArrayList<TableView<String>>();
        FreeResponseAnswer = new ArrayList<TextArea>();
        FinishedQuestions = new ArrayList<Boolean>();

        QuestionVBox = new VBox();
        QuestionScrollPane.setContent(QuestionVBox);
        VBox.setVgrow(QuestionScrollPane, Priority.ALWAYS);


        //true false spacing:

        for (int i = 0; i < questions.size(); i++ ) {

            switch (questions.get(i).getType()) {
                case "TrueFalse": TrueFalseBuild(QuestionVBox, QuestionScrollPane, TrueFalseSelectionTable, TrueFalseAnswerColumn, QuestionAnswersList, questions,FinishedQuestions, i);
                    break;
                case "MultipleChoice": MultipleChoiceBuild(QuestionVBox, QuestionScrollPane, TrueFalseSelectionTable, TrueFalseAnswerColumn, QuestionAnswersList, questions, FinishedQuestions, i);
                    break;
                case "FreeResponse": FRQBuild(FreeResponseAnswer, QuestionVBox, questions,FRQIndex, FinishedQuestions, i, previousQuestionIndex);
                    previousQuestionIndex = i;
                    break;
                case "Coding":
                    FRQBuild(FreeResponseAnswer, QuestionVBox, questions, FRQIndex, FinishedQuestions, i, previousQuestionIndex);
                    previousQuestionIndex = i;
                    break;
                case "FillInBlank":
                    FRQBuild(FreeResponseAnswer, QuestionVBox, questions, FRQIndex, FinishedQuestions, i, previousQuestionIndex);
                    previousQuestionIndex = i;
                    break;
                default:
                    break;
            }
        }

    }

    @FXML
    public void onSubmit() {
        for (int i = 0; i < FRQIndex.size(); i++) {
            //submits frq answers   -- get from FRQAnswer
            FinishedQuestions.add(true);
            FinishedQuestions.add(FRQIndex.get(i), true);
        }
        try {
            if (TestTaking.isFinished(FinishedQuestions)) {
                submit.requestFocus();

                loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingSubmit.fxml"));
                AnchorPane newScreen = (AnchorPane) loader.load();

                mainApp.rootLayout.setCenter(newScreen);
                mainApp.primaryStage.show();

                StudentFinishedScreenController controller = loader.getController();
                controller.setStudentFinishedController(mainApp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TrueFalseBuild(VBox QVBox, ScrollPane QSPane, ArrayList<TableView<String>> TrueFalseSelectionTable,
                                      TableColumn<String, String> TrueFalseAnswerColumn, ObservableList<String> QuestionAnswersList,
                                      ArrayList<Question> questions, ArrayList<Boolean> FinishedQuestions,int questionIndex){
        selected = true;

        TrueFalseSelectionTable.add(questionIndex,new TableView<>());
        TrueFalseAnswerColumn = new TableColumn<String, String>("Answer");
        QuestionAnswersList = FXCollections.observableArrayList();
        QVBox.setPadding(new Insets(10, 50, 50, 50));
        TrueFalseSelectionTable.get(questionIndex).setFixedCellSize(30);
        TrueFalseSelectionTable.get(questionIndex).setPrefHeight(89);


        QuestionAnswersList.add("True");
        QuestionAnswersList.add("False");

        QVBox.setSpacing(60);
        Label label = new Label(questionIndex + ") "+questions.get(questionIndex).getQuestion());
        label.setFont(Font.font(20));
        QVBox.getChildren().add(label);
        QVBox.setSpacing(30);
        QVBox.getChildren().add(TrueFalseSelectionTable.get(questionIndex));

        TrueFalseAnswerColumn.setPrefWidth(642);
        TrueFalseSelectionTable.get(questionIndex).getColumns().add(TrueFalseAnswerColumn);

        TrueFalseSelectionTable.get(questionIndex).setItems(QuestionAnswersList);
        TrueFalseAnswerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));


        TrueFalseSelectionTable.get(questionIndex).setOnMouseClicked(event -> {
            System.out.println(TrueFalseSelectionTable.get(questionIndex).getSelectionModel().getSelectedIndex());
            if (TrueFalseSelectionTable.get(questionIndex).getSelectionModel().getSelectedIndex() > (-1)) {
                if (selected) {
                    FinishedQuestions.add(true);
                    selected = false;
                }
                //Saves question answer
            }
        });
    }


    public static void MultipleChoiceBuild(VBox QVBox, ScrollPane QSPane, ArrayList<TableView<String>> TrueFalseSelectionTable,
                                      TableColumn<String, String> TrueFalseAnswerColumn, ObservableList<String> QuestionAnswersList,
                                      ArrayList<Question> questions, ArrayList<Boolean> FinishedQuestions, int questionIndex) {

        selected = true;

        TrueFalseSelectionTable.get(questionIndex).getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TrueFalseSelectionTable.add(questionIndex, new TableView<>());
        TrueFalseAnswerColumn = new TableColumn<String, String>("Choices");
        QuestionAnswersList = FXCollections.observableArrayList();

        for (int i = 0; i < ((MultipleChoice) questions.get(questionIndex)).getOptions().size() ; i++) {
            QuestionAnswersList.add(((MultipleChoice) questions.get(questionIndex)).getOptions().get(i));
        }


        QVBox.setPadding(new Insets(10, 50, 50, 50));
        TrueFalseSelectionTable.get(questionIndex).setPrefHeight(QuestionAnswersList.size() * 33);




        QVBox.setSpacing(60);
        Label label = new Label(questionIndex +") "+questions.get(questionIndex).getQuestion());
        label.setFont(Font.font(20));
        QVBox.getChildren().add(label);
        QVBox.setSpacing(30);
        QVBox.getChildren().add(TrueFalseSelectionTable.get(questionIndex));

        TrueFalseAnswerColumn.setPrefWidth(642);
        TrueFalseSelectionTable.get(questionIndex).getColumns().add(TrueFalseAnswerColumn);

        TrueFalseSelectionTable.get(questionIndex).setItems(QuestionAnswersList);
        TrueFalseAnswerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));


        TrueFalseSelectionTable.get(questionIndex).setOnMouseClicked(event -> {
            System.out.println(TrueFalseSelectionTable.get(questionIndex).getSelectionModel().getSelectedIndex());
            if (selected) {
                FinishedQuestions.add(true);
            }
            if (TrueFalseSelectionTable.get(questionIndex).getSelectionModel().getSelectedIndex() > (-1)) {
                //saves question answer
            }
        });

    }

    public static void FRQBuild(ArrayList<TextArea> FRQAnswer, VBox QVBox, ArrayList<Question> questionList, ArrayList<Integer> FRQIndex,
                                ArrayList<Boolean> FinishedQuestions, int questionIndex, int prevQIndex) {

        for (int i = prevQIndex + 1; i < questionIndex; i++) {
            FRQAnswer.add(i, null);
        }
        FRQIndex.add(questionIndex);


        FRQAnswer.add(questionIndex, new TextArea());
        QVBox.setSpacing(60);
        Label label = new Label(questionIndex + ") "+ questionList.get(questionIndex).getQuestion());
        label.setFont(Font.font(20));
        QVBox.getChildren().add(label);
        QVBox.setSpacing(30);
        QVBox.getChildren().add(FRQAnswer.get(questionIndex));
        QVBox.setPadding(new Insets(10, 50, 50, 50));

        FRQAnswer.get(questionIndex).setPrefWidth(50);
    }

}