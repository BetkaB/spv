package com.example.beebzb.codingkid.entity;

import java.util.ArrayList;

public class Level {

    private String name;
    private String author = "Coding Kid";
    private int commands = 0;
    private int hearts = 0;
    private Position startPosition;
    private ArrayList<Position> heartsPositions = new ArrayList<>();
    private ArrayList<Position> boxPositions = new ArrayList<>();
    private ArrayList<Position> housesPositions = new ArrayList<>();

    private Position player;
    private int id;

    public Level(int id,int commands, int hearts, ArrayList<Position> housePositions, Position startPosition, ArrayList<Position> heartsPositions, ArrayList<Position> boxPositions, String name, String author) {
        this.commands = commands;
        this.hearts = hearts;
        this.housesPositions = housePositions;
        this.startPosition = startPosition;
        this.heartsPositions = heartsPositions;
        this.boxPositions = boxPositions;
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

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public ArrayList<Position> getHousesPositions() {
        return housesPositions;
    }

    public void setHousesPositions(ArrayList<Position> housesPositions) {
        this.housesPositions = housesPositions;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position startPosition) {
        this.startPosition = startPosition;
    }

    public ArrayList<Position> getHeartsPositions() {
        return heartsPositions;
    }

    public void setHeartsPositions(ArrayList<Position> heartsPositions) {
        this.heartsPositions = heartsPositions;
    }

    public ArrayList<Position> getBoxPositions() {
        return boxPositions;
    }

    public void setBoxPositions(ArrayList<Position> boxPositions) {
        this.boxPositions = boxPositions;
    }

    public Position getPlayer() {
        return player;
    }

    public void setPlayer(Position player) {
        this.player = player;
    }

    public boolean isValid() {
        return housesPositions.size() != 0 && startPosition != null;
    }

    @Override
    public String toString() {
        return "Level{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", commands=" + commands +
                ", hearts=" + hearts +
                ", housePosition=" + housesPositions +
                ", startPosition=" + startPosition +
                ", heartsPositions=" + heartsPositions +
                ", boxPositions=" + boxPositions +
                ", player=" + player +
                '}';
    }
}
