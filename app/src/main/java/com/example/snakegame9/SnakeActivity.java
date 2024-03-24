package com.example.snakegame9;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SnakeActivity extends Activity {

    // Declare an instance of SnakeGame
    SnakeGame mSnakeGame;

    // Set the game up
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the pixel dimensions of the screen
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // Create a new instance of the SnakeEngine class
        mSnakeGame = new SnakeGame(this, size);

        // Create a FrameLayout to contain the game view and the pause button
        FrameLayout layout = new FrameLayout(this);
        layout.addView(mSnakeGame);

        // Setup the pause button
        Button pauseButton = new Button(this);
        pauseButton.setText("Pause");
        Typeface customTypeFace = Typeface.createFromAsset(getAssets(), "Rakkas-Regular.ttf");
        pauseButton.setTypeface(customTypeFace);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSnakeGame != null) {
                    mSnakeGame.togglePause();
                }
            }
        });

        // Add the pause button to the FrameLayout
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(200, 20, 20, 20); // Adjust margins as needed
        layout.addView(pauseButton, params);

        TextView textView = new TextView(this);
        textView.setText("Huy Tran and Nicholas Sanchez");
        textView.setTypeface(customTypeFace);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

        FrameLayout.LayoutParams textViewParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        textViewParams.gravity = Gravity.TOP | Gravity.END;
        textViewParams.topMargin = 20;
        textViewParams.rightMargin = 20;
        layout.addView(textView, textViewParams);

        // Set the FrameLayout as the content view
        setContentView(layout);
    }

    // Start the thread in snakeEngine
    @Override
    protected void onResume() {
        super.onResume();
        mSnakeGame.resume();
    }

    // Stop the thread in snakeEngine
    @Override
    protected void onPause() {
        super.onPause();
        mSnakeGame.pause();
    }
}
