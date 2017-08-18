package learning.obi_shiny.world;

import learning.obi_shiny.utils.Touchscreen;
import learning.obi_shiny.utils.Vector;

/**
 * Created by User on 16.08.2017.
 */

public class Player {

    private Touchscreen touchscreen;
    private static final float SPEED = 0.05f;
    private Vector gravity;
    private Vector velocity;
    private Vector jump;

    public Player (Touchscreen touchscreen)
    {
        this.touchscreen = touchscreen;
        this.gravity = new Vector(0,-0.01f);
        this.jump = new Vector(0,0.05f);
        this.velocity = new Vector(5,1);
    }

    public void update()
    {
        if(touchscreen.isDragged())
        {

            if(touchscreen.getX() < 0)
            {
                if(touchscreen.getX() < -0.5)
                {
                    velocity.setX(velocity.getX()-SPEED);
                }
                else
                {
                    velocity.setX(velocity.getX()+SPEED);
                }

            }
            else
            {
                velocity.add(jump);
            }
        }

        velocity.add(gravity);
        if(velocity.getY() < 1)
        {
            velocity.setY(1);
        }
    }

    public float getX() {
        return velocity.getX();
    }

    public float getY() {
        return velocity.getY();
    }

}
