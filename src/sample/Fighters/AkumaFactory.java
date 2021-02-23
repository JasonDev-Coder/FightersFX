package sample.Fighters;

import javafx.scene.image.ImageView;

public class AkumaFactory extends BaseFighterFactory{

    @Override
    public Fighter createFighter(ImageView im) {
        return new Akuma(im);
    }
}
