package learning.obi_shiny;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import learning.obi_shiny.utils.Touchscreen;

public class Game extends ApplicationAdapter {

	private SpriteBatch batch;
	private learning.obi_shiny.world.Level level;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		learning.obi_shiny.utils.Assets.load();
		level = new learning.obi_shiny.world.Level();
		Touchscreen touchscreen = new Touchscreen();

		for (int n = 0; n < 30; n++)
		{
			learning.obi_shiny.world.Tile tile = new learning.obi_shiny.world.Tile(true,n,0,1,1);
			level.add(tile);
		}
		Gdx.input.setInputProcessor(touchscreen);
	}

	@Override
	public void render () {

        clearScreen();

		batch.begin();
		for ( learning.obi_shiny.world.Tile t : level.getTiles())
		{
			TextureRegion texture = learning.obi_shiny.utils.Assets.tiles[t.getU()][t.getV()];
			batch.draw(texture,t.getX()*100,t.getY()*100,100,100);
		}
		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		learning.obi_shiny.utils.Assets.tilesheet.dispose();
	}

	private void clearScreen() {
        Gdx.gl.glClearColor(0.4f, 0.4f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
