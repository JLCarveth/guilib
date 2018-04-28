package com.carvethsolutions.guilib.customcomp;

import java.awt.*;

/**
 * Holds data for making drawings on a canvas
 */
public class Paintbrush {

    private Color color;

    public Paintbrush(Color color) {
        this.color = color;
    }

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }
}
