package learning.obi_shiny.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by User on 13.08.2017.
 */

public class Assets {

    public static Texture tilesheet;
    public static TextureRegion[][] tiles;
    public static Texture playersheet;
    public static TextureRegion[][] player;
    public static BitmapFont pokefont;

    public static void load(){

        tilesheet = new Texture("tilesheet.png");
        tiles = TextureRegion.split(tilesheet, tilesheet.getWidth()/8, tilesheet.getHeight()/10);
        playersheet = new Texture("player.png");
        player = TextureRegion.split(playersheet, playersheet.getWidth()/8, playersheet.getHeight()/2);
        pokefont = loadFont("dialog_text",50);
    }

    /**
     * load a freetype font file and returns it as BitmapFont
     *
     * @param name represents the name of the file in the fonts folder without .ttf
     * @param size represents the size the font should have (font size is not dynamic!)
     * @return loaded font as BitmapFont
     */
    private static BitmapFont loadFont(String name, int size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/"+name+".ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }
}
