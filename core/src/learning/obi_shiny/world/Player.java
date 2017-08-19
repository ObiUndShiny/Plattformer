package learning.obi_shiny.world;

import learning.obi_shiny.utils.Touchscreen;
import learning.obi_shiny.utils.Vector;

/**
 * Created by User on 16.08.2017.
 */

public class Player {

    private Touchscreen touchscreen;
    private static final float SPEED = 0.01f;
    private static final int JUMP_TICKS = 20;
    private Vector gravity;
    private Vector velocity;
    private Vector position;
    private Vector jump;
    private boolean grounded;
    private int frames_in_air = 0;


    public Player (Touchscreen touchscreen)
    {
        this.touchscreen = touchscreen;
        this.gravity = new Vector(0,-0.01f);
        this.jump = new Vector(0,0.05f);
        this.position = new Vector(5,1);
        this.velocity = new Vector(0,0);

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
                if(frames_in_air < JUMP_TICKS) {
                    velocity.add(jump);
                }
            }
        }

        grounded = position.getY() <= 1;

        if(!grounded)
        {
            frames_in_air++;
            velocity.add(gravity);
            position.add(velocity);
        }
        else
        {
            frames_in_air = 0;
            if(velocity.getY()>=0)
            {
                position.addY(velocity);
            }
            position.addX(velocity);
        }
        velocity.multiply(0.9f);
    }

    public float getX() {
        return position.getX();
    }

    public float getY() {
        return position.getY();
    }

}
