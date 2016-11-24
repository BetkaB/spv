package com.example.beebzb.codingkid;

public class Command {
    private CommandType mCommandType;
    private int count = 0;


    public Command(CommandType mCommandType) {

        this.mCommandType = mCommandType;
        if (mCommandType == CommandType.LOOP_START){
            count = 1;
        }
    }

    public int getCount() {
        return count;
    }

    public CommandType getmCommandType() {
        return mCommandType;
    }

    public void setCount(int count) {

        this.count = count;
    }

}
