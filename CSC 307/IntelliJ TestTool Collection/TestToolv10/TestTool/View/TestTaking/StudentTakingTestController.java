package TestTool.View.TestTaking;


import TestTool.MainApp;
import TestTool.Model.TestTaking.StudentLogin;
import TestTool.Model.TestTaking.StudentTakingTest;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.TestTaking.TestTaking;
import com.sun.org.apache.bcel.internal.generic.Select;
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
    private ArrayList<TextArea> FreeResponseAnswer = new ArrayList<>();
    @FXML
    private Button submit;

    @FXML
    private VBox QuestionVBox;

    @FXML
    private ArrayList<TableView<String>> SelectionTable;

    @FXML
    private ArrayList<TableView<String>> MCSelectionTable;

    @FXML
    private TableColumn<String, String> AnswerColumn;

    @FXML
    private ScrollPane QuestionScrollPane;

    @FXML
    private ArrayList<TextArea> CodingAnswer;

    @FXML
    private ArrayList<TextArea> FillinTheBlankAnswer;




    FXMLLoader loader = new FXMLLoader();


    private ObservableList<String> QuestionAnswersList;

    public BorderPane rootLayout;

    private MainApp mainApp;

    private ArrayList<Question> temp;

    private ArrayList<Question> questions = StudentTakingTest.returnQuestions();

    private ArrayList<Integer> FRQIndex;

    private ArrayList<Boolean> FinishedSelectionQuestions;

    private static boolean selected = false;

    private ArrayList<Integer> FillBlankIndexes;

    private ArrayList<Integer> CodingIndexes;


    public void setStudentLoginController(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    private int previousCodingQuestionIndex = 0;

    private int previousFRQQuestionIndex = 0;

    private int previousFillBlankQuestionIndex = 0;

    private int previousMCQuestionIndex = 0;

    private int previousTFQuestionIndex = 0;


    @FXML
    private void initialize() {

        FRQIndex = new ArrayList<Integer>();
        SelectionTable = new ArrayList<TableView<String>>();
        CodingAnswer = new ArrayList<TextArea>();
        FillinTheBlankAnswer = new ArrayList<TextArea>();
        FinishedSelectionQuestions = new ArrayList<Boolean>();
        FillBlankIndexes = new ArrayList<>();
        CodingIndexes = new ArrayList<>();
        MCSelectionTable = new ArrayList<>();

        FreeResponseAnswer.clear();

        QuestionVBox = new VBox();
        QuestionScrollPane.setContent(QuestionVBox);
        VBox.setVgrow(QuestionScrollPane, Priority.ALWAYS);

        //true false spacing:


        //dummy data
        /*ArrayList<Question>  questions = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<String> choices = new ArrayList<>();

        choices.add("answer1");
        choices.add("answer2");
        choices.add("answer3");
        choices.add("answer4");
        answer.add(1);
        Question q1 = new TrueFalse();
        Question q2 = new MultipleChoice();
        q1.setQuestion("what");
        q2.setQuestion(("huh"));

        q1.setType("True/False");
        q2.setType("Multiple Choice");

        ((MultipleChoice) q1).setAnswer(answer);
        ((MultipleChoice) q2).setAnswer(answer);

        ((MultipleChoice) q1).setOption(choices);
        ((MultipleChoice) q2).setOption(choices);

        questions.add(q1);
        questions.add(q2);*/

        for (int i = 0; i < questions.size(); i++ ) {
            System.out.println(questions.get(i).getType());

            switch (questions.get(i).getType()) {
                case "True/False": TrueFalseBuild(QuestionVBox, QuestionScrollPane, SelectionTable, AnswerColumn, QuestionAnswersList, questions,FinishedSelectionQuestions, i, previousTFQuestionIndex);
                    previousTFQuestionIndex = i;
                    break;
                case "Multiple Choice": MultipleChoiceBuild(QuestionVBox, QuestionScrollPane, MCSelectionTable, AnswerColumn, QuestionAnswersList, questions, FinishedSelectionQuestions, i, previousMCQuestionIndex);
                    previousMCQuestionIndex = i;
                    break;
                case "Free-Response": FRQBuild(FreeResponseAnswer, QuestionVBox, questions,FRQIndex, i, previousFRQQuestionIndex);
                    previousFRQQuestionIndex = i;
                    FRQIndex.add(i);
                    break;
                case "Coding":
                    FRQBuild(CodingAnswer, QuestionVBox, questions, CodingIndexes, i, previousCodingQuestionIndex);
                    previousCodingQuestionIndex = i;
                    CodingIndexes.add(i);
                    break;
                case "Fill-In-The-Blank":
                    FRQBuild(FillinTheBlankAnswer, QuestionVBox, questions, FillBlankIndexes, i, previousFillBlankQuestionIndex);
                    previousFillBlankQuestionIndex = i;
                    FillBlankIndexes.add(i);
                    break;
                default:
                    break;
            }
        }

    }

    @FXML
    public void onSubmit() {
        int totalCount = FRQIndex.size() + CodingIndexes.size() + FillBlankIndexes.size();

        try {
            if (TestTaking.isFinished(FinishedSelectionQuestions, totalCount )) {
                for (int i = 0; i < FRQIndex.size(); i++) {
                    ((FreeResponse) questions.get(FRQIndex.get(i))).setAnswer(FreeResponseAnswer.get(FRQIndex.get(i)).getText());
                    //System.out.println(FreeResponseAnswer.get(FRQIndex.get(i)).getText());
                }
                for (int i = 0; i < CodingIndexes.size(); i++) {
                    ((Coding) questions.get(CodingIndexes.get(i))).setAnswer(CodingAnswer.get(CodingIndexes.get(i)).getText());
                }
                for (int i = 0; i < FillBlankIndexes.size(); i++ ) {
                    ((FillInTheBlank) questions.get(FillBlankIndexes.get(i))).setAnswer(FillinTheBlankAnswer.get(FillBlankIndexes.get(i)).getText());
                    //System.out.println(FillinTheBlankAnswer.get(FillBlankIndexes.get(i)).getText());

                }
                submit.requestFocus();

                loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingSubmit.fxml"));
                AnchorPane newScreen = (AnchorPane) loader.load();

                mainApp.rootLayout.setCenter(newScreen);
                mainApp.primaryStage.show();

                StudentFinishedScreenController controller = loader.getController();
                controller.setStudentFinishedController(mainApp);
            }
            else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Test Is Not Complete");
                    alert.setContentText("You have no yet completed all questions");
                    alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TrueFalseBuild(VBox QVBox, ScrollPane QSPane, ArrayList<TableView<String>> SelectionTable,
                                      TableColumn<String, String> AnswerColumn, ObservableList<String> QuestionAnswersList,
                                      ArrayList<Question> questions, ArrayList<Boolean> FinishedQuestions,int questionIndex,
                                      int previous){
        selected = true;

        for(int i = previous; i < questionIndex; i++) {
            SelectionTable.add(i, null);
        }

        SelectionTable.add(new TableView<>());
        AnswerColumn = new TableColumn<String, String>("Answer");
        QuestionAnswersList = FXCollections.observableArrayList();
        QVBox.setPadding(new Insets(10, 50, 50, 50));
        SelectionTable.get(questionIndex).setFixedCellSize(30);
        SelectionTable.get(questionIndex).setPrefHeight(89);


        QuestionAnswersList.add("True");
        QuestionAnswersList.add("False");

        QVBox.setSpacing(60);
        //gets the question
        Label label = new Label((questionIndex + 1) + ") "+questions.get(questionIndex).getQuestion());
        label.setFont(Font.font(20));
        QVBox.getChildren().add(label);
        QVBox.setSpacing(30);
        QVBox.getChildren().add(SelectionTable.get(questionIndex));

        AnswerColumn.setPrefWidth(642);
        SelectionTable.get(questionIndex).getColumns().add(AnswerColumn);

        SelectionTable.get(questionIndex).setItems(QuestionAnswersList);
        AnswerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));


        SelectionTable.get(questionIndex).setOnMouseClicked(event -> {
            if (selected) {
                FinishedQuestions.add(true);
                selected = false;
            }
            if (SelectionTable.get(questionIndex).getSelectionModel().getSelectedIndex() > (-1)) {
                //Saves question answer
                if (SelectionTable.get(questionIndex).getSelectionModel().getSelectedIndex() == 0) {
                    ((TrueFalse) questions.get(questionIndex)).setAnswer(false);
                }
                else {
                    ((TrueFalse) questions.get(questionIndex)).setAnswer(true);
                }
            }
        });
    }


    public static void MultipleChoiceBuild(VBox QVBox, ScrollPane QSPane, ArrayList<TableView<String>> SelectionTable,
                                      TableColumn<String, String> AnswerColumn, ObservableList<String> QuestionAnswersList,
                                      ArrayList<Question> questions, ArrayList<Boolean> FinishedQuestions, int questionIndex,
                                           int previous) {

        selected = true;
        for(int i = previous; i < questionIndex; i++) {
            SelectionTable.add(i, null);
        }

        ArrayList<Integer> MCQs = new ArrayList<Integer>();

        SelectionTable.add(new TableView<>());

        AnswerColumn = new TableColumn<String, String>("Choices");
        QuestionAnswersList = FXCollections.observableArrayList();

        MultipleChoice MCQuestion = ((MultipleChoice)questions.get(questionIndex));

        for (int i = 0; i < ((MultipleChoice) questions.get(questionIndex)).getOptions().size() ; i++) {
            QuestionAnswersList.add(((MultipleChoice) questions.get(questionIndex)).getOptions().get(i));
        }


        QVBox.setPadding(new Insets(10, 50, 50, 50));
        SelectionTable.get(questionIndex).setPrefHeight(QuestionAnswersList.size() * 33);





        QVBox.setSpacing(60);
        Label label = new Label((questionIndex + 1) +") "+questions.get(questionIndex).getQuestion());
        label.setFont(Font.font(20));
        QVBox.getChildren().add(label);
        QVBox.setSpacing(30);
        QVBox.getChildren().add(SelectionTable.get(questionIndex));

        AnswerColumn.setPrefWidth(642);
        SelectionTable.get(questionIndex).getColumns().add(AnswerColumn);

        SelectionTable.get(questionIndex).setItems(QuestionAnswersList);
        AnswerColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));


        SelectionTable.get(questionIndex).setOnMouseClicked(event -> {
            if(selected) {
                FinishedQuestions.add(true);
                selected = false;
            }
            MCQs.clear();
            MCQs.add(SelectionTable.get(questionIndex).getSelectionModel().getSelectedIndex());
            if (SelectionTable.get(questionIndex).getSelectionModel().getSelectedIndex() > (-1)) {
                //saves question answer
                ((MultipleChoice) questions.get(questionIndex)).setAnswer(MCQs);

            }
        });

    }

    public static void FRQBuild(ArrayList<TextArea> FRQAnswer, VBox QVBox, ArrayList<Question> questionList, ArrayList<Integer> FRQIndex,
                                int questionIndex, int prevQIndex) {
        for (int i = prevQIndex; i < questionIndex; i++) {
            FRQAnswer.add(i, null);
        }


        FRQAnswer.add(new TextArea());

        QVBox.setSpacing(60);
        Label label = new Label((questionIndex + 1) + ") "+ questionList.get(questionIndex).getQuestion());
        label.setFont(Font.font(20));
        QVBox.getChildren().add(label);
        QVBox.setSpacing(30);
        QVBox.getChildren().add(FRQAnswer.get(questionIndex));
        QVBox.setPadding(new Insets(10, 50, 50, 50));

        FRQAnswer.get(questionIndex).setPrefWidth(632);
    }
}