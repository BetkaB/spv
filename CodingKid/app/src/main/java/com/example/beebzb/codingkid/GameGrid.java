package com.example.beebzb.codingkid;


import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.beebzb.codingkid.entity.CommandType;
import com.example.beebzb.codingkid.entity.GameConstants;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.entity.Position;

import java.util.ArrayList;

public class GameGrid extends GridLayout {
    private static final String TAG = "GameGrid";

    ImageView playerView;
    private Level level;

    private int mPartHeight;
    private int mPartWidth;

    private boolean onFirstWindowMeasured = true;

    private ArrayList<CommandType> mStepsToMove;
    private int mIndex = 0;

    public GameGrid(Context context) {
        super(context);
    }

    public void startMoving(ArrayList<CommandType> stepsToMove){
        Log.d(TAG,"Commands: "+stepsToMove);
        mIndex = 0;
        this.mStepsToMove = stepsToMove;
        nextStep();
    }

    private void nextStep(){
        Log.d(TAG,"nextStep ");
        if (mIndex < mStepsToMove.size()){
            movePlayer(mStepsToMove.get(mIndex));
        }
        else {
            Log.d(TAG,"end of animation");
            Utils.shortToast(getContext(), "End of animations");
        }
    }

    private void init() {
        this.setRowCount(GameConstants.rows);
        this.setColumnCount(GameConstants.columns);
        mPartHeight = getHeight() / GameConstants.rows;
        mPartWidth = getWidth() / GameConstants.columns;
    }

    public GameGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // the height will be set at this point
        if (onFirstWindowMeasured) {
            initGrid();
            onFirstWindowMeasured = false;
        }
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    private ImageView drawDrawable(int j, int i, @DrawableRes int drawableId) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(drawableId);
        GridLayout.LayoutParams param = new GridLayout.LayoutParams();
        param.height = mPartHeight;
        param.width = mPartWidth;
        param.setGravity(Gravity.CENTER);
        param.columnSpec = GridLayout.spec(j);
        param.rowSpec = GridLayout.spec(i);
        imageView.setLayoutParams(param);
        this.addView(imageView);
        return imageView;
    }

    private void drawBoxes() {
        for (Position pos : level.getBoxPositions()) {
            drawDrawable(pos.x, pos.y, R.drawable.box);
        }
    }

    private void drawHearts() {
        for (Position pos : level.getHeartsPositions()) {
            drawDrawable(pos.x, pos.y, R.drawable.heart);
        }
    }

    private void initGrid() {
        Log.d(TAG,"level: "+level.toString());
        init();
        level.setPlayer(level.getStartPosition());
        drawBoxes();
        drawHearts();
        playerView = drawPlayer();
    }

    private ImageView drawPlayer() {
        return drawDrawable(level.getStartPosition().x, level.getStartPosition().y, R.drawable.player);
    }

    private void movePlayer(CommandType type) {
        Log.d(TAG,"--------- ");

        Log.d(TAG,"moving: "+type.toString());
        Log.d(TAG,"Player before: "+ level.getPlayer().toString());
        int fromXPosition = level.getPlayer().x;
        int fromYPosition = level.getPlayer().y;
        int toXPosition = level.getPlayer().x;
        int toYPosition = level.getPlayer().y;

        int newX = level.getPlayer().x;
        int newY = level.getPlayer().y;

        // TODO animation stay at place
        @DrawableRes int dirAnimDrawId = R.drawable.player_animation_down;
        switch (type) {
            case RIGHT:
                toXPosition = level.getPlayer().x + mPartWidth;
                dirAnimDrawId = R.drawable.player_animation_down;
                newX++;
                break;
            case LEFT:
                toXPosition = level.getPlayer().x - mPartWidth;
                dirAnimDrawId = R.drawable.player_animation_down;
                newX--;
                // TODO change drawbale file
                break;
            case UP:
                toYPosition = level.getPlayer().y - mPartHeight;
                dirAnimDrawId = R.drawable.player_animation_down;
                newY--;
                // TODO change drawbale file
                break;
            case DOWN:
                newY++;
                toYPosition = level.getPlayer().y + mPartHeight;
                dirAnimDrawId = R.drawable.player_animation_down;
                break;
            default:
                break;
        }

        AnimationDrawable directionAnimation = (AnimationDrawable)
                ResourcesCompat.getDrawable(getResources(), dirAnimDrawId, null);


        if (directionAnimation != null) {
            directionAnimation.setOneShot(false);
            playerView.setImageDrawable(directionAnimation);
            directionAnimation.start();
        }

        TranslateAnimation transAnimation = new TranslateAnimation(fromXPosition, toXPosition, fromYPosition, toYPosition);
        transAnimation.setDuration(1000);
        final int finalNewY = newY;
        final int finalNewX = newX;
        level.setPlayer(new Position(finalNewY, finalNewX));

        transAnimation.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                param.width = mPartWidth;
                param.height = mPartHeight;
                //param.setGravity(Gravity.CENTER);
                param.columnSpec = GridLayout.spec(level.getPlayer().x);
                param.rowSpec = GridLayout.spec(level.getPlayer().y);

                playerView.setLayoutParams(param);

                Log.d(TAG,"Player after: "+ level.getPlayer().toString());

                mIndex++;
                nextStep();


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        playerView.startAnimation(transAnimation);

    }

}
