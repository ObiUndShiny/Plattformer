package learning.obi_shiny.utils;

/**
 * Created by User on 18.08.2017.
 */

public class Vector {

    private float x;
    private float y;


    public Vector(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void add(Vector other)
    {
        this.x += other.x;
        this.y += other.y;
    }
}
