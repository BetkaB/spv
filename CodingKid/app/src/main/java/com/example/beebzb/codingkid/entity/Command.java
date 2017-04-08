package com.example.beebzb.codingkid.entity;

public class Command {
    private CommandType mCommandType;
    private int count = 1;

    public Command(CommandType mCommandType) {
        this.mCommandType = mCommandType;
        if (mCommandType == CommandType.LOOP_END) {
            count = 0;
        }
    }

    public int getCount() {
        return count;
    }

    public CommandType getCommandType() {
        return mCommandType;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Command{" + mCommandType +
                ", count=" + count +
                '}';
    }
}