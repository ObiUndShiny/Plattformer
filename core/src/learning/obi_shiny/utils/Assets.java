package learning.obi_shiny.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by User on 13.08.2017.
 */

public class Assets {

    public static TextureRegion[][] tiles;

    public static BitmapFont pokefont;

    public static void load() {

        tiles = split("tilesheet.png", 10, 8);

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

    public static AnimatedTexture loadAnimation(TextureRegion[][] sprites, int x, int y, int width, int height, float speed) {

        TextureRegion[] animation_sprites = new TextureRegion[width*height];

        int index = 0;
        for (int row = x; row < x+width; row++) {
            for (int col = y; col < y+height; col++) {
                animation_sprites[index] = sprites[col][row];
                index++;
            }
        }

        Animation<TextureRegion> animation = new Animation<TextureRegion>(speed, animation_sprites);
        AnimatedTexture atexture = new AnimatedTexture(animation);
        return atexture;

    }

    public static TextureRegion[][] split(String file, int rows, int cols) {
        Texture atlas = new Texture(file);
        TextureRegion[][] sprites = TextureRegion.split(atlas, atlas.getWidth()/cols, atlas.getHeight()/rows);
        return sprites;
    }

}
