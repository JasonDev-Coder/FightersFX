package sample.States;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;

public class ForwardState extends FighterState {
    private AnimationTimer timer;
    public ForwardState(Fighter fighter){
        update(fighter);
        timer.start();
    }
    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input) {
        if (input.getEventType() == KeyEvent.KEY_RELEASED) {
            timer.stop();
            return new StanceState();
        } else return null;
    }

    @Override
    public void enter(Fighter fighter,Fighter fighter2, KeyEvent input) {
        if (input.getCode() == KeyCode.D && fighter.isL()) {
            fighter.setCurrentPosition(fighter.getForwardL());
        } else if (input.getCode() == KeyCode.J && !fighter.isL()) {
            fighter.setCurrentPosition(fighter.getForwardR());
        }
    }

    @Override
    public void update(Fighter fighter) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (fighter.isL() && fighter.getCurrentPosition().getX() < 1200)
                    fighter.getCurrentPosition().setX(fighter.getCurrentPosition().getX() + 4.5);
                else if (!fighter.isL() && fighter.getCurrentPosition().getX() > 100)
                    fighter.getCurrentPosition().setX(fighter.getCurrentPosition().getX() - 4.5);
            }
        };
    }
}
