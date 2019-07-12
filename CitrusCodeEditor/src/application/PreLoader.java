package application;

import java.io.IOException;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;

public class PreLoader extends Preloader {

	ProgressBar barLoading;
	Stage initStage;
	
	private Scene createLoader() throws IOException{
		
		Parent initRoot = FXMLLoader.load(getClass().getResource("LoadingScreen.fxml"));
		Scene loadScene = new Scene(initRoot);
		return loadScene;
		
	}
	
	public void start(Stage initStage) throws Exception{
		this.initStage = initStage;
		initStage.setScene(createLoader());
		initStage.centerOnScreen();
		initStage.isAlwaysOnTop();
		initStage.initStyle(StageStyle.UNDECORATED);
		initStage.show();
	}
	
	@Override
	public void handleStateChangeNotification(StateChangeNotification event) {
		if (event.getType() == StateChangeNotification.Type.BEFORE_LOAD) {
			initStage.hide();
		}
	}

}
