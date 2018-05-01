package com.carvethsolutions.guilib.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener class for the ColorPalette
 */
public interface ColorChangeListener {
    /**
     * Called whenever a new color is selected from the ColorPalette
     * @param color the new color
     */
    void colorChaned(Color color);
}
