package edu.binghamton.khanson3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Snake extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture worm_head;
	Texture worm_body;

	List<Texture> worm;

	TextureRegion backgroundTexture;

	int worm_x;
	int worm_y;

	int width;
	int height;
	
	@Override
	public void create () {
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();

		//width = 1794; height = 1080;
		System.out.println(width + " " + height);

		batch = new SpriteBatch();
		backgroundTexture = new TextureRegion(new Texture("Worm_Background.png"), 0, 0, width, height);
		worm_head = new Texture("Worm_Head.png");
		worm_body = new Texture("Worm_Body.png");


		worm = new ArrayList<>(Arrays.asList(worm_head, worm_body));

		worm_x = (int) ((width/4) + (Math.random() * ((width-128) - (width/4))));
		worm_y = (int) (64 + (Math.random() * (height - 64)));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		batch.draw(backgroundTexture, 0, 0);

		for(int i = 0; i < worm.size(); i++) {
			batch.draw(worm.get(i), worm_x + i*64, worm_y);
		}
		worm_x-= 5;
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		worm_head.dispose();
		worm_body.dispose();
	}

	@Override
    public void resize(int width, int height) {
	    //this.width = width;
	    //this.height = height;
    }

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
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
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
}
