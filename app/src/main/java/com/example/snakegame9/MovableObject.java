package com.example.snakegame9;

import android.graphics.Point;


public abstract class MovableObject {
    protected Point location;

    public MovableObject() {
        location = new Point();
    }

    public abstract void move();

    public Point getLocation() {
        return location;
    }
}