package TestTool.View.Resource;

import java.awt.Event;
import java.io.IOException;

import TestTool.View.AdministrativeDetails.CourseController;
import TestTool.View.AdministrativeDetails.LoginController;
import TestTool.View.AdministrativeDetails.StudentViewController;
import TestTool.View.TestTaking.StudentLoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import TestTool.View.TestCreation.*;
import TestTool.View.QuestionManagement.*;
import TestTool.View.QuestionBank.*;

import TestTool.*;

public class MenuTabController {
	//Reference to menu items
	@FXML
	private MenuItem testCreation;
	@FXML
	private MenuItem testBank;
	@FXML
	private MenuItem questionBank;
	@FXML
	private MenuItem teacherFunctions;
	@FXML
	private MenuItem statistics;

    @FXML
    private MenuItem login;
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MenuTabController() {
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Called when the user clicks on the Test Creation menu item.
     */
    @FXML
    private void handleSelectTestCreation() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/TestCreation/GenTest.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();
            RanTestController ranTest = loader.getController();
            ranTest.setMain(mainApp);


            // Set new screen into center of root layout
            mainApp.rootLayout.setCenter(newScreen);

            mainApp.primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Called when the user clicks on the Test Bank menu item.
     */
    @FXML
    private void handleSelectTestBank() {
    	System.out.println("Inside Select-Test-Bank Handler");
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("View/Resource/TestBank.fxml"));
    		AnchorPane newScreen = (AnchorPane) loader.load();
    		
    		// Set new screen into center of root layout
    		mainApp.rootLayout.setCenter(newScreen);
    		
    		mainApp.primaryStage.show();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    /**
     * Called when the user clicks on the Question Bank menu item.
     */
    @FXML
    private void handleSelectQuestionBank() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/QuestionBank/QuesBank.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();
            QuesBankController quesBank = loader.getController();
            quesBank.setMain(mainApp);

            // Set new screen into center of root layout
            mainApp.rootLayout.setCenter(newScreen);

            mainApp.primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Called when the user clicks on the Teacher Functions menu item.
     */
    @FXML
    private void handleSelectTeacherFunctions() {
    	System.out.println("Inside Select-Teacher-Functions Handler");
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/CourseView.fxml"));
    		AnchorPane newScreen = (AnchorPane) loader.load();

            CourseController handles = loader.getController();
            handles.setMain(mainApp);

            // Set new screen into center of root layout
            mainApp.rootLayout.setCenter(newScreen);

            mainApp.primaryStage.show();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    /**
     * Called when the user clicks on the Statistics menu item.
     */
    @FXML
    private void handleSelectStatistics() {
    	System.out.println("Inside Select-Statistics Handler");
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("View/TestResults/statistics.fxml"));
    		AnchorPane newScreen = (AnchorPane) loader.load();
    		
    		// Set new screen into center of root layout
    		mainApp.rootLayout.setCenter(newScreen);
    		
    		mainApp.primaryStage.show();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    /**
     * Called when the user clicks on the Test Taking menu item.
     */
    @FXML
    private void handleSelectTestTaking() {
    	System.out.println("Inside Select-Test-Taking Handler");
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/TestTaking/TestTakingLogin.fxml"));
			AnchorPane newScreen = (AnchorPane) loader.load();

			// Set new screen into center of root layout
			mainApp.rootLayout.setCenter(newScreen);
			mainApp.primaryStage.show();


			StudentLoginController controller = loader.getController();
			controller.setMenutabController(mainApp);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Called when the user clicks on the Test Grading menu item.
     */
    @FXML
    private void handleSelectTestGrading() {
    	System.out.println("Inside Select-Test-Grading Handler");
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("View/TestGrading/TestGrading.fxml"));
    		AnchorPane newScreen = (AnchorPane) loader.load();
    		
    		// Set new screen into center of root layout
    		mainApp.rootLayout.setCenter(newScreen);
    		
    		mainApp.primaryStage.show();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * Called when the user clicks on the Question Creation menu item.
     */
    @FXML
    private void handleSelectQuestionCreation() {
    	System.out.println("Inside Select-Question-Creation Handler");
    	try {
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("View/QuestionManagement/QuestionEditor.fxml"));
    		AnchorPane newScreen = (AnchorPane) loader.load();
    		QuestionEditorTopController qetcHandler = loader.getController();
			qetcHandler.setMain(mainApp);

    		// Set new screen into center of root layout
    		mainApp.rootLayout.setCenter(newScreen);

    		mainApp.primaryStage.show();
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }

	/**
	 * Called when the user clicks on the Login menu item.
	 */
	@FXML
	private void handleLogin() {
		System.out.println("Login Handler");
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/login.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();
            LoginController handler = loader.getController();

            // Set new screen into center of root layout
            mainApp.rootLayout.setCenter(newScreen);

            mainApp.primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}


    /**
     * Called when the user clicks on the student view menu item.
     */
    @FXML
    private void handleStudentView() {
        System.out.println("Student View Handler");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/studentview.fxml"));
            AnchorPane newScreen = (AnchorPane) loader.load();
            StudentViewController handler = loader.getController();

            // Set new screen into center of root layout
            mainApp.rootLayout.setCenter(newScreen);

            mainApp.primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}

