package sample.Factories;

import javafx.scene.image.ImageView;
import sample.Fighters.Chunli;
import sample.Fighters.Fighter;

public class ChunliFactory extends BaseFighterFactory{

    @Override
    public Fighter createFighter(ImageView im) {
        Chunli chunli=new Chunli(im);
        chunli.getCurrentPosition().setScaleX(2.8);
        chunli.getCurrentPosition().setScaleY(2.8);
        return chunli;
    }
}
