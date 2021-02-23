
package sample.States;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;
import sample.Music;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class KickingState extends FighterState {
    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input){
        if(input.getEventType() == KeyEvent.KEY_RELEASED)
            return new StanceState();
        else return null;
    }
    @Override
    public void enter(Fighter fighter,Fighter fighter2, KeyEvent input) {
        fighter.getKickAudio().play();
        if(input.getCode() == KeyCode.S && fighter.isL()){
            fighter.makeTransition(fighter.getFramesKickL(),fighter.getKickDur(),fighter.getStanceL());
        }else if(input.getCode()==KeyCode.K && !fighter.isL()){
            fighter.makeTransition(fighter.getFramesKickR(),fighter.getKickDur(),fighter.getStanceR());
        }

    }
    @Override
    public void update(Fighter fighter) {

    }
}