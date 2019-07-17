package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
		Scene theScene = new Scene(root);
		primaryStage.setTitle("Citrus Code Editor");
		Image icon = new Image(getClass().getResourceAsStream("citrus icon.png"));
		primaryStage.getIcons().add(icon);
		primaryStage.setScene(theScene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		System.setProperty("javafx.preloader", "application.PreLoader");
		launch(args);
	}
}

