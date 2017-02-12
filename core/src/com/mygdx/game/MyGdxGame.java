package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int x;
	int y;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("circle.jpg");
		x = 0;
		y = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, .9f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			x -= 200 * Gdx.graphics.getDeltaTime();
		}

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			x += 200 * Gdx.graphics.getDeltaTime();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			dispose();
		}

		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
