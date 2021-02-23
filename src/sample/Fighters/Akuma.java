package sample.Fighters;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.util.Duration;

import javax.swing.text.ChangedCharSetException;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Akuma extends Fighter {
    public Akuma(ImageView imageView) {
        super(imageView);
        setName("Akuma");
        double health = 450;
        double punch = 35;
        double kick = 40;

        String gifsPath = "sample\\Characters\\Akuma\\AkumaAnimations\\";
        Image StanceL = new Image(gifsPath + "AkumaStanceL.gif");
        Image StanceR = new Image(gifsPath + "AkumaStanceR.gif");
        Image ForwardL = new Image(gifsPath + "AkumaForwardL.gif");
        Image ForwardR = new Image(gifsPath + "AkumaForwardR.gif");
        Image BackwardL = new Image(gifsPath + "AkumaBackwardL.gif");
        Image BackwardR = new Image(gifsPath + "AkumaBackwardR.gif");
        Image PunchL = new Image(gifsPath + "AkumaPunchL.gif");
        Image PunchR = new Image(gifsPath + "AkumaPunchR.gif");
        Image JumpL = new Image(gifsPath + "AkumaJumpL.gif");
        Image JumpR = new Image(gifsPath + "AkumaJumpR.gif");

        ArrayList<Image> framesJumpL = new ArrayList<>();
        ArrayList<Image> framesJumpR = new ArrayList<>();
        ArrayList<Image> framesKickL = new ArrayList<>();
        ArrayList<Image> framesKickR = new ArrayList<>();
        ArrayList<Image> framesKoL = new ArrayList<>();
        ArrayList<Image> framesKoR = new ArrayList<>();
        ArrayList<Image> framesPunchL = new ArrayList<>();
        ArrayList<Image> framesPunchR = new ArrayList<>();
        ArrayList<Image> framesWakeUpL = new ArrayList<>();
        ArrayList<Image> framesWakeUpR = new ArrayList<>();
        ArrayList<Image> framesWinL = new ArrayList<>();
        ArrayList<Image> framesWinR = new ArrayList<>();

        ArrayList<Image>[] arrayLists = new ArrayList[12];
        arrayLists[0] = framesJumpL;
        arrayLists[1] = framesJumpR;
        arrayLists[2] = framesKickL;
        arrayLists[3] = framesKickR;
        arrayLists[4] = framesKoL;
        arrayLists[5] = framesKoR;
        arrayLists[6] = framesPunchL;
        arrayLists[7] = framesPunchR;
        arrayLists[8] = framesWakeUpL;
        arrayLists[9] = framesWakeUpR;
        arrayLists[10] = framesWinL;
        arrayLists[11] = framesWinR;
        File folders = new File("src/sample/Characters/Akuma/AkumaFrames");
        for (int i = 0; i < folders.listFiles().length; i++) {
            listFilesForFolder(folders.listFiles()[i], arrayLists[i]);
        }

        super.setFighterFrames(StanceL, StanceR, ForwardL, ForwardR, BackwardL, BackwardR, PunchL, PunchR, JumpL, JumpR, framesJumpL, framesJumpR, framesPunchL, framesPunchR, framesKickL, framesKickR, framesKoL, framesKoR, framesWinL, framesWinR,framesWakeUpL,framesWakeUpR);
        this.setCharacterStats(health, 1260, 840, 900, 1600, 1800, punch, kick,1440);
        Media punchAudio=new Media(new File("src/sample/Characters/Akuma/AkumaSounds/AkumaPunchSound.mp3").toURI().toString());
        setPunchAudio(new AudioClip(punchAudio.getSource()));
        Media KickAudio=new Media(new File("src/sample/Characters/Akuma/AkumaSounds/AkumaKickSound.mp3").toURI().toString());
        setKickAudio(new AudioClip(KickAudio.getSource()));
        Media KoAudio=new Media(new File("src/sample/Characters/Akuma/AkumaSounds/AkumaKoSound.mp3").toURI().toString());
        setKOAudio(new AudioClip(KoAudio.getSource()));
        Media JumpAudio=new Media(new File("src/sample/Characters/Akuma/AkumaSounds/AkumaJumpSound.mp3").toURI().toString());
        setJumpAudio(new AudioClip(JumpAudio.getSource()));
    }

    @Override
    public void makeJump(ArrayList<Image> ims, double duration, Image stance) {
        TranslateTransition t=new TranslateTransition(Duration.millis(getJumpingDur()),getCurrentPosition());
        if (isL())
            t.setByX(400);
        else t.setByX(-400);
        t.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!isL()) {
                    getCurrentPosition().setTranslateX(getCurrentPosition().getTranslateX() + 400);//so image doesnt hange its translation
                    double pos=getCurrentPosition().getX()-400;
                    getCurrentPosition().setX(Math.max(100,pos));
                    getCurrentPosition().setImage(getStanceR());
                }else{
                    getCurrentPosition().setTranslateX(getCurrentPosition().getTranslateX() - 400);
                    double pos=getCurrentPosition().getX()+400;
                    getCurrentPosition().setX(Math.min(1200,pos));
                    getCurrentPosition().setImage(getStanceL());
                }
            }
        });
        t.play();
        if (isL()) {
            makeTransition(getFramesJumpL(), getJumpingDur(),stance);
        } else
            makeTransition(getFramesJumpR(), getJumpingDur(), stance);
    }
}
