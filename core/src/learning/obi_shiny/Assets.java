package learning.obi_shiny;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by User on 13.08.2017.
 */

public class Assets {

    public static Texture tilesheet;
    public static TextureRegion[][] tiles;

    public static void load(){

        tilesheet = new Texture("tilesheet.png");
        tiles = TextureRegion.split(tilesheet, tilesheet.getWidth()/8, tilesheet.getHeight()/10);
    }

}
