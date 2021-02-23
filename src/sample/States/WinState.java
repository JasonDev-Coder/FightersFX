package sample.States;

import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;

public class WinState extends FighterState {

    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input) {
        return null;
    }

    @Override
    public void update(Fighter fighter) {

    }

    @Override
    public void enter(Fighter fighter, Fighter fighter2, KeyEvent code) {
       if(fighter.isL())
           fighter.makeTransition(fighter.getFramesWinL(),fighter.getWinDur(),fighter.getFramesWinL().get(fighter.getFramesWinL().size()-1));
       else
           fighter.makeTransition(fighter.getFramesWinR(),fighter.getWinDur(),fighter.getFramesWinR().get(fighter.getFramesWinR().size()-1));
    }
}
