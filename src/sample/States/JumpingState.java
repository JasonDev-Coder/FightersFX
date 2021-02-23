package sample.States;

import javafx.animation.TranslateTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import sample.Fighters.Akuma;
import sample.Fighters.Fighter;

public class JumpingState extends FighterState {

    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input) {
        if(input.getEventType() == KeyEvent.KEY_RELEASED)
            return new StanceState();
        else return null;
    }

    @Override
    public void update(Fighter fighter) {

    }

    @Override
    public void enter(Fighter fighter,Fighter fighter2, KeyEvent code) {
        update(fighter);
        fighter.getJumpAudio().play();
        if(code.getCode() == KeyCode.W && fighter.isL()){
            fighter.makeJump(fighter.getFramesJumpL(),fighter.getJumpingDur(),fighter.getStanceL());
        }else if(code.getCode()==KeyCode.I && !fighter.isL()){
            fighter.makeJump(fighter.getFramesJumpR(),fighter.getJumpingDur(),fighter.getStanceR());
        }

    }
}
