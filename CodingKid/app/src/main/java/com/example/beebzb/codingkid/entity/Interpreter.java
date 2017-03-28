package com.example.beebzb.codingkid.entity;

import android.util.Log;

import java.util.ArrayList;

public class Interpreter {
    private static final String TAG = "Interpreter";
    private ArrayList<Command> mCommands;
    private Command mToken;
    private int mIndex;
    private int mMax;
    private ArrayList<CommandType> mResultCommandTypes;

    public Interpreter(ArrayList<Command> mCommands) {
        this.mCommands = mCommands;
        int listSize = mCommands.size();
        if (listSize > 0) {
            Log.d(TAG, "init");
            this.mMax = listSize - 1;
            this.mIndex = 0;
            mResultCommandTypes = new ArrayList<>();
            scan();
            interpret();
        }

    }

    private void scan() {
        if (mIndex > mMax) {
            mToken = null;
        } else {
            mToken = mCommands.get(mIndex);
            mIndex++;
        }
    }

    private void interpret() {
        while (true) {
            if (mToken == null) {
                break;
            }
            if (mToken.getmCommandType() == CommandType.LEFT) {
                for (int i = 0; i < mToken.getCount(); i++){
                    mResultCommandTypes.add(CommandType.LEFT);
                }
                Log.d(TAG, "Commands: " + mResultCommandTypes.toString());
                scan();
            } else if (mToken.getmCommandType() == CommandType.DOWN) {
                for (int i = 0; i < mToken.getCount(); i++){
                    mResultCommandTypes.add(CommandType.DOWN);
                }
                Log.d(TAG, "Commands: " + mResultCommandTypes.toString());

                scan();
            } else if (mToken.getmCommandType() == CommandType.UP) {
                for (int i = 0; i < mToken.getCount(); i++){
                    mResultCommandTypes.add(CommandType.UP);
                }
                Log.d(TAG, "Commands: " + mResultCommandTypes.toString());

                scan();
            } else if (mToken.getmCommandType() == CommandType.RIGHT) {
                for (int i = 0; i < mToken.getCount(); i++){
                    mResultCommandTypes.add(CommandType.RIGHT);
                }
                Log.d(TAG, "Commands: " + mResultCommandTypes.toString());

                scan();
            } else if (mToken.getmCommandType() == CommandType.LOOP_START) {
                int count = mToken.getCount();
                scan();
                int start = mIndex-1;
                while (count > 0) {
                    mIndex = start;
                    scan();
                    interpret();
                    count--;
                    if (mToken.getmCommandType() == CommandType.LOOP_END) {
                        scan();
                    }
                }
            } else {
                break;
            }
        }
    }

    public ArrayList<CommandType> getResultCommandTypes() {
        return mResultCommandTypes;
    }
}

