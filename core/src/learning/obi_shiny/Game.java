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
		Touchscreen touchscreen = new Touchscreen();

		level = new Level();

		for (int n = 0; n < 30; n++)
		{
			level.add(new Tile(true,n,0,2,1));
			level.add(new Tile(true,n,1,2,1));
			level.add(new Tile(true,n,2,1,1));
		}

		level.add(new Tile(true,8,3,0,4));
		level.add(new Tile(true,9,3,0,4));
		level.add(new Tile(true,10,3,0,4));

		level.add(new Tile(false,5,3,0,1));

		level.add(new Tile(true,3,3,1,1));
		level.add(new Tile(true,2,3,1,1));

		Gdx.input.setInputProcessor(touchscreen);
		this.player = new Player(touchscreen, level);
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
			batch.draw(texture,(t.getX()-player.getX()+8)*100,(t.getY()-player.getY()+3)*100,100,100);
			//fbatch.draw(batch, t.getX()+"|"+t.getY(), (t.getX()-player.getX()+8)*100,(t.getY()-player.getY()+4)*100);
		}

		batch.draw(Assets.player[0][0],800 ,275 ,100,200);

		fbatch.draw(batch, String.format("%.3f",player.getX())+" | "+String.format("%.3f",player.getY()) + " | " + ((int) player.getX()) + " | " + player.isGrounded(), 10, Gdx.graphics.getHeight()-10);

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
