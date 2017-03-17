package com.example.beebzb.codingkid.entity;

public class Level {

    public static final int CONST_BOX = 1;
    public static final int CONST_HEART = 2;
    public static final int CONST_HOUSE = 3;

    private String name;
    private String author = "Coding Kid";
    private int commands = 0;
    private int hearts = 0;
    private Position startPosition;
    private int[][] gameMap = new int[GameConstants.rows][GameConstants.columns];
    private Position player;
    private int id;

    public Level(int id, int commands, int hearts, Position startPosition, int[][] gameMap, String name, String author) {
        this.commands = commands;
        this.hearts = hearts;
        this.startPosition = startPosition;
        this.gameMap = gameMap;
        this.name = name;
        this.author = author;
        this.id = id;
    }

    public Level() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCommands() {
        return commands;
    }

    public void setCommands(int commands) {
        this.commands = commands;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public int[][] getGameMap() {
        return gameMap;
    }

    public void setGameMap(int[][] gameMap) {
        this.gameMap = gameMap;
    }

    public Position getPlayer() {
        return player;
    }

    public void setPlayer(Position player) {
        this.player = player;
    }

    public boolean hasPlayer() {
        return startPosition != null ;
    }

    public boolean isMaximumNumberOfCommandsDefined(){
        return commands > 0;
    }
    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public boolean hasHouse() {
        for (int[] gameObject : gameMap) {
            for (int aGameObject : gameObject) {
                if (aGameObject == CONST_HOUSE) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Level{" +
                "name='" + name + '\'' +
                ", gameMap=" + arrayToString(gameMap) +
                ", author='" + author + '\'' +
                ", commands=" + commands +
                ", hearts=" + hearts +
                ", startPosition=" + startPosition +
                ", player=" + player +
                '}';
    }

    private String arrayToString(int[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == CONST_BOX) {
                    stringBuilder.append("Box(").append(i).append(",").append(j).append("), ");
                } else if (array[i][j] == CONST_HEART) {
                    stringBuilder.append("Heart(").append(i).append(",").append(j).append("), ");
                } else if (array[i][j] == CONST_HOUSE) {
                    stringBuilder.append("House(").append(i).append(",").append(j).append("), ");
                }
            }
        }
        return stringBuilder.toString();
    }
}
