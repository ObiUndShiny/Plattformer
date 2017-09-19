package learning.obi_shiny.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.List;

/**
 * Project FFOrganizer
 * Created by Bernhard Scharrer on 18.09.2017.
 */

public class AnimatedTexture {

    private Animation<TextureRegion> animation;
    private boolean running;
    private float time;

    public AnimatedTexture(Animation<TextureRegion> animation) {

        this.animation = animation;
        this.running = false;

    }

    public void start() {
        running = true;
        time = 0;
    }

    public void stop() {
        running = false;
        time = 0;
    }

    public void update() {
        if (running) {
            time += Gdx.graphics.getDeltaTime();
        }
    }

    public TextureRegion getTexture() {
        return animation.getKeyFrame(time, true);
    }

}
