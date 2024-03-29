package com.example.snakegame9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import java.util.Random;

// Import Drawable interface
import com.example.snakegame9.Drawable;

public class Apple extends MovableObject implements Drawable {

    // The location of the apple on the grid
    // Not in pixels
    //private Point location = new Point();

    // The range of values we can choose from
    // to spawn an apple
   private Point mSpawnRange;
    private int mSize;

    // An image to represent the apple
    private Bitmap mBitmapApple;

    /// Set up the apple in the constructor
    Apple(Context context, Point sr, int s){
    super();
        // Make a note of the passed in spawn range
       mSpawnRange = sr;
        // Make a note of the size of an apple
        mSize = s;
        // Initialize the location
        location = new Point();
        // Hide the apple off-screen until the game starts
        location.x = -10;

        // Load the image to the bitmap
        mBitmapApple = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);

        // Resize the bitmap
        mBitmapApple = Bitmap.createScaledBitmap(mBitmapApple, s, s, false);
    }

    public void move() {
        // Apples don't move, so this method is empty
    }
    // This is called every time an apple is eaten
    void spawn(){
        // Choose two random values and place the apple
        Random random = new Random();
        location.x = random.nextInt(mSpawnRange.x) + 1;
        location.y = random.nextInt(mSpawnRange.y - 1) + 1;
    }

    // Let SnakeGame know where the apple is
    // SnakeGame can share this with the snake
   // Point getLocation(){return location;}

    // Draw the apple
    public void draw(Canvas canvas, Paint paint){
        canvas.drawBitmap(mBitmapApple,
                location.x * mSize, location.y * mSize, paint);

    }

}