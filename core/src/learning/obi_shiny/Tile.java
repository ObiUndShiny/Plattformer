package learning.obi_shiny;

/**
 * Created by User on 07.08.2017.
 */

public class Tile {

    private boolean solid;
    private int x;
    private int y;
    private int u;
    private int v;

    public Tile(boolean solid,int x, int y, int u, int v)
    {
        this.solid = solid;
        this.x = x;
        this.y = y;
        this.u = u;
        this.v = v;
    }

    public boolean isSolid() {
        return solid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }
}

