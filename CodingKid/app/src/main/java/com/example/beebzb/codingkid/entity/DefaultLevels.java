package com.example.beebzb.codingkid.entity;


public class DefaultLevels {
    public static final Level[] DEFAULT_LEVELS = new Level[]{getDefaultLevel1()};

    private static Level getDefaultLevel1() {
        Level level1 = new Level();
        level1.setId(0);
        level1.setCommands(4);
        level1.setHearts(0);
        level1.setStartPosition(new Position(1, 6));
        int[][] gameMap = new int[GameConstants.rows][GameConstants.columns];
        gameMap[1][6] = Level.CONST_BOX;
        gameMap[1][7] = Level.CONST_BOX;
        gameMap[1][8] = Level.CONST_BOX;
        gameMap[1][9] = Level.CONST_BOX;
        gameMap[1][10] = Level.CONST_HOUSE;
        level1.setGameMap(gameMap);
        level1.setName("Lets start");
        level1.setAuthor("Default Kid");

        return level1;
    }
}