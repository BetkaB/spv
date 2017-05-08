package com.example.beebzb.codingkid.entity;


public class DefaultLevels {
    public static final Level[] DEFAULT_LEVELS = new Level[]{
            get1(), get2(), get3(), get4(), get5(), get6(), get7(), get8(), get9(), get10(),
            get11(), get12(), get13(), get14(), get15(), get16(), get17(), get18(), get19(), get20(),
            get21(), get22(), get23(), get24(), get25(), get26(), get27(), get28(), get29()};

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
        level1.setStartPosition(new Position(4, 10));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_HOUSE, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 3");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get4() {
        Level level1 = new Level();
        level1.setId(3);
        level1.setCommands(2);
        level1.setHearts(1);
        level1.setStartPosition(new Position(4, 11));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_HOUSE, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 4");
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
        level1.setStartPosition(new Position(1, 13));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0},
                {0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_HOUSE, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0, 0},
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
        level1.setCommands(2);
        level1.setHearts(2);
        level1.setStartPosition(new Position(1, 13));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0},
                {0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_HOUSE, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_HEART, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0, 0},
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
        level1.setCommands(2);
        level1.setHearts(3);
        level1.setStartPosition(new Position(1, 13));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0},
                {0, 0, 0, 0, 0, Level.CONST_HEART, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, Level.CONST_HOUSE, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_HEART, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0, 0},
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
        level1.setName("Hra 13");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get14() {
        Level level1 = new Level();
        level1.setId(13);
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
        level1.setName("Hra 14");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get15() {
        Level level1 = new Level();
        level1.setId(14);
        level1.setCommands(5);
        level1.setHearts(0);
        level1.setStartPosition(new Position(7, 4));
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
        level1.setName("Hra 15");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get16() {
        Level level1 = new Level();
        level1.setId(15);
        level1.setCommands(4);
        level1.setHearts(0);
        level1.setStartPosition(new Position(6, 0));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 16");
        level1.setAuthor("Default Kid");
        return level1;
    }


    private static Level get17() {
        Level level1 = new Level();
        level1.setId(16);
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
        level1.setName("Hra 17");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get18() {
        Level level1 = new Level();
        level1.setId(17);
        level1.setCommands(7);
        level1.setHearts(3);
        level1.setStartPosition(new Position(1, 0));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_HEART, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 18");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get19() {
        Level level1 = new Level();
        level1.setId(18);
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
        level1.setName("Hra 19");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get5() {
        Level level1 = new Level();
        level1.setId(4);
        level1.setCommands(2);
        level1.setHearts(1);
        level1.setStartPosition(new Position(6, 6));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, Level.CONST_HOUSE, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 5");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get20() {
        Level level1 = new Level();
        level1.setId(19);
        level1.setCommands(6);
        level1.setHearts(4);
        level1.setStartPosition(new Position(4, 3));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_HEART, 0, Level.CONST_HEART, 0, Level.CONST_HEART, 0, Level.CONST_HEART, 0, 0, 0, 0},
                {0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 20");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get21() {
        Level level1 = new Level();
        level1.setId(20);
        level1.setCommands(8);
        level1.setHearts(4);
        level1.setStartPosition(new Position(4, 3));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_HEART, 0, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_HEART, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {0, 0, 0, Level.CONST_BOX, 0, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE, Level.CONST_HOUSE, Level.CONST_HOUSE, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 21");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get22() {
        Level level1 = new Level();
        level1.setId(21);
        level1.setCommands(9);
        level1.setHearts(3);
        level1.setStartPosition(new Position(3, 11));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, Level.CONST_HOUSE, Level.CONST_BOX, 0, Level.CONST_HEART, Level.CONST_BOX, 0, Level.CONST_HEART, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, Level.CONST_HOUSE, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {0, Level.CONST_HOUSE, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_HOUSE, 0, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_HOUSE, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, 0, 0, 0, 0, Level.CONST_HEART, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 22");
        level1.setAuthor("Default Kid");
        return level1;
    }


    private static Level get23() {
        Level level1 = new Level();
        level1.setId(22);
        level1.setCommands(8);
        level1.setHearts(3);
        level1.setStartPosition(new Position(6, 3));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_HEART, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_HEART, 0, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, 0, 0, Level.CONST_BOX, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, Level.CONST_BOX, 0, 0, 0},
                {0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 22");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get24() {
        Level level1 = new Level();
        level1.setId(23);
        level1.setCommands(11);
        level1.setHearts(4);
        level1.setStartPosition(new Position(7, 2));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HEART, 0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_HEART, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, 0, 0},
                {0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, 0, 0},
                {0, Level.CONST_BOX, 0, 0, Level.CONST_BOX, 0, 0, Level.CONST_HEART, 0, 0, Level.CONST_BOX, 0, 0, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_HEART, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, 0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 24");
        level1.setAuthor("Default Kid");
        return level1;
    }


    private static Level get25() {
        Level level1 = new Level();
        level1.setId(24);
        level1.setCommands(6);
        level1.setHearts(3);
        level1.setStartPosition(new Position(5, 4));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, Level.CONST_HEART, 0, Level.CONST_HEART, 0, Level.CONST_HEART, 0, 0, 0, 0},
                {0, 0, 0, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, Level.CONST_HOUSE, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 25");
        level1.setAuthor("Default Kid");
        return level1;
    }

    private static Level get26() {
        Level level1 = new Level();
        level1.setId(25);
        level1.setCommands(6);
        level1.setHearts(3);
        level1.setStartPosition(new Position(3, 11));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {Level.CONST_BOX, Level.CONST_HEART, 0, Level.CONST_HEART, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HEART, 0, Level.CONST_HEART, Level.CONST_BOX, 0, Level.CONST_BOX, 0, 0},
                {Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0},
                {Level.CONST_HEART, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HEART, 0, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HEART, 0, Level.CONST_BOX, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 26");
        level1.setAuthor("Default Kid");
        return level1;
    }


    private static Level get27() {
        Level level1 = new Level();
        level1.setId(26);
        level1.setCommands(7);
        level1.setHearts(0);
        level1.setStartPosition(new Position(1, 0));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 27");
        level1.setAuthor("Default Kid");
        return level1;
    }


    private static Level get28() {
        Level level1 = new Level();
        level1.setId(27);
        level1.setCommands(6);
        level1.setHearts(0);
        level1.setStartPosition(new Position(1, 0));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_HOUSE, 0, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 28");
        level1.setAuthor("Default Kid");
        return level1;
    }


    private static Level get29() {
        Level level1 = new Level();
        level1.setId(28);
        level1.setCommands(7);
        level1.setHearts(3);
        level1.setStartPosition(new Position(6, 1));
        int[][] gameMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, Level.CONST_BOX, Level.CONST_HEART, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_HEART, Level.CONST_BOX, Level.CONST_BOX, 0},
                {0, 0, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_HEART, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0, Level.CONST_BOX, 0},
                {0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, Level.CONST_BOX, Level.CONST_BOX, 0, Level.CONST_BOX, 0},
                {0, Level.CONST_BOX, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, Level.CONST_BOX, 0},
                {0, Level.CONST_BOX, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, Level.CONST_BOX, 0, 0, 0, Level.CONST_HOUSE, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        level1.setGameMap(gameMap);
        level1.setName("Hra 29");
        level1.setAuthor("Default Kid");
        return level1;
    }


}