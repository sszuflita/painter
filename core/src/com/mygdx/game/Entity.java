package com.mygdx.game;

public class Entity {
    private final float x;
    private final float y;
    private final float xVelocity;
    private final float yVelocity;
    private final float xAcceleration;
    private final float yAcceleration;
    private int oldness;

    public Entity(float x, float y, float xVelocity, float yVelocity, float xAcceleration, float yAcceleration, int oldNess) {
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
        this.oldness = oldNess;
    }


    public Entity withIncrementedOldness() {
        return new Entity(x, y, xVelocity, yVelocity, xAcceleration, y, oldness + 1);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public float getyVelocity() {
        return yVelocity;
    }

    public float getxAcceleration() {
        return xAcceleration;
    }

    public float getyAcceleration() {
        return yAcceleration;
    }

    public int getOldness() {
        return oldness;
    }

}
