package TestTool.View.QuestionManagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ErrorHandler {
	@FXML 
	Button okayButton;
	
	private Stage dialogStage;
	
	public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	
	@FXML
	private void handleOkayClicked() {
		dialogStage.close();
	}
	
}
