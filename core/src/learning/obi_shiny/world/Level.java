package learning.obi_shiny.world;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 07.08.2017.
 */

public class Level {

    private List<Tile> tiles;

    public Level()
    {
        this.tiles = new ArrayList<Tile>();
    }

    public void add(Tile tile)
    {
        tiles.add(tile);

    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
