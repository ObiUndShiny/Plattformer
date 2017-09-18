package learning.obi_shiny.world;

import learning.obi_shiny.utils.Touchscreen;
import learning.obi_shiny.utils.Vector;

/**
 * Created by User on 16.08.2017.
 */

public class Player {

    private Touchscreen touchscreen;
    private static final float SPEED = 0.01f;
    private static final int JUMP_TICKS = 6;
    private Vector gravity;
    private Vector velocity;
    private Vector position;
    private Vector jump;
    private boolean grounded;
    private int frames_in_air = 0;
    private Level level;


    public Player (Touchscreen touchscreen, Level level)
    {
        this.touchscreen = touchscreen;
        this.gravity = new Vector(0,-0.01f);
        this.jump = new Vector(0,0.05f);
        this.position = new Vector(5,4);
        this.velocity = new Vector(0,0);
        this.level = level;

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

        grounded = calcCollision();

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

        if (position.getX() <= 0) {
            position.setX(0);
        }

    }

    private boolean calcCollision() {

        int target_x = (int) position.getX();
        boolean grounded = false;
        boolean collides_on_sides = false;

        for (Tile t : level.getTiles()) {
            if (t.isSolid()) {

                collides_on_sides = false;

                // horizonzal collision
                if ((int)position.getY()==t.getY()) {

                    // left horizontal collision
                    if (velocity.getX() < 0 && position.getX()-1 <= t.getX() && target_x == t.getX()) {
                        velocity.setX(0);
                        position.setX(t.getX()+1);
                        collides_on_sides = true;
                    }

                    // right horizontal collision
                    if (velocity.getX() > 0 && position.getX()+1 > t.getX() && target_x+1 == t.getX()) {
                        velocity.setX(0);
                        position.setX(t.getX()-1);
                        collides_on_sides = true;
                    }
                }

                // vertical collision
                if (target_x == t.getX() || target_x+1 == t.getX()) {
                    if ((int)(position.getY()-0.001f) == t.getY()) {
                        if (!this.grounded) {
                            if (!collides_on_sides) {
                                position.setY(t.getY()+1);
                            }
                        }
                        grounded = true;
                    }
                }

            }
        }

        return grounded;

    }

    public float getX() {
        return position.getX();
    }

    public float getY() {
        return position.getY();
    }

    public boolean isGrounded() {
        return grounded;
    }

}
