package sample.States;

import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;

public class KOState extends FighterState{

    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input) {
        return null;
    }

    @Override
    public void update(Fighter fighter) {
        fighter.setState(new WinState());
        fighter.getState().enter(fighter,null,null);
    }

    @Override
    public void enter(Fighter fighter, Fighter fighter2, KeyEvent code) {
        fighter.getKOAudio().play();
        if(fighter.isL())
            fighter.makeTransition(fighter.getFramesKOL(),fighter.getKoDur(),fighter.getFramesKOL().get(fighter.getFramesKOL().size()-1));
        else
            fighter.makeTransition(fighter.getFramesKOR(),fighter.getKoDur(),fighter.getFramesKOR().get(fighter.getFramesKOR().size()-1));
        update(fighter2);
    }
}
