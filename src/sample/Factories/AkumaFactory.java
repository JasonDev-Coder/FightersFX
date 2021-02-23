package sample.Factories;

import javafx.scene.image.ImageView;
import sample.Fighters.Akuma;
import sample.Fighters.Fighter;

public class AkumaFactory extends BaseFighterFactory{

    @Override
    public Fighter createFighter(ImageView im) {
        Akuma akuma=new Akuma(im);
        im.setScaleX(2.18);
        im.setScaleY(2.32);
        return akuma;
    }
}
