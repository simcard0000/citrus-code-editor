package application;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;  
import javafx.stage.Stage;  
import javafx.stage.Window;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.web.HTMLEditor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StartScreenController {

	@FXML 
	private Window getOrigin(ActionEvent ae) {
		Node where = (Node) ae.getSource();
		Window what = where.getScene().getWindow();
		return what;
	}
	
	@FXML
	private void handleStartOpen(ActionEvent ae) throws IOException {
		Window win = getOrigin(ae);
		FileChooser openS = new FileChooser();
		openS.setTitle("Open File");
		File toOpen = openS.showOpenDialog(win);
		if (toOpen != null) {
			Parent newRoot = FXMLLoader.load(getClass().getResource("EditingScreen.fxml"));
			Stage newStage = (Stage) win;
			Scene newScene = new Scene(newRoot);
			newStage.setScene(newScene);
		}
	}
	
	@FXML
	private void handleNew(ActionEvent ae) throws IOException {
		Window win = getOrigin(ae);
		TextInputDialog newS = new TextInputDialog();
		newS.setTitle("New File");
		newS.setHeaderText("What's the name of your new file?");
		newS.showAndWait();
		String tempNewName = newS.getResult();
		if (tempNewName == null || tempNewName.length() == 0
				|| tempNewName.charAt(tempNewName.length() - 1) == '.'
				|| tempNewName.charAt(tempNewName.length() - 1) == ' ' || tempNewName.contains(">")
				|| tempNewName.contains("<") || tempNewName.contains(":") || tempNewName.contains("\"")
				|| tempNewName.contains("/") || tempNewName.contains("\\") || tempNewName.contains("|")
				|| tempNewName.contains("?") || tempNewName.contains("*")) {
			Alert badName = new Alert(AlertType.WARNING);
			badName.setTitle("Bad File Name");
			badName.setContentText("Operation failed. Please use valid characters.");
			badName.showAndWait();
		}
		else {
			File tempStore = new File("tempStoreCode.txt");
			Parent newRoot = FXMLLoader.load(getClass().getResource("EditingScreen.fxml"));
			
			//Because the editing HTMLEditor appears first, I don't have
			//to do anything special to get it.
			Node topToolBar = newRoot.lookup(".top-toolbar");
			Node botToolBar = newRoot.lookup(".bottom-toolbar");
			
			topToolBar.setManaged(false);
			topToolBar.setDisable(true);
			topToolBar.setVisible(false);
			botToolBar.setManaged(false);
			botToolBar.setDisable(true);
			botToolBar.setVisible(false);
			Stage newStage = (Stage) win;
			Scene newScene = new Scene(newRoot);
			newStage.setScene(newScene);
		}
	}
	
	@FXML
	private void handleDocumentation(ActionEvent ae) {
		Window win = getOrigin(ae);
	}
	
	@FXML
	private void handleAbout(ActionEvent ae) {
		Window win = getOrigin(ae);
	}
}
