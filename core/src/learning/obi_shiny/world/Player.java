package learning.obi_shiny.world;

import learning.obi_shiny.utils.Touchscreen;

/**
 * Created by User on 16.08.2017.
 */

public class Player {

    private Touchscreen touchscreen;
    private float x;
    private float y;
    private static final float SPEED = 0.05f;

    public Player (Touchscreen touchscreen)
    {
        this.touchscreen = touchscreen;
        this.x = 0;
        this.y = 0;
    }

    public void update()
    {
        if(touchscreen.getX() < 0)
        {
            if(touchscreen.getX() < -0.5)
            {
                x+=SPEED;
            }
            else
            {
                x-=SPEED;
            }

        }
        else
        {

        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
