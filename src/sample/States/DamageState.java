package sample.States;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;

public class DamageState extends FighterState {

    @Override
    public FighterState handleInput(Fighter fighter, KeyEvent input) {
        if(fighter.getHealth()<=0){
          return new KOState();
        }
        else if(input.getCode()== KeyCode.S || input.getCode()==KeyCode.K){
            return new WakeUpState();
        }else return null;
    }

    @Override
    public void update(Fighter fighter) {

    }

    @Override
    public void enter(Fighter fighter, Fighter fighter2, KeyEvent code) {

    }
}
