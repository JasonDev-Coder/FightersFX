package sample;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseArenaController {
    static Scene scene;
    static Stage stage;
    @FXML
    HBox imagesBox;
    boolean mapChosen = false;
    ArrayList<ImageView> images = new ArrayList<>();
    Image chosenImage = null;
    String fighter1,fighter2;
    public void loadArenas() {
        loadImages();
        imagesBox.setAlignment(Pos.CENTER);
        for (ImageView imageView : images) {
            imageView.setFitWidth(300);
            imageView.setFitHeight(250);
            imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageView.setScaleX(1.2);
                    imageView.setScaleY(1.2);
                }
            });
            imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            });
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    mapChosen = true;
                    chosenImage = imageView.getImage();
                    DropShadow ds = new DropShadow( 40, Color.rgb(233,0,0));
                    ds.setSpread(0.8);
                    for(int i=0;i<images.size();i++)
                        images.get(i).setEffect(null);
                    imageView.setEffect(ds);
                }
            });
            imagesBox.getChildren().add(imageView);
        }
    }
    public void saveCharacters(String p1,String p2){
        this.fighter1=p1;
        this.fighter2=p2;
    }
    @FXML
    public void startGame() {
        if (mapChosen) {
            try {
                final FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "FXMLfiles/Arena.fxml"
                        )
                );
                Parent root = loader.load();
                Scene scene = new Scene(root, 1500, 750);
                stage.setScene(scene);
                ArenaController.scene = scene;
                ArenaController.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                ArenaController controller = loader.getController();
                controller.GameStart(fighter1,fighter2,chosenImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadImages() {
        File arenasFolder = new File("src/sample/Images/Arenas");
        for (File file : arenasFolder.listFiles()) {
            images.add(new ImageView(new Image(file.toURI().toString())));
        }
    }

    @FXML
    public void back(){
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
            Music.generateMusic("src/Sample/Sounds/Menu/TekkenIntro.mp3");
            ChooseCharacterController.scene = scene;
            ChooseCharacterController.scene.getStylesheets().add(getClass().getResource("chooseCharacters.css").toExternalForm());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
