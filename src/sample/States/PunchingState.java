package sample.States;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;
import sample.Music;

public class PunchingState extends FighterState {

    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input) {
        if (input.getEventType() == KeyEvent.KEY_RELEASED)
            return new StanceState();
        else return null;
    }

    @Override
    public void update(Fighter fighter) {
        if (fighter.isL()) {
            if (fighter.getCurrentPosition().getX() > 100)
                fighter.getCurrentPosition().setX(fighter.getCurrentPosition().getX() - 45);
        } else {
            if (fighter.getCurrentPosition().getX() < 1200)
                fighter.getCurrentPosition().setX(fighter.getCurrentPosition().getX() + 45);
        }
    }

    @Override
    public void enter(Fighter fighter, Fighter fighter2, KeyEvent code) {
        fighter.getPunchAudio().play();
        if (code.getCode() == KeyCode.Q && fighter.isL()) {
            fighter.makeTransition(fighter.getFramesPunchL(), fighter.getPunchDur(), fighter.getStanceL());
        } else if (code.getCode() == KeyCode.CONTROL && !fighter.isL()) {
            fighter.makeTransition(fighter.getFramesPunchR(), fighter.getPunchDur(), fighter.getStanceR());
        }
        if (fighter.getCurrentPosition().intersects(fighter2.getCurrentPosition().getBoundsInParent())) {
            Music.playPunch();
            fighter2.setHealth(fighter2.getHealth() - fighter.getPunchDamage());
            if (fighter2.isL()) {
                update(fighter2);
            } else {
                update(fighter2);
            }
        }
    }
}
