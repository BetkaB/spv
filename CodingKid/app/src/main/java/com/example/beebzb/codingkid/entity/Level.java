package com.example.beebzb.codingkid.entity;

import java.util.ArrayList;

public class Level {

    private String name;
    private String author;
    private int commands;
    private int hearts;
    private Position housePosition;
    private Position startPosition;
    private ArrayList<Position> heartsPositions;
    private ArrayList<Position> boxPositions;
    private Position player;

    public Level(int commands, int hearts, Position housePosition, Position startPosition, ArrayList<Position> heartsPositions, ArrayList<Position> boxPositions, String name, String author) {
        this.commands = commands;
        this.hearts = hearts;
        this.housePosition = housePosition;
        this.startPosition = startPosition;
        this.heartsPositions = heartsPositions;
        this.boxPositions = boxPositions;
        this.name = name;
        this.author = author;
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

    public Position getHousePosition() {
        return housePosition;
    }

    public void setHousePosition(Position housePosition) {
        this.housePosition = housePosition;
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
}
