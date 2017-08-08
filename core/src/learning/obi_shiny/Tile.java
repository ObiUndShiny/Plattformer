package learning.obi_shiny;

/**
 * Created by User on 07.08.2017.
 */

public class Tile {

    private boolean solid;
    private int x;
    private int y;

    public Tile(boolean solid,int x, int y)
    {
        this.solid = solid;
        this.x = x;
        this.y = y;
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
}

