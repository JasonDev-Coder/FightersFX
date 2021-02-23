package sample.Fighters;

import javafx.scene.image.ImageView;

public class KenFactory extends BaseFighterFactory {
    @Override
    public Fighter createFighter(ImageView im) {
        return new Ken(im);
    }
}
