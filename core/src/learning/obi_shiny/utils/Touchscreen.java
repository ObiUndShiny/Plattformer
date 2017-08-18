package learning.obi_shiny.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by User on 15.08.2017.
 */


public class Touchscreen implements InputProcessor {

    private float x;
    private float y;
    private boolean dragged;

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        x = 2*((screenX*1.0f)/ Gdx.graphics.getWidth())-1;
        y = -2*((screenY*1.0f)/ Gdx.graphics.getHeight())+1;
        dragged = true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        dragged = false;

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        x = 2*((screenX*1.0f)/ Gdx.graphics.getWidth())-1;
        y = -2*((screenY*1.0f)/ Gdx.graphics.getHeight())+1;

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isDragged() {
        return dragged;
    }
}
