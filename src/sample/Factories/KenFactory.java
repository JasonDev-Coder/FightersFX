package sample.Factories;

import javafx.scene.image.ImageView;
import sample.Fighters.Fighter;
import sample.Fighters.Ken;

public class KenFactory extends BaseFighterFactory {
    @Override
    public Fighter createFighter(ImageView im) {
        return new Ken(im);
    }
}
