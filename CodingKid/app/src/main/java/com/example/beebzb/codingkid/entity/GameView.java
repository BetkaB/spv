package com.example.beebzb.codingkid.entity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.example.beebzb.codingkid.R;

public class GameView extends View {

    private final String TAG = "GameView";

    private GameLoop mainLoop;
    Bitmap gameBitmap;
    Canvas gameCanvas;

    private Drawable boxDrawable;

    private Drawable playerDrawable;
    private Drawable heartDrawable;
    private Drawable houseDrawable;

    private Paint paint;
    private Level level;

    private int partWidth;
    private  int partHeight;

    private Context context;
    private Activity activity;

    public GameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setDrawingCacheEnabled(true);

        this.context = context;

        gameCanvas = new Canvas();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mainLoop = new GameLoop(getResources(), gameCanvas);
        mainLoop.start();
    }

    @SuppressLint("DrawAllocation")
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        gameBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        gameCanvas.setBitmap(gameBitmap);

        setMeasuredDimension(w, h);
    }

    public void init(Activity activity){
        this.activity = activity;
        boxDrawable = ContextCompat.getDrawable(activity, R.drawable.box);
        playerDrawable = ContextCompat.getDrawable(activity, R.drawable.player);
        houseDrawable = ContextCompat.getDrawable(activity, R.drawable.house);
        heartDrawable = ContextCompat.getDrawable(activity, R.drawable.heart);

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(gameBitmap, 0, 0, new Paint());
        drawGrid(canvas);
        invalidate();
        if (level != null) {
            drawBoxes(canvas);
            drawDrawable(level.getStartPosition().x,level.getStartPosition().y,playerDrawable,canvas);
            drawDrawable(level.getHousePosition().x,level.getHousePosition().y,houseDrawable,canvas);
            drawHearts(canvas);
        }
    }

    public void drawGrid(Canvas canvas) {

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(getResources().getColor(R.color.colorDonJuan));

        partWidth = this.getWidth() / GameConstants.columns;
        partHeight = this.getHeight() / GameConstants.rows;

        // code for grid
        /*
        // horizontal lines
        for (int i = 0; i < columns; i++) {
            float x = (float) (partWidth * i);
            canvas.drawLine(x, 0, x, this.getHeight(), paint);
        }

        // vertical lines
        for (int i = 0; i < rows; i++) {
            float y = (float) (partHeight * i);
            canvas.drawLine(0, y, this.getWidth(), y, paint);
        }

        */
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    private void drawDrawable(int x, int y, Drawable drawable, Canvas canvas){
        drawable.setBounds(x*partWidth, y*partHeight, (x*partWidth) + partWidth, (y*partHeight)+ partHeight);
        drawable.draw(canvas);
    }

    private void drawBoxes(Canvas canvas){
        for (Position pos : level.getBoxPositions()){
            drawDrawable(pos.x,pos.y,boxDrawable,canvas);
        }
    }

    private void drawHearts(Canvas canvas){
        for (Position pos : level.getHeartsPositions()){
            drawDrawable(pos.x,pos.y,heartDrawable,canvas);
        }
    }
}

