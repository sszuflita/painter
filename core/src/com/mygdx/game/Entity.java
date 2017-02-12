package com.mygdx.game;

public class Entity {
    private final float x;
    private final float y;
    private final float xVelocity;
    private final float yVelocity;
    private final float xAcceleration;
    private final float yAcceleration;

    public Entity(float x, float y, float xVelocity, float yVelocity, float xAcceleration, float yAcceleration) {
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
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
}
