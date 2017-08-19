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

    public void addX(Vector other)
    {
        this.x += other.x;
    }

    public void addY(Vector other)
    {
        this.y += other.y;
    }

    public float getValue() {
        return (float) Math.sqrt((x*x)+(y*y));
    }

    public float getAngle() {
        if (x>0&&y>0) return (float) Math.toDegrees(Math.atan(y/x));
        if (x<0&&y>0) return (float) (180-Math.toDegrees(Math.atan(y/-x)));
        if (x>0&&y<0) return (float) (360-Math.toDegrees(Math.atan(-y/x)));
        if (x<0&&y<0) return (float) (180+Math.toDegrees(Math.atan(-y/-x)));

        if (x==0&&y>0) return 90;
        if (x==0&&y<0) return (float) 270;
        if (x>0&&y==0) return (float) 0;
        if (x<0&&y==0) return (float) 180;

        return 0;
    }

    public float getUnitX()
    {
        return (float) Math.cos(Math.toRadians(this.getAngle()));
    }

    public float getUnitY()
    {
        return (float) Math.sin(Math.toRadians(this.getAngle()));
    }

    public Vector getUnit()
    {
        return new Vector(getUnitX(), getUnitY());
    }

    public void multiply(float value)
    {
        x *= value;
        y *= value;
    }
}
