package sample.Fighters;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.util.Duration;
import sample.States.FighterState;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Ken extends Fighter {
    public Ken(ImageView imageView) {
        super(imageView);
        setName("Ken");
        double health = 450;
        double punch = 35;
        double kick = 40;
        String gifsPath = "sample\\Characters\\Ken\\KenAnimations\\";
        Image StanceL = new Image(gifsPath + "KenStanceL.gif");
        Image StanceR = new Image(gifsPath + "KenStanceR.gif");
        Image ForwardL = new Image(gifsPath + "KenForwardL.gif");
        Image ForwardR = new Image(gifsPath + "KenForwardR.gif");
        Image BackwardL = new Image(gifsPath + "KenBackwardL.gif");
        Image BackwardR = new Image(gifsPath + "KenBackwardR.gif");
        Image PunchL = new Image(gifsPath + "KenPunchL.gif");
        Image PunchR = new Image(gifsPath + "KenPunchR.gif");
        Image JumpL = new Image(gifsPath + "KenJumpL.gif");
        Image JumpR = new Image(gifsPath + "KenJumpR.gif");

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
        File folders = new File("src/sample/Characters/Ken/KenFrames");
        for (int i = 0; i < folders.listFiles().length; i++) {
            listFilesForFolder(folders.listFiles()[i], arrayLists[i]);
        }
        super.setFighterFrames(StanceL, StanceR, ForwardL, ForwardR, BackwardL, BackwardR, PunchL, PunchR, JumpL, JumpR, framesJumpL, framesJumpR, framesPunchL, framesPunchR, framesKickL, framesKickR, framesKoL, framesKoR, framesWinL, framesWinR,framesWakeUpL,framesWakeUpR);
        this.setCharacterStats(health, 1260, 630, 1920, 2060, 1570, punch, kick,1400);
        Media punchAudio=new Media(new File("src/sample/Characters/Ken/KenSounds/KenPunchSound.mp3").toURI().toString());
        setPunchAudio(new AudioClip(punchAudio.getSource()));
        Media KickAudio=new Media(new File("src/sample/Characters/Ken/KenSounds/KenKickSound.mp3").toURI().toString());
        setKickAudio(new AudioClip(KickAudio.getSource()));
        Media KoAudio=new Media(new File("src/sample/Characters/Ken/KenSounds/KenKoSound.mp3").toURI().toString());
        setKOAudio(new AudioClip(KoAudio.getSource()));
        Media JumpAudio=new Media(new File("src/sample/Characters/Ken/KenSounds/KenJumpSound.mp3").toURI().toString());
        setJumpAudio(new AudioClip(JumpAudio.getSource()));
    }

}
