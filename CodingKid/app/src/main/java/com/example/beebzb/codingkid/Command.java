package com.example.beebzb.codingkid;

public enum Command {
    LOOP_START(R.string.command_loop_start),
    LOOP_END(R.string.command_loop_end),
    LEFT(R.string.command_left),
    UP(R.string.command_up),
    DOWN(R.string.command_down),
    RIGHT(R.string.command_right);

    private final int stringId;

    Command(int id) {
        this.stringId = id;
    }

    public int getStringId() {
        return stringId;
    }
}
