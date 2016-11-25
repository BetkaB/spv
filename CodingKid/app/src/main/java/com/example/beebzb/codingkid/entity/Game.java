package com.example.beebzb.codingkid.entity;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Game {

    private final String TAG = "Game";
    private Resources resources;
    private Canvas canvas;

    private int x = 0;
    private Paint paint;

    public Game(Resources res, Canvas cas) {
        resources = res;
        canvas = cas;

        paint = new Paint();
        paint.setTextSize(50);
    }

    public void draw() {
        //TODO drawing movable object
      //  canvas.drawColor(Color.WHITE);
      //  canvas.drawRect(new Rect(x, 0, x + 50, 50), paint);
    }

    public void update() {
        x += 1;
        Log.d(TAG, "X: " + x);
    }
}