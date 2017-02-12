package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	GameState lastState;
	float x;
	float y;
	float vx;
	float vy;
	float ax;
	float ay;

	boolean isJumping;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("circle.jpg");
		x = 0;
		y = 0;
		vx = 0;
		vy = 0;
		ax = 0;
		ay = 0;

		Entity playerState = new Entity(0, 0, 0, 0, 0, 0);
		Array<Entity> pastStates = Array.of(Entity.class);
		lastState = new GameState(playerState, pastStates, false);
	}

	@Override
	public void render () {

		float delta = Gdx.graphics.getDeltaTime();

		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, .9f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			x -= 200 * delta;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			x += 200 * delta;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !isJumping) {
			isJumping = true;
			ay += 1000;
		} else if (y <= 0){
			isJumping = false;
		}

		y = y + vy * delta;

		vy = vy + ay * delta;

		if (y < 0) {
			y = 0;
			ay = 0;
			vy = 0;
		} else {
			ay = ay - 100;
		}

		batch.draw(img, x, y, 100, 100);
		batch.end();

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			dispose();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
