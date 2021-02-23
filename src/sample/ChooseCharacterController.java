package sample;

import com.sun.prism.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Fighters.Fighter;
import sample.Fighters.Ken;

import java.io.File;
import java.io.IOException;


public class ChooseCharacterController {
    static Scene scene;
    static Stage stage;
    @FXML
    ImageView FighterP1,FighterP2;

    @FXML
    Button kenPlayer, akumaPlayer,ryuPlayer,chunliPlayer, confirmP1, confirmP2;

    @FXML
    Text p1CharName, p2CharName;



    Boolean p1Picked = false, p2Picked = false;

    @FXML
    public void kenPlayer() {
        if (p1Picked) {
            Image p2Image = new Image(new File("src/sample/Characters/Ken/KenSelection/KenP2.gif").toURI().toString());
            FighterP2.setImage(p2Image);
            System.out.println(FighterP2.getId());
            p2CharName.setText("KEN");
        } else {
            Image p1Image = new Image(new File("src/sample/Characters/Ken/KenSelection/KenP1.gif").toURI().toString());
            FighterP1.setImage(p1Image);
            p1CharName.setText("KEN");
        }
    }

    @FXML
    public void akumaPlayer() {
        if (p1Picked) {
            Image p2Image = new Image(new File("src/sample/Characters/Akuma/AkumaSelection/AkumaP2.gif").toURI().toString());
            FighterP2.setImage(p2Image);
            p2CharName.setText("AKUMA");
        } else {
            Image p1Image = new Image(new File("src/sample/Characters/Akuma/AkumaSelection/AkumaP1.gif").toURI().toString());
            FighterP1.setImage(p1Image);
            p1CharName.setText("AKUMA");
        }
    }

    @FXML
    public void ryuPlayer(){
        if (p1Picked) {
            Image p2Image = new Image(new File("src/sample/Characters/Ryu/RyuSelection/RyuP2.gif").toURI().toString());
            FighterP2.setImage(p2Image);
            p2CharName.setText("RYU");
        } else {
            Image p1Image = new Image(new File("src/sample/Characters/Ryu/RyuSelection/RyuP1.gif").toURI().toString());
            FighterP1.setImage(p1Image);
            p1CharName.setText("RYU");
        }
    }

    @FXML
    public void chunliPlayer(){
        if (p1Picked) {
            Image p2Image = new Image(new File("src/sample/Characters/ChunLi/ChunliSelection/ChunliP2.gif").toURI().toString());
            FighterP2.setImage(p2Image);
            p2CharName.setText("CHUN LI");
        } else {
            Image p1Image = new Image(new File("src/sample/Characters/ChunLi/ChunliSelection/ChunliP1.gif").toURI().toString());
            FighterP1.setImage(p1Image);
            p1CharName.setText("CHUN LI");
        }
    }


    @FXML
    public void confirmP1() {
        p1Picked = true;
        switch (p1CharName.getText()) {
            case "KEN":
                kenPlayer.setDisable(true);
                break;
            case "AKUMA":
                akumaPlayer.setDisable(true);
                break;
            case "RYU":
                ryuPlayer.setDisable(true);
                break;
            case "CHUN LI":
                chunliPlayer.setDisable(true);
                break;
            default:
                p1Picked = false;
        }
        StartGame();
    }

    @FXML
    public void confirmP2() {
        p2Picked = true;
        switch (p2CharName.getText()) {
            case "KEN":
                kenPlayer.setDisable(true);
                break;
            case "AKUMA":
                akumaPlayer.setDisable(true);
                break;
            case "RYU":
                ryuPlayer.setDisable(true);
                break;
            case "CHUN LI":
                chunliPlayer.setDisable(true);
                break;
            default: p2Picked=false;
        }
        StartGame();
    }

    public void StartGame() {
        if (p1Picked && p2Picked) {
            try {
                final FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "FXMLfiles/ChooseArena.fxml"
                        )
                );
                Parent root = loader.load();
                Scene scene = new Scene(root, 1500, 750);
                stage.setScene(scene);
                ChooseArenaController.scene = scene;
                ChooseArenaController.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                ChooseArenaController controller = loader.getController();
                controller.saveCharacters(p1CharName.getText(), p2CharName.getText());
                controller.loadArenas();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void back(){
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


