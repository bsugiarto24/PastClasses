package TestTool.View.QuestionBank;

import TestTool.MainApp;
import TestTool.Model.QuestionBank.BankOptions;
import TestTool.Model.QuestionBank.QuestionBank;
import TestTool.Model.QuestionCreation.*;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.SubjectCollection;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.Test;
import TestTool.Model.TestGrading.QuestionScore;
import TestTool.Model.TestGrading.Status;
import TestTool.View.TestCreation.TestEditController;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by mgolahi on 12/8/15.
 */
public class EditTestQuesBankController implements Initializable {

    private MainApp mainApp;
    private Test test;
    private FXMLLoader load;
    private AnchorPane curPane;

    @FXML
    private TextField searchBar;
    @FXML
    private ComboBox<Integer> diffBox;
    @FXML
    private ComboBox<Subject> subjectBox;
    @FXML
    private ComboBox<Course> courseBox;
    @FXML
    private ComboBox<String> quesTypeBox;
    @FXML
    private TableView<Question> quesTable;
    @FXML
    private TableColumn<Question, String> questionCol;
    @FXML
    private TableColumn<Question, Integer> diffCol;
    @FXML
    private TableColumn<Question, Subject> subjCol;
    @FXML
    private TableColumn<Question, Course> courseCol;
    @FXML
    private TableColumn<Question, String> typeCol;
    @FXML
    private TableColumn<Question, LocalDate> dateCol;
    @FXML
    private TableColumn<Question, Double> pointsCol;
    @FXML
    private DatePicker startDa;
    @FXML
    private DatePicker endDa;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeListeners();
        initializeDropdowns();
        filter();
    }

    public EditTestQuesBankController(final MainApp mainApp, final Test test) {
        this.mainApp = mainApp;
        this.test = test;
    }

    private void setQuestions(ArrayList<Question> questions) {
        ObservableList<Question> testList = FXCollections.observableArrayList();
        questions.forEach(testList::add);
        //Set the table's items
        quesTable.setItems(testList);

        //Set the table's columns
        questionCol.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getQuestion());
        });
        diffCol.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getDifficulty());
        });
        subjCol.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getSubject());
        });
        courseCol.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getCourse());
        });
        pointsCol.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getPoints());
        });
        dateCol.setCellValueFactory(c -> {
            return new ReadOnlyObjectWrapper<>(c.getValue().getDate());
        });
    }

    private void initializeListeners() {
        diffBox.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(final ObservableValue<? extends Integer> observable, final Integer oldValue, final Integer newValue) {
                filter();
            }
        });
        courseBox.valueProperty().addListener(new ChangeListener<Course>() {
            @Override
            public void changed(final ObservableValue<? extends Course> observable, final Course oldValue, final Course newValue) {
                filter();
            }
        });
        subjectBox.valueProperty().addListener(new ChangeListener<Subject>() {
            @Override
            public void changed(final ObservableValue<? extends Subject> observable, final Subject oldValue, final Subject newValue) {
                filter();
            }
        });
        quesTypeBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
                filter();
            }
        });
        startDa.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(final ObservableValue<? extends LocalDate> observable, final LocalDate oldValue, final LocalDate newValue) {
                filter();
            }
        });
        endDa.valueProperty().addListener(new ChangeListener<LocalDate>() {
            @Override
            public void changed(final ObservableValue<? extends LocalDate> observable, final LocalDate oldValue, final LocalDate newValue) {
                filter();
            }
        });

    }

    private void initializeDropdowns() {
        courseBox.setValue(test.getCourse());
        courseBox.setDisable(true);

        subjectBox.setItems(FXCollections.observableArrayList(test.getCourse().getSubjects()));

        diffBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        quesTypeBox.setItems(FXCollections.observableArrayList("True/False", "Multiple Choice", "Free-Response", "Coding", "Fill-In-The-Blank"));
    }

    @FXML
    private void filter() {
        ArrayList<Question> allQuestions = new ArrayList<>(QuestionBank.getInstance().getBank());

        String search = searchBar.getText();
        Integer difficulty = diffBox.getValue();
        Course course = courseBox.getValue();
        Subject subject = subjectBox.getValue();
        String quesType = quesTypeBox.getValue();
        LocalDate startDate = startDa.getValue();
        LocalDate endDate = endDa.getValue();
        if (search != null && !search.isEmpty()) {
            allQuestions = filterBySearch(allQuestions, search);
        }
        if (difficulty != null) {
            allQuestions = filterByDifficulty(allQuestions, difficulty);
        }
        if (course != null) {
            allQuestions = filterByCourse(allQuestions, course);
        }
        if (subject != null) {
            allQuestions = filterBySubject(allQuestions, subject);
        }
        if (quesType != null) {
            allQuestions = filterbyQuesType(allQuestions, quesType);
        }
        if (startDate != null || endDate != null) {
            allQuestions = filterByDate(allQuestions, startDate, endDate);
        }

        setQuestions(allQuestions);
    }

    private ArrayList<Question> filterBySearch(ArrayList<Question> input, String search) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Question> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (input.get(i).getQuestion().toLowerCase().contains(search.toLowerCase())) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<Question> filterByDifficulty(ArrayList<Question> input, Integer difficulty) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Question> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (difficulty.equals(input.get(i).getDifficulty())) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<Question> filterByCourse(ArrayList<Question> input, Course course) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Question> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (course.equals(input.get(i).getCourse())) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<Question> filterBySubject(ArrayList<Question> input, Subject subject) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Question> filtered = new ArrayList<>();

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (subject.equals(input.get(i).getSubject())) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<Question> filterbyQuesType(ArrayList<Question> input, String quesType) {
        /* ArrayList that will eventually hold final filtered objects */
        ArrayList<Question> filtered = new ArrayList<>();

        Class questionClass = null;
        switch (quesType) {
            case "True/False":
                questionClass = TrueFalse.class;
                break;
            case "Multiple Choice":
                questionClass = MultipleChoice.class;
                break;
            case "Free-Response":
                questionClass = FreeResponse.class;
                break;
            case "Coding":
                questionClass = Coding.class;
                break;
            case "Fill-In-The-Blank":
                questionClass = FillInTheBlank.class;
        }

        /* Loops through the passed in array */
        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (questionClass == input.get(i).getClass()) {
                filtered.add(input.get(i));
            }
        }
        return filtered;
    }

    private ArrayList<Question> filterByDate(ArrayList<Question> input, LocalDate start, LocalDate end) {
        ArrayList<Question> filtered = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            /* if the question matches the criteria, add it to the arraylist */
            if (start != null) {
                if (end != null) {
                    if (input.get(i).getDate().compareTo(start) >= 0 && input.get(i).getDate().compareTo(end) <= 0) {
                        filtered.add(input.get(i));
                    }
                } else {
                    if (input.get(i).getDate().compareTo(start) >= 0) {
                        filtered.add(input.get(i));
                    }
                }

            } else if (end != null) {
                if (input.get(i).getDate().compareTo(end) <= 0) {
                    filtered.add(input.get(i));
                }
            }
        }
        return filtered;
    }

    @FXML
    private void handleSelect() {
        Question question = quesTable.getSelectionModel().getSelectedItem();
        if (question != null) {
            ArrayList<Question> curQuestions = test.getQuestions();
            Question newQuestion = null;
            if (question instanceof Coding) {
                newQuestion = new Coding();
                Coding quest = (Coding) newQuestion;
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setCreator(question.getCreator());
                quest.setScore(new QuestionScore());
                quest.setAnswer(((Coding) question).getAnswer());
                quest.setFlags(((Coding) question).getFlags());

            } else if (question instanceof FillInTheBlank) {
                newQuestion = new FillInTheBlank();
                FillInTheBlank quest = (FillInTheBlank) newQuestion;
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setCreator(question.getCreator());
                quest.setScore(new QuestionScore());
                quest.setAnswer(((FillInTheBlank) question).getAnswer());

            } else if (question instanceof FreeResponse) {
                newQuestion = new FreeResponse();
                FreeResponse quest = (FreeResponse) newQuestion;
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setCreator(question.getCreator());
                quest.setScore(new QuestionScore());
                quest.setAnswer(((FreeResponse) question).getAnswer());
                quest.setFlags(((FreeResponse) question).getFlags());

            } else if (question instanceof MultipleChoice) {
                newQuestion = new MultipleChoice();
                MultipleChoice quest = (MultipleChoice) newQuestion;
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setCreator(question.getCreator());
                quest.setScore(new QuestionScore());
                quest.setAnswer(((MultipleChoice) question).getAnswer());
                quest.setOption(((MultipleChoice) question).getOptions());

            } else if (question instanceof TrueFalse) {
                newQuestion = new TrueFalse();
                TrueFalse quest = (TrueFalse) newQuestion;
                quest.setType(question.getType());
                quest.setQuestion(question.getQuestion());
                quest.setPoints(question.getPoints());
                quest.setSubject(question.getSubject());
                quest.setCourse(question.getCourse());
                quest.setDifficulty(question.getDifficulty());
                quest.setDate(question.getDate());
                quest.setScore(new QuestionScore());
                quest.setCreator(question.getCreator());
                quest.setAnswer(((TrueFalse) question).getAnswer());
            } else {
                throw new RuntimeException("Not a valid class");
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Selection");
            alert.setHeaderText("Add a Question");
            alert.setContentText("Are you sure you wish to add the question?\n" + newQuestion.getQuestion());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                curQuestions.add(newQuestion);
            }
        }
    }
    @FXML
    public void handleBack() throws Exception {
        // Go back to the Test
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("View/TestCreation/testEdit.fxml"));
        loader.setControllerFactory((cf) -> {
            return new TestEditController(test, mainApp);
        });
        AnchorPane curPane = loader.load();
        mainApp.rootLayout.setCenter(curPane);
        mainApp.primaryStage.show();
    }

    @FXML
    public void clearStart() {
        startDa.setValue(null);
    }

    @FXML
    public void clearEnd() {
        endDa.setValue(null);
    }

    @FXML
    public void clearAll() {
        searchBar.clear();
        diffBox.getSelectionModel().clearSelection();
        courseBox.getSelectionModel().clearSelection();
        subjectBox.getSelectionModel().clearSelection();
        quesTypeBox.getSelectionModel().clearSelection();
        clearStart();
        clearEnd();
    }
}
