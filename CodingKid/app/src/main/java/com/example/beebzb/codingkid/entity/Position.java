package com.example.beebzb.codingkid.entity;

public class Position{
    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public Position() {
    }

    public int x;
    public int y;

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}