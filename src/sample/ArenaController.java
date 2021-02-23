package sample;


import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Factories.AkumaFactory;
import sample.Factories.ChunliFactory;
import sample.Factories.KenFactory;
import sample.Factories.RyuFactory;
import sample.Fighters.*;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class ArenaController {

    static Scene scene;
    static Stage stage;
    Fighter fighter1, fighter2;
    @FXML
    ImageView p1, p2, fightImg,arena;
    @FXML
    Rectangle healthP1;
    @FXML
    Rectangle healthP2;
    @FXML
    Label game_over_label;
    @FXML
    Button restart,mainmenu;
    boolean isOver=false;

    @FXML
    public void GameStart(String p1Name, String p2Name, Image arenaBg) {
        mainmenu.setVisible(false);
        mainmenu.setDisable(true);
        restart.setVisible(false);
        restart.setDisable(true);
        arena.setImage(arenaBg);
        if (p1Name.equalsIgnoreCase("Ken"))
            fighter1 = new KenFactory().getFighter(p1, true);
        else if (p1Name.equalsIgnoreCase("Akuma"))
            fighter1 = new AkumaFactory().getFighter(p1, true);
        else if (p1Name.equalsIgnoreCase("Ryu"))
            fighter1 = new RyuFactory().getFighter(p1,true);
        else if (p1Name.equalsIgnoreCase("Chun li"))
            fighter1 = new ChunliFactory().getFighter(p1,true);

        if (p2Name.equalsIgnoreCase("Ken"))
            fighter2 = new KenFactory().getFighter(p2, false);
        else if (p2Name.equalsIgnoreCase("Akuma"))
            fighter2 = new AkumaFactory().getFighter(p2, false);
        else if (p2Name.equalsIgnoreCase("Ryu"))
            fighter2 = new RyuFactory().getFighter(p2, false);
        else if (p2Name.equalsIgnoreCase("Chun li"))
            fighter2 = new ChunliFactory().getFighter(p2, false);

        healthP1.setWidth(fighter1.getHealth());
        healthP2.setWidth(fighter2.getHealth());
        healthP1.setHeight(50);
        healthP2.setHeight(50);
        healthP2.setX(1050);
        healthP2.setRotate(360);
        Music.generateSound("src/sample/Sounds/Fighting/FightMKannounc.mp3");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                fightImg.setVisible(false);
                Music.generateMusic("src/sample/Sounds/Fighting/Mishima Dojo.mp3");
                putCharacters();

            }
        }, 2000);
    }

    private void putCharacters() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(isOver){
                    return;
                }
                if (keyP1(keyEvent.getCode())) {
                    fighter1.handleInput(fighter2, keyEvent);
                    fighter2.handleDamage(fighter1, keyEvent);
                }
                if (keyP2(keyEvent.getCode())) {
                    fighter2.handleInput(fighter1, keyEvent);
                    fighter1.handleDamage(fighter2, keyEvent);
                }

                healthP1.setWidth(fighter1.getHealth());
                double healthplayer2 = fighter2.getHealth();
                if (healthplayer2 != healthP2.getWidth()) {
                    if (keyEvent.getCode() == KeyCode.S) {
                        healthP2.setX(healthP2.getX() + fighter1.getKickDamage());
                        healthP2.setWidth(fighter2.getHealth());
                    } else {
                        healthP2.setX(healthP2.getX() + fighter1.getPunchDamage());
                        healthP2.setWidth(fighter2.getHealth());
                    }
                }
                if (healthP1.getWidth() <= 0) {
                    fighter1.handleDamage(fighter2, keyEvent);
                    GameOver(fighter2.getName());
                    isOver=true;
                } else if (healthP2.getWidth() <= 0) {
                    fighter2.handleDamage(fighter1, keyEvent);
                    GameOver(fighter1.getName());
                    isOver=true;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (healthP1.getWidth() <= 0) {
                    fighter1.handleDamage(fighter2, keyEvent);
                    if(!isOver)
                        GameOver(fighter2.getName());
                    isOver=true;
                    return;
                } else if (healthP2.getWidth() <= 0) {
                    fighter2.handleDamage(fighter1, keyEvent);
                    if(!isOver)
                        GameOver(fighter1.getName());
                    isOver=true;
                    return;
                }
                if (keyP1(keyEvent.getCode())) {
                    fighter1.handleInput(fighter2, keyEvent);
                    fighter2.handleDamage(fighter1, keyEvent);
                }
                if (keyP2(keyEvent.getCode())) {
                    fighter1.handleDamage(fighter2, keyEvent);
                    fighter2.handleInput(fighter1, keyEvent);
                }
            }
        });
    }

    private boolean keyP1(KeyCode k) {
        return k == KeyCode.Q || k == KeyCode.S || k == KeyCode.A || k == KeyCode.D || k == KeyCode.W;
    }

    private boolean keyP2(KeyCode k) {
        return k == KeyCode.CONTROL || k == KeyCode.K || k == KeyCode.J || k == KeyCode.L || k == KeyCode.I;
    }

    private void GameOver(String Name) {
        Music.musicPlayer.stop();
        game_over_label.setText(Name + " Wins");
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Music.generateSound("src/sample/Sounds/Fighting/You Win.mp3");
            }
        },1500);
        Timer timer1=new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                mainmenu.setVisible(true);
                mainmenu.setDisable(false);
                restart.setVisible(true);
                restart.setDisable(false);
            }
        },4000);
    }
    @FXML
    public void mainMenu(){
        try {
            final FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "FXMLfiles/MainMenu.fxml"
                    )
            );
            Parent root = loader.load();
            Scene scene = new Scene(root, 1500, 750);
            stage.setScene(scene);
            Music.musicPlayer.stop();
            Music.soundsPLayer.stop();
            Music.generateMusic("src/sample/Sounds/Menu/TekkenIntro.mp3");
            MainMenuController.scene = scene;
            MainMenuController.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    public void restart(){
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
            Music.musicPlayer.stop();
            Music.soundsPLayer.stop();
            ArenaController controller = loader.getController();
            controller.GameStart(fighter1.getName(),fighter2.getName(),arena.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
