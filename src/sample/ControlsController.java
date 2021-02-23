package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlsController {
    static Scene scene;
    static Stage stage;

    //@FXML
    //ImageView back;

    @FXML
    Button back_btn;

    @FXML
    public void backHome(){
        try {
            final FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "FXMLfiles/MainMenu.fxml"
                    )
            );
            Parent root = loader.load();
            Scene scene = new Scene(root, 1500, 750);
            Music.musicPlayer.stop();
            stage.setScene(scene);
            Music.generateMusic("src/Sample/Sounds/Menu/TekkenIntro.mp3");
            MainMenuController.scene = scene;
            MainMenuController.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
