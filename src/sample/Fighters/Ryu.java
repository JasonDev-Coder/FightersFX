package sample.Fighters;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

public class Ryu extends Fighter{

    public Ryu(ImageView im) {
        super(im);
        setName("Ryu");
        double health = 450;
        double punch = 35;
        double kick = 40;

        String gifsPath = "sample\\Characters\\Ryu\\RyuAnimations\\";
        Image StanceL = new Image(gifsPath + "RyuStanceL.gif");
        Image StanceR = new Image(gifsPath + "RyuStanceR.gif");
        Image ForwardL = new Image(gifsPath + "RyuForwardL.gif");
        Image ForwardR = new Image(gifsPath + "RyuForwardR.gif");
        Image BackwardL = new Image(gifsPath + "RyuBackwardL.gif");
        Image BackwardR = new Image(gifsPath + "RyuBackwardR.gif");
        Image PunchL = new Image(gifsPath + "RyuPunchL.gif");
        Image PunchR = new Image(gifsPath + "RyuPunchR.gif");
        Image JumpL = new Image(gifsPath + "RyuJumpL.gif");
        Image JumpR = new Image(gifsPath + "RyuJumpR.gif");

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
        File folders = new File("src/sample/Characters/Ryu/RyuFrames");
        for (int i = 0; i < folders.listFiles().length; i++) {
            listFilesForFolder(folders.listFiles()[i], arrayLists[i]);
        }

        super.setFighterFrames(StanceL, StanceR, ForwardL, ForwardR, BackwardL, BackwardR, PunchL, PunchR, JumpL, JumpR, framesJumpL, framesJumpR, framesPunchL, framesPunchR, framesKickL, framesKickR, framesKoL, framesKoR, framesWinL, framesWinR,framesWakeUpL,framesWakeUpR);
        this.setCharacterStats(health, 1190, 400, 700, 1940, 1250, punch, kick,1440);

        Media punchAudio=new Media(new File("src/sample/Characters/Ryu/RyuSounds/RyuPunchSound.mp3").toURI().toString());
        setPunchAudio(new AudioClip(punchAudio.getSource()));
        Media KickAudio=new Media(new File("src/sample/Characters/Ryu/RyuSounds/RyuKickSound.mp3").toURI().toString());
        setKickAudio(new AudioClip(KickAudio.getSource()));
        Media KoAudio=new Media(new File("src/sample/Characters/Ryu/RyuSounds/RyuKoSound.mp3").toURI().toString());
        setKOAudio(new AudioClip(KoAudio.getSource()));
        Media JumpAudio=new Media(new File("src/sample/Characters/Ryu/RyuSounds/RyuJumpSound.mp3").toURI().toString());
        setJumpAudio(new AudioClip(JumpAudio.getSource()));
    }
}