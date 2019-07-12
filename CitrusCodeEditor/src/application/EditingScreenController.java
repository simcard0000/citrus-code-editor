package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class EditingScreenController {
	
	@FXML
	private void handleNewLineOfWritingCode(ActionEvent ae) {
		TextArea subArea = (TextArea) ae.getSource();
		String subAreaContents = subArea.getText();
		subAreaContents.split("\\s+");
	}

}
