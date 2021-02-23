package sample.Fighters;

import javafx.scene.image.ImageView;


public abstract class BaseFighterFactory {
    public Fighter getFigher(ImageView im,boolean isL){
        Fighter fighter=this.createFighter(im);
        fighter.setL(isL);
        if(isL)
            fighter.getCurrentPosition().setX(200);
        else
            fighter.getCurrentPosition().setX(1100);
        fighter.getCurrentPosition().setY(490);
        fighter.getState().enter(fighter, null, null);
        return fighter;
    }
    public abstract Fighter createFighter(ImageView im);
}
