package sample;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {
    static Stage stage;
    static Scene scene;
    @FXML
    Button start_game, controls;

    @FXML
    void startGame() {
        try {
            final FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "FXMLfiles/ChooseCharacter.fxml"
                    )
            );
            Parent root = loader.load();
            Scene scene = new Scene(root, 1500, 750);
            Music.musicPlayer.stop();
            stage.setScene(scene);
            Music.generateSound("src/sample/Sounds/Menu/Choose Your Fighter.mp3");
            ChooseCharacterController.scene = scene;
            ChooseCharacterController.scene.getStylesheets().add(getClass().getResource("chooseCharacters.css").toExternalForm());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    public void controls(){
        try {
            final FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "FXMLfiles/Controls.fxml"
                    )
            );
            Parent root = loader.load();
            Scene scene = new Scene(root, 1500, 750);
            Music.musicPlayer.stop();
            stage.setScene(scene);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    public void quit(){
        stage.close();
    }

}
