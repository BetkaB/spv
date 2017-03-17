package com.example.beebzb.codingkid;


import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
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

    private int mGatheredHearts = 0;
    private int[][] mGameMap;

    ImageView[][] mCurrentHeartsViews = new ImageView[GameConstants.rows][GameConstants.columns];

    private enum NextAction {NEXT_STEP, WIN, LOST}

    public void reset() {
        Log.d(TAG, "reset");
        removePlayer();
        playerView = drawPlayer();
        level.setPlayer(new Position(level.getStartPosition().y, level.getStartPosition().x));
        initHeartsMap();
        mGatheredHearts = 0;
    }

    private void removePlayer() {
        if (playerView != null) {
            ((ViewManager) playerView.getParent()).removeView(playerView);
            playerView = null;
        } else {
            Log.e(TAG, "playerView is null. Cannot be removed");
        }
    }

    interface GameCallback {
        void onLastMove();

        void onHeartGathered(int gatheredHearts);

        void onLost();

        void onWin();
    }

    private GameCallback mGameCallback;

    public GameGrid(Context context) {
        super(context);
    }

    public void startMoving(ArrayList<CommandType> stepsToMove, GameCallback callback) {
        Log.d(TAG, "Commands: " + stepsToMove);
        if (callback == null) {
            Log.e(TAG, "GameCallback cannot be null ! ");
        } else {
            this.mGameCallback = callback;
            mIndex = 0;
            this.mStepsToMove = stepsToMove;
            nextStep();
            mGameMap = level.getGameMap();
        }
    }

    private void initHeartsMap() {
        // copy and draw hearts
        Log.d(TAG, "before removing hearts");
        removeAllHearts();
        Log.d(TAG, "heats removed");
        mCurrentHeartsViews = new ImageView[GameConstants.rows][GameConstants.columns];
        for (int i = 0; i < mGameMap.length; i++)
            for (int j = 0; j < mGameMap[i].length; j++) {
                if (mGameMap[i][j] == Level.CONST_HEART) {
                    mCurrentHeartsViews[i][j] = drawDrawable(i, j, R.drawable.heart);
                }
            }
    }

    private void removeAllHearts() {
        for (int i = 0; i < mCurrentHeartsViews.length; i++)
            for (int j = 0; j < mCurrentHeartsViews[i].length; j++) {
                if (mCurrentHeartsViews[i][j] != null) {
                    this.removeView(mCurrentHeartsViews[i][j]);
                }
            }
    }

    private void nextStep() {
        Log.d(TAG, "nextStep ");
        if (mIndex < mStepsToMove.size()) {
            movePlayer(mStepsToMove.get(mIndex));
        } else {
            Log.d(TAG, "end of animation");
            Utils.shortToast(getContext(), "End of animations");
            mGameCallback.onLastMove();
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

    private ImageView drawDrawable(int i, int j, @DrawableRes int drawableId) {
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

    private void drawGameMap() {
        for (int i = 0; i < mGameMap.length; i++) {
            for (int j = 0; j < mGameMap[i].length; j++) {
                int obj = mGameMap[i][j];
                if (obj == Level.CONST_BOX) {
                    drawDrawable(i, j, R.drawable.box);
                } else if (obj == Level.CONST_HOUSE) {
                    drawDrawable(i, j, R.drawable.box);
                    drawDrawable(i, j, R.drawable.house);
                } else if (obj == Level.CONST_HEART) {
                    drawDrawable(i, j, R.drawable.box);
                } else {
                    drawDrawable(i, j, R.drawable.total_empty);
                }
            }
        }
    }

    private void initGrid() {
        Log.d(TAG, "level: " + level.toString());
        init();
        level.setPlayer(level.getStartPosition());
        mGameMap = level.getGameMap();
        drawGameMap();
        initHeartsMap();
        playerView = drawPlayer();
    }

    private ImageView drawPlayer() {
        return drawDrawable(level.getStartPosition().y, level.getStartPosition().x, R.drawable.player);
    }

    private void movePlayer(CommandType type) {
        Log.d(TAG, "--------- ");

        Log.d(TAG, "moving: " + type.toString());
        Log.d(TAG, "Player before: " + level.getPlayer().toString());
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

        // TODO check step out of grid? is there box ? is there heart? house?
        if (isPlayerOutsideGrid(newX, newY)) {
            Log.d(TAG, "outside grid");
            makeGameOverStep(fromXPosition, fromYPosition);
        } else {
            Log.d(TAG, "inside grid");
            if (!isBoxOnNextPosition(newX, newY)) {
                makeStep(NextAction.LOST, dirAnimDrawId, newX, newY, fromXPosition, toXPosition, fromYPosition, toYPosition);
            } else {
                if (isHeartOnNextPosition(newX, newY)) {
                    makeStep(NextAction.NEXT_STEP, dirAnimDrawId, newX, newY, fromXPosition, toXPosition, fromYPosition, toYPosition);
                    pickHeart(newY, newX);
                }
                else if (isHouseOnNextPosition(newX, newY) && mGatheredHearts >= level.getHearts()){
                    makeStep(NextAction.WIN, dirAnimDrawId, newX, newY, fromXPosition, toXPosition, fromYPosition, toYPosition);
                }
                else {
                    makeStep(NextAction.NEXT_STEP, dirAnimDrawId, newX, newY, fromXPosition, toXPosition, fromYPosition, toYPosition);
                }
            }
        }
    }

    private boolean isHouseOnNextPosition(int newX, int newY) {
        return mGameMap[newY][newX] == Level.CONST_HOUSE;
    }

    private boolean isHeartOnNextPosition(int newX, int newY) {
        Log.d(TAG, "isHeartOnNextPosition: newX:" + newX + ", newY" + newY);
        return mCurrentHeartsViews[newY][newX] != null;
    }

    private AnimationSet getLooseAnimation(int fromXPosition, int fromYPosition) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(ScaleAnimation.RELATIVE_TO_SELF, 0, ScaleAnimation.RELATIVE_TO_SELF, 0);
        scaleAnimation.setFillAfter(true); // Needed to keep the result of the animation
        scaleAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(2000);
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotateAnimation);
        set.addAnimation(scaleAnimation);
        return set;
    }

    private boolean isPlayerOutsideGrid(int newX, int newY) {
        return newX >= GameConstants.columns || newX < 0 || newY >= GameConstants.rows || newY < 0;
    }

    private void pickHeart(int newY, int newX) {
        this.removeView(mCurrentHeartsViews[newY][newX]);
        mCurrentHeartsViews[newY][newX] = null;
        mGatheredHearts++;
        mGameCallback.onHeartGathered(mGatheredHearts);
    }

    private boolean isBoxOnNextPosition(int newX, int newY) {
        return mGameMap[newY][newX] >= Level.CONST_BOX;
    }

    private void makeGameOverStep(int fromXPosition, int fromYPosition) {
        AnimationSet looseAnimation = getLooseAnimation(fromXPosition, fromYPosition);
        looseAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                playerView.setVisibility(View.INVISIBLE);
                mGameCallback.onLost();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        playerView.startAnimation(looseAnimation);
    }

    private void makeStep(final NextAction nextAction, @DrawableRes int dirAnimDrawId, int newX, int newY, final int fromXPosition, int toXPosition, final int fromYPosition, int toYPosition) {
        Log.d(TAG,"making step: "+nextAction.toString());
        AnimationDrawable directionAnimation = (AnimationDrawable)
                ResourcesCompat.getDrawable(getResources(), dirAnimDrawId, null);

        if (directionAnimation != null) {
            directionAnimation.setOneShot(false);
            playerView.setImageDrawable(directionAnimation);
            directionAnimation.start();
        }

        TranslateAnimation transAnimation = new TranslateAnimation(fromXPosition, toXPosition, fromYPosition, toYPosition);
        transAnimation.setDuration(500);
        final int finalNewY = newY;
        final int finalNewX = newX;
        level.setPlayer(new Position(finalNewY, finalNewX));

        transAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "Player after: " + level.getPlayer().toString());
                GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                param.width = mPartWidth;
                param.height = mPartHeight;
                //param.setGravity(Gravity.CENTER);
                param.columnSpec = GridLayout.spec(level.getPlayer().x);
                param.rowSpec = GridLayout.spec(level.getPlayer().y);
                playerView.setLayoutParams(param);

                switch (nextAction){
                    case LOST:
                        makeGameOverStep(fromXPosition, fromYPosition);
                        break;
                    case NEXT_STEP:
                        mIndex++;
                        nextStep();
                        break;
                    case WIN:
                        // TODO make win animation and at the end - onWin callback
                        mGameCallback.onWin();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        playerView.startAnimation(transAnimation);
    }
}
