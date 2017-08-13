package learning.obi_shiny;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

	private SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Assets.load();
	}

	@Override
	public void render () {

        clearScreen();

		batch.begin();
		batch.draw(Assets.tiles[0][1], 0, 0, 300, 300);
		batch.end();


	}
	
	@Override
	public void dispose () {
		batch.dispose();
		Assets.tilesheet.dispose();
	}

	private void clearScreen() {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
