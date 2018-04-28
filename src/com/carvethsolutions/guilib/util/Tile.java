package com.carvethsolutions.guilib.util;

import java.awt.*;

public class Tile {
    private Color color;
    private int x,y;

    public Tile(int x, int y) {
        color = Color.white;
        this.x = x;
        this.y = y;
    }

    public Tile(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Tile (x: " + this.x + ", y: " + this.y + ")";
    }
}
