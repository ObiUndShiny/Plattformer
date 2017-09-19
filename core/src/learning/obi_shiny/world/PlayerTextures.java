package learning.obi_shiny.world;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import learning.obi_shiny.utils.AnimatedTexture;
import learning.obi_shiny.utils.Assets;

/**
 * Project FFOrganizer
 * Created by Bernhard Scharrer on 19.09.2017.
 */

public class PlayerTextures {

    private static final String RUN_FILE = "player.png";

    private AnimatedTexture run_left;
    private AnimatedTexture run_right;

    public PlayerTextures() {

        TextureRegion[][] atlas = Assets.split(RUN_FILE, 2, 8);

        run_right = Assets.loadAnimation(atlas, 0,0,8,1,0.1f);
        run_left = Assets.loadAnimation(atlas, 0,1,8,1,0.1f);

        run_left.start();
        run_right.start();

    }

    public AnimatedTexture getRunLeftAnimation() {
        return run_left;
    }

    public AnimatedTexture getRunRightAnimation() {
        return run_right;
    }

}
