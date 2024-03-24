package com.example.snakegame9;

import android.graphics.Point;


public abstract class GameObject {
    protected Point location;

    public GameObject() {
        location = new Point();
    }

    public abstract void move();

    public Point getLocation() {
        return location;
    }
}