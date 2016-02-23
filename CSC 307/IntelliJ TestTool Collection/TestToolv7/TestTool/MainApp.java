package TestTool;

import TestTool.Model.QuestionBank.QuestionBank;
import TestTool.Model.QuestionCreation.Question;
import TestTool.Model.Resource.Course;
import TestTool.Model.Resource.CourseCollection;
import TestTool.Model.Resource.Subject;
import TestTool.Model.Resource.SubjectCollection;
import TestTool.Model.TestBank.ActiveTestBank;
import TestTool.Model.TestBank.StudentTestBank;
import TestTool.Model.TestBank.TestBank;
import TestTool.Model.TestCreation.ActiveTest;
import TestTool.Model.TestCreation.StudentTest;
import TestTool.Model.TestCreation.Test;
import TestTool.View.AdministrativeDetails.LoginController;
import TestTool.View.Resource.*;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.event.EventHandler;
import org.omg.PortableInterceptor.ACTIVE;

public class MainApp extends Application {
	
    public Stage primaryStage;
    public BorderPane rootLayout;

    /**
     * Constructor
     */
    public MainApp() {
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("TestTool");

        initRootLayout();
        initBanks();
		showLogin();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Stage is closing");
                saveBanks();
            }
        });
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
    	try {
    		// Load root layout from fxml file
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("View/Resource/TestMakerMenu.fxml"));
    		rootLayout = (BorderPane) loader.load();
    		
    		// Show the scene containing the root layout
    		Scene scene = new Scene(rootLayout);
    		primaryStage.setScene(scene);
    		primaryStage.show();
    		
    		MenuTabController controller = loader.getController();
    		controller.setMainApp(this);
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }



	/**
	 * Shows the initial login screen inside the root layout
	 */
	public void showLogin() {
		try {
			// Load login screen
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/login.fxml"));
			AnchorPane welcomeScreen = (AnchorPane) loader.load();
			LoginController controller = loader.getController();
			controller.setMainApp(this);
			this.rootLayout.getTop().setVisible(false);
			this.rootLayout.setCenter(welcomeScreen);

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

	private void initBanks(){
		ArrayList<Question> questionBank;
        ArrayList<Test> testBank;
        ArrayList<ActiveTest> activeTestBank;
        HashMap<String, ArrayList<StudentTest>> studentTestBank;
        HashMap<String, Course> courses;
        HashMap<String, Subject> subjects;
		try
		{
			FileInputStream fis = new FileInputStream("TestTool/Resources/questionBank.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			questionBank = (ArrayList) ois.readObject();
			ois.close();
			fis.close();
			QuestionBank.getInstance().setBank(questionBank);

            fis = new FileInputStream("TestTool/Resources/testBank.txt");
            ois = new ObjectInputStream(fis);
            testBank = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            TestBank.getInstance().setBank(testBank);

            fis = new FileInputStream("TestTool/Resources/activeTestBank.txt");
            ois = new ObjectInputStream(fis);
            activeTestBank = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            ActiveTestBank.getInstance().setBank(activeTestBank);

            fis = new FileInputStream("TestTool/Resources/studentTestBank.txt");
            ois = new ObjectInputStream(fis);
            studentTestBank = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            StudentTestBank.getInstance().setBank(studentTestBank);

            fis = new FileInputStream("TestTool/Resources/courseCollection.txt");
            ois = new ObjectInputStream(fis);
            courses = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            CourseCollection.getInstance().setCourses(courses);

            fis = new FileInputStream("TestTool/Resources/subjectCollection.txt");
            ois = new ObjectInputStream(fis);
            subjects = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            SubjectCollection.getInstance().setSubjects(subjects);

		}catch(IOException ioe){
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
			return;
		}
	}

    private void saveBanks(){
        ArrayList<Question> questionBank = QuestionBank.getInstance().getBank();
        ArrayList<Test> testBank = TestBank.getInstance().getBank();
        ArrayList<ActiveTest> activeTestBank = ActiveTestBank.getInstance().getBank();
        HashMap<String, ArrayList<StudentTest>> studentTestBank = StudentTestBank.getInstance().getBank();
        HashMap<String, Course> courses = CourseCollection.getInstance().getCourse();
        HashMap<String, Subject> subjects = SubjectCollection.getInstance().getSubjects();

        /*try{
            FileOutputStream fos= new FileOutputStream("TestTool/Resources/questionBank.txt");
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(questionBank);
            oos.close();
            fos.close();


            fos= new FileOutputStream("TestTool/Resources/testBank.txt");
            oos= new ObjectOutputStream(fos);
            oos.writeObject(testBank);
            oos.close();
            fos.close();

            fos= new FileOutputStream("TestTool/Resources/activeTestBank.txt");
            oos= new ObjectOutputStream(fos);
            oos.writeObject(activeTestBank);
            oos.close();
            fos.close();

            fos= new FileOutputStream("TestTool/Resources/studentTestBank.txt");
            oos= new ObjectOutputStream(fos);
            oos.writeObject(studentTestBank);
            oos.close();
            fos.close();

            fos= new FileOutputStream("TestTool/Resources/courseCollection.txt");
            oos= new ObjectOutputStream(fos);
            oos.writeObject(courses);
            oos.close();
            fos.close();

            fos= new FileOutputStream("TestTool/Resources/subjectCollection.txt");
            oos= new ObjectOutputStream(fos);
            oos.writeObject(subjects);
            oos.close();
            fos.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }*/
    }

}
