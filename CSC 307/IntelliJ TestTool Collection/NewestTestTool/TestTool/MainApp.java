package TestTool;

import TestTool.View.Resource.*;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

		showLogin();
        //showWelcomeScreen();
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
     * Shows the initial welcome screen inside the root layout
     */
    public void showWelcomeScreen() {
    	try {
    		// Load welcome screen
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("View/Resource/WelcomeScreen.fxml"));
    		AnchorPane welcomeScreen = (AnchorPane) loader.load();
    		
    		// Set welcome screen into center of root layout
    		rootLayout.setCenter(welcomeScreen);
    		
    	}
    	catch (IOException e) {
    		e.printStackTrace();
    	}
    }


	/**
	 * Shows the initial welcome screen inside the root layout
	 */
	public void showLogin() {
		try {
			// Load welcome screen
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/AdministrativeDetails/login.fxml"));
			AnchorPane welcomeScreen = (AnchorPane) loader.load();

			// Set welcome screen into center of root layout
			rootLayout.setCenter(welcomeScreen);

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


    /**
     * Shows the initial welcome screen inside the root layout
     */
    public void showTestScreen() {
    	try {
    		// Load welcome screen
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(MainApp.class.getResource("View/Resource/TestScreen.fxml"));
    		AnchorPane testScreen = (AnchorPane) loader.load();
    		
    		// Set welcome screen into center of root layout
    		rootLayout.setCenter(testScreen);
    		
    		
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
}
