package sample.Factories;

import javafx.scene.image.ImageView;
import sample.Fighters.Fighter;
import sample.Fighters.Ryu;

public class RyuFactory extends BaseFighterFactory{

    @Override
    public Fighter createFighter(ImageView im) {
        return new Ryu(im);
    }
}
