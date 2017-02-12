package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class GameState {
    private final Entity playerState;
    private final Array<Entity> pastStates;

    public GameState(Entity playerState, Array<Entity> pastStates) {
        this.playerState = playerState;
        this.pastStates = pastStates;
    }

    public Entity getPlayerState() {
        return playerState;
    }

    public Array<Entity> getPastStates() {
        return pastStates;
    }
}
