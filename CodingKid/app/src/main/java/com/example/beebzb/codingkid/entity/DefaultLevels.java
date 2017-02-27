package com.example.beebzb.codingkid.entity;


import java.util.ArrayList;

public class DefaultLevels {
    public static final Level[] DEFAULT_LEVELS = new Level[]{getDefaultLevel1()};

    private static Level getDefaultLevel1() {
        Level level1 = new Level();
        level1.setId(0);
        level1.setCommands(4);
        level1.setHearts(0);
        level1.setStartPosition(new Position(4, 6));
        level1.setHousePosition(new Position(4, 10));
        level1.setBoxPositions(new ArrayList<Position>() {{
            add(new Position(4, 6));
            add(new Position(4, 7));
            add(new Position(4, 8));
            add(new Position(4, 9));
            add(new Position(4, 10));
        }});
        level1.setName("Lets start");
        level1.setAuthor("Default Kid");

        return level1;
    }
}