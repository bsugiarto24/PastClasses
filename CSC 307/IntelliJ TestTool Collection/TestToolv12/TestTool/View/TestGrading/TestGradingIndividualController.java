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
import javafx.scene.control.*;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by mgolahi on 11/30/15.
 */
public class TestGradingIndividualController implements Initializable {

    @FXML
    private TextField testNameField;
    @FXML
    private TextField courseField;
    @FXML
    private TextField subjectField;
    @FXML
    private TextField dateTakenField;
    @FXML
    private TextField statusField;
    @FXML
    private TextField studentNamePrompt;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private StackPane progressBarStackPane;
    @FXML
    private StackPane testNameStackPane;
    @FXML
    private Tab IPtab;
    @FXML
    private TableView<StudentTest> IPtable;
    @FXML
    private TableColumn<StudentTest, String> IPstudentColumn;
    @FXML
    private TableColumn<StudentTest, Double> IPprogressColumn;
    @FXML
    private TableColumn<StudentTest, String> IPprogressStringColumn;
    @FXML
    private Tab Ctab;
    @FXML
    private TableView<StudentTest> Ctable;
    @FXML
    private TableColumn<StudentTest, String> CstudentColumn;
    @FXML
    private TableColumn<StudentTest, Double> CprogressColumn;
    @FXML
    private TableColumn<StudentTest, String> CprogressStringColumn;

    private MainApp mainApp;
    private ActiveTest activeTest;

    public TestGradingIndividualController(MainApp mainApp, ActiveTest activeTest) {
        this.mainApp = mainApp;
        this.activeTest = activeTest;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        autoGradeQuestions();
        initializeProgressBar(initializeTables(activeTest.getStudentTests()));
        initializeText();
    }

    private void autoGradeQuestions() {
        for (StudentTest sTest : activeTest.getStudentTests()) {
            sTest.getScore().setEarnedPoints(0);
            sTest.getScore().setGradedCount(0);
            for (Question question : sTest.getQuestions()) {
                if (question.getScore().isGraded()) {
                    sTest.getScore().updateGradedCount();
                    sTest.getScore().updateEarnedPoints(question.getScore().getPointsEarned());
                } else {
                    Class qclass = question.getClass();
                    if (qclass == TrueFalse.class) {
                        TrueFalse tf = (TrueFalse) question;
                        if (tf.isCorrect()) {
                            tf.getScore().setPointsEarned(tf.getPoints());
                            sTest.getScore().updateEarnedPoints(tf.getPoints());
                        } else {
                            tf.getScore().setPointsEarned(0);
                        }
                        tf.getScore().setGraded();
                        tf.getScore().setAutoGraded();
                        sTest.getScore().updateGradedCount();
                    } else if (qclass == MultipleChoice.class) {
                        MultipleChoice mc = (MultipleChoice) question;
                        if (mc.isCorrect()) {
                            mc.getScore().setPointsEarned(mc.getPoints());
                            sTest.getScore().updateEarnedPoints(mc.getPoints());
                        } else {
                            mc.getScore().setPointsEarned(0);
                        }
                        mc.getScore().setGraded();
                        mc.getScore().setAutoGraded();
                        sTest.getScore().updateGradedCount();
                    } else if (qclass == FillInTheBlank.class) {
                        FillInTheBlank fb = (FillInTheBlank) question;
                        if (fb.isCorrect()) {
                            fb.getScore().setPointsEarned(fb.getPoints());
                            sTest.getScore().updateEarnedPoints(fb.getPoints());
                        } else {
                            fb.getScore().setPointsEarned(0);
                        }
                        fb.getScore().setGraded();
                        fb.getScore().setAutoGraded();
                        sTest.getScore().updateGradedCount();
                    }
                }
            }
            sTest.getScore().setComplete();
        }
    }

    private void initializeText() {
        Label nameField = new Label(activeTest.getTest().getName());
        nameField.setFont(Font.font(30));
        testNameStackPane.getChildren().add(nameField);
        testNameField.setText(activeTest.getTest().getName());
        courseField.setText(activeTest.getTest().getCourse().toString());
        subjectField.setText(activeTest.getTest().getSubject().toString());
        dateTakenField.setText(activeTest.getDate().toString());
        statusField.setText(activeTest.getStatus().toString());
    }

    /**
     * Operating under the assumption that the tests have already been auto graded! Order of initialization matters.
     */
    private int initializeTables(ArrayList<StudentTest> currentStudentTests) {
        ObservableList<StudentTest> IPtestList = FXCollections.observableArrayList();
        ObservableList<StudentTest> CtestList = FXCollections.observableArrayList();
        int done = 0;
        for (StudentTest test : currentStudentTests) {
            if (test.getScore().isComplete()) {
                CtestList.add(test);
                done++;
            } else {
                IPtestList.add(test);
            }
        }
        //Set the table's items to the tests
        IPtable.setItems(IPtestList);
        Ctable.setItems(CtestList);

        //Set the table's columns
        IPstudentColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getStudent());
        });
        IPprogressColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getScore().getProgress());
        });
        IPprogressColumn.setCellFactory(ProgressBarTableCell.<StudentTest>forTableColumn());
        IPprogressStringColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(
                    Integer.toString(c.getValue().getScore().getGradedCount()) + "/" +
                            Integer.toString(c.getValue().getScore().getTotalCount())
            );
        });
        CstudentColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getStudent());
        });
        CprogressColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getScore().getProgress());
        });
        CprogressColumn.setCellFactory(ProgressBarTableCell.<StudentTest>forTableColumn());
        CprogressStringColumn.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(
                    Integer.toString(c.getValue().getScore().getGradedCount()) + "/" +
                            Integer.toString(c.getValue().getScore().getTotalCount())
            );
        });
        return done;
    }

    private void initializeProgressBar(int done) {
        //Check if all StudentTests done
        if (Double.compare(((double) done) / activeTest.getStudentTests().size(), 1.0) == 0) {
            activeTest.setStatus(Status.COMPLETE);
        }

        //Overall Progress bar
        Label progress = new Label(Integer.toString(done) + "/" + Integer.toString(activeTest.getStudentTests().size()));
        progressBarStackPane.getChildren().add(progress);
        progressBar.setProgress(((double) done) / activeTest.getStudentTests().size());
    }

    @FXML
    private void handleBack() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/TestGrading/TestGradingMain.fxml"));
        AnchorPane curPane = (AnchorPane) loader.load();
        TestGradingMainController mainController = loader.getController();
        mainController.setMain(mainApp);
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    @FXML
    private void handleSelect() throws Exception {
        StudentTest studentTest = null;
        if (IPtab.isSelected()) {
            studentTest = IPtable.getSelectionModel().getSelectedItem();
        } else if (Ctab.isSelected()) {
            studentTest = Ctable.getSelectionModel().getSelectedItem();
        }
        if (studentTest != null) {
            initializeQuestionController(studentTest);
        }
    }

    /**
     * Abstracted out since any variables used in a lambda must be final.
     *
     * @param studentTest
     * @throws Exception
     */
    private void initializeQuestionController(StudentTest studentTest) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/TestGrading/TestGradingQuestions.fxml"));
        loader.setControllerFactory((cf) -> {
            return new TestGradingQuestionController(mainApp, studentTest, activeTest);
        });
        AnchorPane curPane = loader.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    @FXML
    private void handleFilter() {
        String property = studentNamePrompt.getText();
        ArrayList<StudentTest> filtered = new ArrayList<>();
        for (StudentTest test : activeTest.getStudentTests()) {
            String[] wholeName = test.getStudent().split(" ");
            String firstName = wholeName[0];
            String lastName = wholeName[1];
            if (firstName.toLowerCase().startsWith(property.toLowerCase()) ||
                    lastName.toLowerCase().startsWith(property.toLowerCase())) {
                filtered.add(test);
            }
        }
        initializeTables(filtered);
    }
}
