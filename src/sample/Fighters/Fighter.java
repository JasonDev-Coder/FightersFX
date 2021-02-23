package sample.Fighters;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import sample.Music;
import sample.States.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Fighter {

    private double health, jumpingDur, punchDur, kickDur, koDur, wakeUpDur, winDur, punchDamage, kickDamage;
    private Image stanceL, stanceR, forwardL, forwardR, backwardL, backwardR, punchL, punchR, jumpL, jumpR;
    private ArrayList<Image> framesJumpL, framesJumpR, framesPunchL, framesPunchR, framesKickL, framesKickR, framesKOL, framesKOR, framesWinL, framesWinR, framesWakeUpL, framesWakeUpR;
    private FighterState state = new StanceState();
    private FighterState damageState = new DamageState();
    private ImageView currentPosition;
    private Transition t;
    private boolean isL = true;
    private String name;
    private AudioClip punch;
    private AudioClip kick;
    private AudioClip KO;
    private AudioClip jump;


    public Fighter(ImageView im) {
        this.currentPosition = im;
        currentPosition.setScaleX(2.5);
        currentPosition.setScaleY(2.5);
    }


    public boolean isL() {
        return isL;
    }

    public void setL(boolean l) {
        isL = l;
    }

    public FighterState getState() {
        return state;
    }

    public void setState(FighterState state) {
        this.state = state;
    }

    public ImageView getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Image currentPosition) {
        this.currentPosition.setImage(currentPosition);
    }

    public void setFighterFrames(Image stanceL, Image stanceR, Image forwardL, Image forwardR, Image backwardL, Image backwardR, Image punchL, Image punchR, Image jumpL, Image jumpR, ArrayList<Image> framesJumpL, ArrayList<Image> framesJumpR, ArrayList<Image> framesPunchL, ArrayList<Image> framesPunchR, ArrayList<Image> framesKickL, ArrayList<Image> framesKickR, ArrayList<Image> framesKOL, ArrayList<Image> framesKOR, ArrayList<Image> framesWinL, ArrayList<Image> framesWinR, ArrayList<Image> framesWakeUpL, ArrayList<Image> framesWakeUpR) {
        this.stanceL = stanceL;
        this.stanceR = stanceR;
        this.forwardL = forwardL;
        this.forwardR = forwardR;
        this.backwardL = backwardL;
        this.backwardR = backwardR;
        this.punchL = punchL;
        this.punchR = punchR;
        this.jumpL = jumpL;
        this.jumpR = jumpR;
        this.framesJumpL = framesJumpL;
        this.framesJumpR = framesJumpR;
        this.framesPunchL = framesPunchL;
        this.framesPunchR = framesPunchR;
        this.framesKickL = framesKickL;
        this.framesKickR = framesKickR;
        this.framesKOL = framesKOL;
        this.framesKOR = framesKOR;
        this.framesWinL = framesWinL;
        this.framesWinR = framesWinR;
        this.framesWakeUpL = framesWakeUpL;
        this.framesWakeUpR = framesWakeUpR;
    }

    public AudioClip getPunchAudio() {
        return punch;
    }

    public void setPunchAudio(AudioClip punch) {
        this.punch = punch;
    }

    public AudioClip getKickAudio() {
        return kick;
    }

    public void setKickAudio(AudioClip kick) {
        this.kick = kick;
    }

    public AudioClip getKOAudio() {
        return KO;
    }

    public void setKOAudio(AudioClip KO) {
        this.KO = KO;
    }

    public AudioClip getJumpAudio() {
        return jump;
    }

    public void setJumpAudio(AudioClip Jump) {
        this.jump = Jump;
    }

    public void setCharacterStats(double health, double jumpingDur, double punchDur, double kickDur, double koDur, double winDur, double punchDamage, double kickDamage, double wakeUpDur) {
        this.health = health;
        this.jumpingDur = jumpingDur;
        this.punchDur = punchDur;
        this.kickDur = kickDur;
        this.koDur = koDur;
        this.winDur = winDur;
        this.punchDamage = punchDamage;
        this.kickDamage = kickDamage;
        this.wakeUpDur = wakeUpDur;
    }

    public void makeTransition(ArrayList<Image> ims, double duration, Image stance) {
        Transition t = new Transition() {
            {
                setCycleDuration(Duration.millis(duration));
            }

            @Override
            protected void interpolate(double v) { //interpolate is called in each frame while the transition is running
                int index = (int) (v * ims.size() - 1);
                currentPosition.setImage(ims.get(index));
            }
        };
        t.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentPosition.setImage(stance);
                currentPosition.setY(520);
            }
        });
        t.play();
    }

    public void makeJump(ArrayList<Image> ims, double duration, Image stance) {
        TranslateTransition jump = new TranslateTransition(Duration.millis
                (duration-600), currentPosition);
        jump.setByY(-220);
        jump.setAutoReverse(true);
        jump.setCycleCount(2);
        getCurrentPosition().setY(400);
        if (isL) {
            makeTransition(getFramesJumpL(), getJumpingDur()-300, getFramesJumpL().get(getFramesJumpL().size()-6));
        } else
            makeTransition(getFramesJumpR(), getJumpingDur()-300, getFramesJumpR().get(getFramesJumpR().size()-6));

        jump.play();
        jump.setOnFinished(e -> {
            currentPosition.setImage(stance);
            currentPosition.setY(520);
        });
    }


    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getJumpingDur() {
        return jumpingDur;
    }

    public void setJumpingDur(double jumpingDur) {
        this.jumpingDur = jumpingDur;
    }

    public double getWakeUpDur() {
        return wakeUpDur;
    }

    public void setWakeUpDur(double wakeUpDur) {
        this.wakeUpDur = wakeUpDur;
    }

    public void handleInput(Fighter fighter2, KeyEvent code) {
        FighterState currentState = state.handleInput(this, code);
        if (currentState != null) {
            state = currentState;
        }
        state.enter(this, fighter2, code);
    }

    public void handleDamage(Fighter attacker, KeyEvent code) {
        FighterState currentState = damageState.handleInput(this, code);
        if (currentState != null) {
            damageState = currentState;
        }
        damageState.enter(this, attacker, code);
    }

    public FighterState getDamageState() {
        return damageState;
    }

    public void setDamageState(FighterState damageState) {
        this.damageState = damageState;
    }


    public double getPunchDur() {
        return punchDur;
    }

    public void setPunchDur(double punchDur) {
        this.punchDur = punchDur;
    }

    public double getKickDur() {
        return kickDur;
    }

    public void setKickDur(double kickDur) {
        this.kickDur = kickDur;
    }

    public double getKoDur() {
        return koDur;
    }

    public void setKoDur(double koDur) {
        this.koDur = koDur;
    }

    public double getWinDur() {
        return winDur;
    }

    public void setWinDur(double winDur) {
        this.winDur = winDur;
    }

    public double getPunchDamage() {
        return punchDamage;
    }

    public void setPunchDamage(double punchDamage) {
        this.punchDamage = punchDamage;
    }

    public double getKickDamage() {
        return kickDamage;
    }

    public void setKickDamage(double kickDamage) {
        this.kickDamage = kickDamage;
    }

    public Image getStanceL() {
        return stanceL;
    }

    public void setStanceL(Image stanceL) {
        this.stanceL = stanceL;
    }

    public Image getStanceR() {
        return stanceR;
    }

    public void setStanceR(Image stanceR) {
        this.stanceR = stanceR;
    }

    public Image getForwardL() {
        return forwardL;
    }

    public void setForwardL(Image forwardL) {
        this.forwardL = forwardL;
    }

    public Image getForwardR() {
        return forwardR;
    }

    public void setForwardR(Image forwardR) {
        this.forwardR = forwardR;
    }

    public Image getBackwardL() {
        return backwardL;
    }

    public void setBackwardL(Image backwardL) {
        this.backwardL = backwardL;
    }

    public Image getBackwardR() {
        return backwardR;
    }

    public void setBackwardR(Image backwardR) {
        this.backwardR = backwardR;
    }

    public Image getPunchL() {
        return punchL;
    }

    public void setPunchL(Image punchL) {
        this.punchL = punchL;
    }

    public Image getPunchR() {
        return punchR;
    }

    public void setPunchR(Image punchR) {
        this.punchR = punchR;
    }

    public Image getJumpL() {
        return jumpL;
    }

    public void setJumpL(Image jumpL) {
        this.jumpL = jumpL;
    }

    public Image getJumpR() {
        return jumpR;
    }

    public void setJumpR(Image jumpR) {
        this.jumpR = jumpR;
    }

    public ArrayList<Image> getFramesJumpL() {
        return framesJumpL;
    }

    public void setFramesJumpL(ArrayList<Image> framesJumpL) {
        this.framesJumpL = framesJumpL;
    }

    public ArrayList<Image> getFramesJumpR() {
        return framesJumpR;
    }

    public void setFramesJumpR(ArrayList<Image> framesJumpR) {
        this.framesJumpR = framesJumpR;
    }

    public ArrayList<Image> getFramesPunchL() {
        return framesPunchL;
    }

    public void setFramesPunchL(ArrayList<Image> framesPunchL) {
        this.framesPunchL = framesPunchL;
    }

    public ArrayList<Image> getFramesPunchR() {
        return framesPunchR;
    }

    public void setFramesPunchR(ArrayList<Image> framesPunchR) {
        this.framesPunchR = framesPunchR;
    }

    public ArrayList<Image> getFramesKickL() {
        return framesKickL;
    }

    public void setFramesKickL(ArrayList<Image> framesKickL) {
        this.framesKickL = framesKickL;
    }

    public ArrayList<Image> getFramesKickR() {
        return framesKickR;
    }

    public void setFramesKickR(ArrayList<Image> framesKickR) {
        this.framesKickR = framesKickR;
    }

    public ArrayList<Image> getFramesKOL() {
        return framesKOL;
    }

    public void setFramesKOL(ArrayList<Image> framesKOL) {
        this.framesKOL = framesKOL;
    }

    public ArrayList<Image> getFramesKOR() {
        return framesKOR;
    }

    public void setFramesKOR(ArrayList<Image> framesKOR) {
        this.framesKOR = framesKOR;
    }

    public ArrayList<Image> getFramesWinL() {
        return framesWinL;
    }

    public void setFramesWinL(ArrayList<Image> framesWinL) {
        this.framesWinL = framesWinL;
    }

    public ArrayList<Image> getFramesWinR() {
        return framesWinR;
    }

    public void setFramesWinR(ArrayList<Image> framesWinR) {
        this.framesWinR = framesWinR;
    }

    public Transition getT() {
        return t;
    }

    public void setT(Transition t) {
        this.t = t;
    }

    public ArrayList<Image> getFramesWakeUpL() {
        return framesWakeUpL;
    }

    public void setFramesWakeUpL(ArrayList<Image> framesWakeUpL) {
        this.framesWakeUpL = framesWakeUpL;
    }

    public ArrayList<Image> getFramesWakeUpR() {
        return framesWakeUpR;
    }

    public void setFramesWakeUpR(ArrayList<Image> framesWakeUpR) {
        this.framesWakeUpR = framesWakeUpR;
    }

    public void listFilesForFolder(File folder, ArrayList<Image> ar) {

        for (int i = 0; i < folder.listFiles().length; i++) {
            if (folder.listFiles()[i].isDirectory()) {
                listFilesForFolder(folder.listFiles()[i], ar);
            } else {
                ar.add(new Image(folder.listFiles()[i].toURI().toString()));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
