package sample.States;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Fighters.Fighter;

import javax.swing.text.html.ImageView;

public abstract class FighterState {
    public abstract FighterState handleInput(Fighter fighter, KeyEvent input);
    public abstract void update(Fighter fighter);
    public abstract void enter(Fighter fighter,Fighter fighter2,KeyEvent code);

}
