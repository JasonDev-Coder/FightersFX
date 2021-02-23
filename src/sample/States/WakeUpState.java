package sample.States;

import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;
import sample.Music;

public class WakeUpState extends FighterState {

    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input) {
        return new DamageState();
    }

    @Override
    public void update(Fighter fighter) {
        Music.playPunch();
        if (fighter.isL()) {
            if (fighter.getCurrentPosition().getX() > 100)
                fighter.getCurrentPosition().setX(fighter.getCurrentPosition().getX() - 45);
        } else {
            if (fighter.getCurrentPosition().getX() < 1200)
                fighter.getCurrentPosition().setX(fighter.getCurrentPosition().getX() + 45);
        }
    }

    @Override
    public void enter(Fighter fighter, Fighter attacker, KeyEvent code) {
        if (attacker.getCurrentPosition().getBoundsInParent().intersects(fighter.getCurrentPosition().getBoundsInParent())) {
            if (fighter.isL())
                fighter.makeTransition(fighter.getFramesWakeUpL(), fighter.getWakeUpDur(), fighter.getStanceL());
            else
                fighter.makeTransition(fighter.getFramesWakeUpR(), fighter.getWakeUpDur(), fighter.getStanceR());
            update(fighter);
            fighter.setHealth(fighter.getHealth() - attacker.getKickDamage());
        }
    }
}
