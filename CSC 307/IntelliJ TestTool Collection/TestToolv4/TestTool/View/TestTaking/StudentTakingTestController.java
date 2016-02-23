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
    private ArrayList<TextArea> FreeResponseAnswer = new ArrayList<TextArea>();
    @FXML
    private Button submit;

    @FXML
    private VBox QuestionVBox;

    @FXML
    private ArrayList<TableView<String>> TrueFalseSelectionTable = new ArrayList<TableView<String>>();

    @FXML
    private TableColumn<String, String> TrueFalseAnswerColumn;



    @FXML
    private ScrollPane QuestionScrollPane;

    private ObservableList<String> QuestionAnswersList;










    FXMLLoader loader = new FXMLLoader();

    public BorderPane rootLayout;

    //total answer count;
    private int anticipatedAnswerCount = 1;//TestTaking.getTestQuestion().size();
    //current answer index;
    private int currentAnswerIndex = 0;

    private MainApp mainApp;

    ArrayList<Question> temp;

    ArrayList<Question> questions = StudentTakingTest.returnQuestions();


    public void setStudentLoginController(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    private int previousQuestionIndex = 0;


    @FXML
    private void initialize() {

        int questionCount = 4;

        QuestionVBox = new VBox();
        QuestionScrollPane.setContent(QuestionVBox);
        VBox.setVgrow(QuestionScrollPane, Priority.ALWAYS);

        //true false spacing:
        ArrayList<Question> questions = new ArrayList<Question>();
        Question question1 = new TrueFalse();
        Question question2 = new MultipleChoice();
        Question question3 = new TrueFalse();
        question1.setQuestion("hellolllll?");
        question1.setType("TrueFalse");

        question2.setQuestion("what?");
        question2.setType("MultipleChoice");

        question3.setQuestion("huh?");
        question3.setType("FreeResponse");

        questions.add(0, question1);
        questions.add(1, question2);
        questions.add(2, question3);
        temp = questions;


        for (int i = 0; i < questions.size(); i++ ) {

            switch (questions.get(i).getType()) {
                case "TrueFalse": TrueFalseBuild(QuestionVBox, QuestionScrollPane, TrueFalseSelectionTable, TrueFalseAnswerColumn, QuestionAnswersList, questions, i);
                    break;
                case "MultipleChoice": MultipleChoiceBuild(QuestionVBox, QuestionScrollPane, TrueFalseSelectionTable, TrueFalseAnswerColumn, QuestionAnswersList, questions, i);
                    break;
                case "FreeResponse": FRQBuild(FreeResponseAnswer, QuestionVBox, questions, i, previousQuestionIndex);
                    previousQuestionIndex = i;
                    System.out.println("here");
                    break;
                case "Coding":
                    FRQBuild(FreeResponseAnswer, QuestionVBox, questions, i, previousQuestionIndex);
                    previousQuestionIndex = i;
                    break;
                case "FillInBlank": FRQBuild(FreeResponseAnswer, QuestionVBox, questions, i, previousQuestionIndex);
                    previousQuestionIndex = i;
                    break;
                default:
                    break;
            }
        }

    }

    @FXML
    public void onSubmit() {
        try {

            if (StudentTakingTest.submitTest(StudentLogin.returnTestNum()) == null) {


                System.out.println(FreeResponseAnswer.get(2).getText());

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
                                      ArrayList<Question> questions, int questionIndex){

        TrueFalseSelectionTable.add(questionIndex,new TableView<>());
        TrueFalseAnswerColumn = new TableColumn<String, String>("Answer");
        QuestionAnswersList = FXCollections.observableArrayList();
        QVBox.setPadding(new Insets(10, 50, 50, 50));
        TrueFalseSelectionTable.get(questionIndex).setFixedCellSize(30);
        TrueFalseSelectionTable.get(questionIndex).setPrefHeight(89);


        QuestionAnswersList.add("True");
        QuestionAnswersList.add("False");

        QVBox.setSpacing(60);
        Label label = new Label(questions.get(questionIndex).getQuestion());
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
                System.out.println("got Q " + questionIndex);
            }
        });
    }


    public static void MultipleChoiceBuild(VBox QVBox, ScrollPane QSPane, ArrayList<TableView<String>> TrueFalseSelectionTable,
                                      TableColumn<String, String> TrueFalseAnswerColumn, ObservableList<String> QuestionAnswersList,
                                      ArrayList<Question> questions, int questionIndex) {


        TrueFalseSelectionTable.add(questionIndex, new TableView<>());
        TrueFalseAnswerColumn = new TableColumn<String, String>("Answer");
        QuestionAnswersList = FXCollections.observableArrayList();

        QuestionAnswersList.add("answer1");
        QuestionAnswersList.add("answer2");
        QuestionAnswersList.add("answer3");
        QuestionAnswersList.add("answer4");
        QuestionAnswersList.add("answer5");


        QVBox.setPadding(new Insets(10, 50, 50, 50));
        TrueFalseSelectionTable.get(questionIndex).setPrefHeight(QuestionAnswersList.size() * 33);




        QVBox.setSpacing(60);
        Label label = new Label(questions.get(questionIndex).getQuestion());
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
                System.out.println("got Q 2");
            }
        });

    }

    public static void FRQBuild(ArrayList<TextArea> FRQAnswer, VBox QVBox, ArrayList<Question> questionList, int questionIndex, int prevQIndex) {

        for (int i = prevQIndex; i < questionIndex; i++) {
            FRQAnswer.add(i, null);
        }

        FRQAnswer.add(questionIndex, new TextArea());
        QVBox.setSpacing(60);
        Label label = new Label(questionList.get(questionIndex).getQuestion());
        label.setFont(Font.font(20));
        QVBox.getChildren().add(label);
        QVBox.setSpacing(30);
        QVBox.getChildren().add(FRQAnswer.get(questionIndex));
        QVBox.setPadding(new Insets(10, 50, 50, 50));

        FRQAnswer.get(questionIndex).setPrefWidth(50);
    }

}