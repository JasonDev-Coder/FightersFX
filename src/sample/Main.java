package sample;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("FXMLfiles/MainMenu.fxml"));
			Scene scene= new Scene(root,1500,750);
			Music.generateMusic("src/sample/Sounds/Menu/TekkenIntro.mp3");
			MainMenuController.stage=primaryStage;
			ChooseCharacterController.stage=primaryStage;
			ControlsController.stage=primaryStage;
			ChooseArenaController.stage=primaryStage;
			ArenaController.stage=primaryStage;
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
