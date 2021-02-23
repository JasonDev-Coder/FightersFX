package sample.States;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;

public class StanceState extends FighterState {
    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input) {
        if(input.getCode()==KeyCode.S || input.getCode()==KeyCode.K){
            return new KickingState();
        }else if(input.getCode()==KeyCode.Q || input.getCode()==KeyCode.CONTROL){
            return new PunchingState();
        }else if(input.getCode()==KeyCode.D || input.getCode()==KeyCode.J){
            return new ForwardState(fighter);
        }else if(input.getCode()==KeyCode.A || input.getCode()==KeyCode.L){
            return new BackwardState(fighter);
        }else if(input.getCode()==KeyCode.W || input.getCode()==KeyCode.I){
            return new JumpingState();
        }
        else return null;
    }

    @Override
    public void update(Fighter fighter) {

    }

    @Override
    public void enter(Fighter fighter,Fighter fighter2, KeyEvent code) {
        if(fighter.isL())
            fighter.setCurrentPosition(fighter.getStanceL());
        else
            fighter.setCurrentPosition(fighter.getStanceR());
    }
}
