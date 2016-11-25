package com.example.beebzb.codingkid.entity;

import android.content.res.Resources;
import android.graphics.Canvas;


public class GameLoop extends Thread {

    private float frameRate = 60;
    private float frameTime = 1000 / frameRate;

    private Game logicGame;

    public GameLoop(Resources res, Canvas canvas) {
        logicGame = new Game(res, canvas);
    }

    @Override
    public void run() {
        while (true) {
            float startTime = System.currentTimeMillis();

            logicGame.update();
            logicGame.draw();

            float endTime = System.currentTimeMillis();
            long deltaTime = (long) (frameTime - (endTime - startTime));
            try {
                Thread.sleep(deltaTime);
            } catch (InterruptedException e) {
            }
        }
    }

}

