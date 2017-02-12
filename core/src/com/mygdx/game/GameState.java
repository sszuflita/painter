package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class GameState {
    private final Entity playerState;
    private final Array<Entity> pastStates;
    private final boolean isJumping;
    private int frameCounter;

    public GameState(Entity playerState, Array<Entity> pastStates, boolean isJumping, int frameCounter) {
        this.playerState = playerState;
        this.pastStates = pastStates;
        this.isJumping = isJumping;
        this.frameCounter = frameCounter;
    }

    private void updatePastStates(Array<Entity> pastStates) {
        int n = pastStates.size;
        int start = Math.max(0, n - 10);

        for (int i = start; i < n; i++) {
            Entity newEntity = pastStates.get(i).withIncrementedOldness();
            pastStates.set(i, newEntity);
        }
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

    public int getFrameCounter() {
        return frameCounter;
    }
}
