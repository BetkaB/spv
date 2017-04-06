package com.example.beebzb.codingkid.entity;


public class DefaultLevels {
    public static final Level[] DEFAULT_LEVELS = new Level[]{
            get1(), get2(), get3(), get3(), get3(), get6(), get7(), get8(), get9(),
            get10(), get11(), get12(), get13(), get14(), get15()};

    // TODO add levels: 4, 5, 16, 17, 18, + add to array!
    private static Level get1() {
        Level level1 = new Level();
        level1.setId(0);
        level1.setCommands(1);
        level1.setHearts(0);
        level1.setStartPosition(new Position(1, 6));
        int[][] gameMap = new int[GameConstants.rows][GameConstants.columns];
        gameMap[1][6] = Level.CONST_BOX;
        gameMap[1][7] = Level.CONST_BOX;
        gameMap[1][8] = Level.CONST_BOX;
        gameMap[1][10] = Level.CONST_BOX;
        gameMap[1][11] = Level.CONST_BOX;
        gameMap[1][12] = Level.CONST_HOUSE;
        gameMap[1][9] = Level.CONST_BOX;
        level1.setGameMap(gameMap);
        level1.setName("Hra 1");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get2() {
        Level level1 = new Level();
        level1.setId(1);
        level1.setCommands(2);
        level1.setHearts(0);
        level1.setStartPosition(new Position(4, 6));
        int[][] gameMap = new int[GameConstants.rows][GameConstants.columns];
        gameMap[4][6] = Level.CONST_BOX;
        gameMap[4][7] = Level.CONST_BOX;
        gameMap[4][8] = Level.CONST_BOX;
        gameMap[4][10] = Level.CONST_BOX;
        gameMap[4][11] = Level.CONST_BOX;
        gameMap[4][12] = Level.CONST_BOX;
        gameMap[1][12] = Level.CONST_HOUSE;
        gameMap[2][12] = Level.CONST_BOX;
        gameMap[3][12] = Level.CONST_BOX;
        gameMap[4][9] = Level.CONST_BOX;
        level1.setGameMap(gameMap);
        level1.setName("Hra 2");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get3() {
        Level level1 = new Level();
        level1.setId(2);
        level1.setCommands(1);
        level1.setHearts(1);
        level1.setStartPosition(new Position(4, 6));
        int[][] gameMap = new int[GameConstants.rows][GameConstants.columns];
        gameMap[4][6] = Level.CONST_BOX;
        gameMap[4][7] = Level.CONST_BOX;
        gameMap[4][8] = Level.CONST_BOX;
        gameMap[4][10] = Level.CONST_BOX;
        gameMap[4][11] = Level.CONST_BOX;
        gameMap[4][12] = Level.CONST_HOUSE;
        gameMap[4][9] = Level.CONST_HEART;
        level1.setGameMap(gameMap);
        level1.setName("Hra 3");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get6() {
        Level level1 = new Level();
        level1.setId(5);
        level1.setCommands(2);
        level1.setHearts(1);
        level1.setStartPosition(new Position(6, 6));
        int[][] gameMap = new int[GameConstants.rows][GameConstants.columns];
        gameMap[5][6] = Level.CONST_BOX;
        gameMap[6][6] = Level.CONST_BOX;
        gameMap[4][6] = Level.CONST_BOX;
        gameMap[3][6] = Level.CONST_BOX;
        gameMap[3][7] = Level.CONST_BOX;
        gameMap[3][8] = Level.CONST_BOX;
        gameMap[3][9] = Level.CONST_HOUSE;
        gameMap[3][2] = Level.CONST_HOUSE;
        gameMap[3][3] = Level.CONST_BOX;
        gameMap[3][4] = Level.CONST_BOX;
        gameMap[3][5] = Level.CONST_HEART;
        level1.setGameMap(gameMap);
        level1.setName("Hra 6");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get7() {
        Level level1 = new Level();
        level1.setId(6);
        level1.setCommands(4);
        level1.setHearts(1);
        level1.setStartPosition(new Position(2, 4));
        int[][] gameMap = new int[GameConstants.rows][GameConstants.columns];
        gameMap[2][4] = Level.CONST_BOX;
        gameMap[2][5] = Level.CONST_BOX;
        gameMap[2][6] = Level.CONST_BOX;
        gameMap[2][7] = Level.CONST_BOX;
        gameMap[3][4] = Level.CONST_BOX;
        gameMap[3][5] = Level.CONST_BOX;
        gameMap[3][6] = Level.CONST_HEART;
        gameMap[3][7] = Level.CONST_BOX;
        gameMap[4][7] = Level.CONST_BOX;
        gameMap[5][7] = Level.CONST_BOX;
        gameMap[6][7] = Level.CONST_HOUSE;
        level1.setGameMap(gameMap);
        level1.setName("Hra 7");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get8() {
        Level level1 = new Level();
        level1.setId(7);
        level1.setCommands(6);
        level1.setHearts(1);
        level1.setStartPosition(new Position(2, 2));
        int[][] gameMap = new int[GameConstants.rows][GameConstants.columns];
        gameMap[2][2] = Level.CONST_BOX;
        gameMap[2][3] = Level.CONST_BOX;
        gameMap[2][4] = Level.CONST_BOX;
        gameMap[3][4] = Level.CONST_BOX;
        gameMap[4][4] = Level.CONST_BOX;
        gameMap[5][4] = Level.CONST_BOX;
        gameMap[5][5] = Level.CONST_BOX;
        gameMap[5][6] = Level.CONST_BOX;
        gameMap[6][6] = Level.CONST_HEART;
        gameMap[5][7] = Level.CONST_BOX;
        gameMap[5][8] = Level.CONST_BOX;
        gameMap[5][9] = Level.CONST_BOX;
        gameMap[5][10] = Level.CONST_HOUSE;
        level1.setGameMap(gameMap);
        level1.setName("Hra 8");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get9() {
        Level level1 = new Level();
        level1.setId(8);
        level1.setCommands(4);
        level1.setHearts(2);
        level1.setStartPosition(new Position(4, 4));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 9");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get10() {
        Level level1 = new Level();
        level1.setId(9);
        level1.setCommands(2);
        level1.setHearts(2);
        level1.setStartPosition(new Position(1, 11));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, Level.CONST_HOUSE, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 10");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get11() {
        Level level1 = new Level();
        level1.setId(10);
        level1.setCommands(4);
        level1.setHearts(0);
        level1.setStartPosition(new Position(5, 6));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 11");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get12() {
        Level level1 = new Level();
        level1.setId(11);
        level1.setCommands(4);
        level1.setHearts(0);
        level1.setStartPosition(new Position(5, 12));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 12");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get13() {
        Level level1 = new Level();
        level1.setId(12);
        level1.setCommands(5);
        level1.setHearts(0);
        level1.setStartPosition(new Position(7, 5));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 13");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get14() {
        Level level1 = new Level();
        level1.setId(13);
        level1.setCommands(5);
        level1.setHearts(0);
        level1.setStartPosition(new Position(1, 2));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 14");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get15() {
        Level level1 = new Level();
        level1.setId(14);
        level1.setCommands(6);
        level1.setHearts(3);
        level1.setStartPosition(new Position(1, 13));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, Level.CONST_HOUSE, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 15");
        level1.setAuthor("Default Kid");
        return level1;
    }

}