package sample.Factories;

import javafx.scene.image.ImageView;
import sample.Fighters.Fighter;


public abstract class BaseFighterFactory {
    public Fighter getFighter(ImageView im, boolean isL){
        Fighter fighter=this.createFighter(im);
        fighter.setL(isL);
        if(isL)
            fighter.getCurrentPosition().setX(200);
        else
            fighter.getCurrentPosition().setX(1100);
        fighter.getCurrentPosition().setY(520);
        fighter.getState().enter(fighter, null, null);
        return fighter;
    }
    public abstract Fighter createFighter(ImageView im);
}
