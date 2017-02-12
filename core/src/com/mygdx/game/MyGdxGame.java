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
	GameState lastGameState;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("circle.jpg");


		Entity playerState = new Entity(0, 0, 0, 0, 0, 0, 0);
		Array<Entity> pastStates = Array.of(Entity.class);
		lastGameState = new GameState(playerState, pastStates, false);
	}

	@Override
	public void render () {

		float delta = Gdx.graphics.getDeltaTime();

		clearScreen();

		Entity lastPlayerState = lastGameState.getPlayerState();

		float newX = lastPlayerState.getX();
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			newX -= 200 * delta;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			newX += 200 * delta;
		}

		float newVy = lastPlayerState.getyVelocity() + lastPlayerState.getyAcceleration() * delta;
		float newY = lastPlayerState.getY() + lastPlayerState.getyVelocity() * delta;

		float newAy = lastPlayerState.getyAcceleration() - 100;
		boolean newIsJumping = lastGameState.isJumping();
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !lastGameState.isJumping()) {
			newIsJumping = true;
			newAy += 1000;
		} else if (lastPlayerState.getY() <= 0){
			newIsJumping = false;
		}

		if (newY < 0) {
			newAy = 0;
			newY = 0;
			newVy = 0;
		}

		Entity newPlayerState = new Entity(newX, newY, 0, newVy, 0, newAy, 0);

		Array<Entity> pastStates = lastGameState.getPastStates();
		pastStates.add(lastGameState.getPlayerState());
		updatePastStates(pastStates);

		GameState newGameState = new GameState(newPlayerState, pastStates, newIsJumping);
		draw(newGameState);

		lastGameState = newGameState;

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			dispose();
		}
	}

	private void updatePastStates(Array<Entity> pastStates) {
		int n = pastStates.size;
		int start = Math.max(0, n - 10);

		for (int i = start; i < n; i++) {
			Entity newEntity = pastStates.get(i).withIncrementedOldness();
			pastStates.set(i, newEntity);
		}
	}

	private void clearScreen() {
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, .9f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	private void draw(GameState gameState) {
		batch.begin();
		batch.draw(img, gameState.getPlayerState().getX(), gameState.getPlayerState().getY(), 100, 100);

		for (Entity pastState : gameState.getPastStates()) {
			if (pastState.getOldness() == 10) {
				batch.draw(img, pastState.getX(), pastState.getY(), 100, 100);
			}
		}

		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
