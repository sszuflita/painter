package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class GameState {
    private final Entity playerState;
    private final Array<Entity> pastStates;
    private final boolean isJumping;

    public GameState(Entity playerState, Array<Entity> pastStates, boolean isJumping) {
        this.playerState = playerState;
        this.pastStates = pastStates;
        this.isJumping = isJumping;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public Entity getPlayerState() {
        return playerState;

    }

    public Array<Entity> getPastStates() {
        return pastStates;
    }
}
