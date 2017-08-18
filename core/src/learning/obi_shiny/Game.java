package learning.obi_shiny;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import learning.obi_shiny.utils.Assets;
import learning.obi_shiny.utils.Touchscreen;
import learning.obi_shiny.world.Level;
import learning.obi_shiny.world.Player;
import learning.obi_shiny.world.Tile;

public class Game extends ApplicationAdapter {

	private SpriteBatch batch;
	private BitmapFont fbatch;
	private Level level;
	private Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		fbatch = new BitmapFont();

		Assets.load();
		level = new Level();
		Touchscreen touchscreen = new Touchscreen();

		for (int n = 0; n < 30; n++)
		{
			Tile tile = new Tile(true,n,0,1,1);
			level.add(tile);
		}

		Gdx.input.setInputProcessor(touchscreen);
		this.player = new Player(touchscreen);
		fbatch = Assets.pokefont;
	}

	@Override
	public void render () {

		player.update();
        clearScreen();

		batch.begin();
		for ( Tile t : level.getTiles())
		{
			TextureRegion texture = Assets.tiles[t.getU()][t.getV()];
			batch.draw(texture,(t.getX()-player.getX()+5)*100,(t.getY()-player.getY()+1)*100,100,100);
		}

		batch.draw(Assets.player[0][5],500 ,100 ,100,200);

		fbatch.draw(batch, player.getX()+" | "+player.getY(), 10, Gdx.graphics.getHeight()-10);

		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		Assets.tilesheet.dispose();
	}

	private void clearScreen() {
        Gdx.gl.glClearColor(0.4f, 0.4f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
