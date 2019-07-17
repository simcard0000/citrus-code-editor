package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.web.HTMLEditor;

public class EditingScreenController {
	
	@FXML
	private HTMLEditor codeInput;
	@FXML
	private HTMLEditor journalInput;
	
	@FXML
	private void getOnSelectionChanged(Event e) {
		String codeContents = codeInput.getHtmlText();
		System.out.println(codeContents);
		journalInput.setHtmlText(codeContents);
	}

}


