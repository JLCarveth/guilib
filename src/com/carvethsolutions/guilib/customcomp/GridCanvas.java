package com.carvethsolutions.guilib.customcomp;

import javax.swing.*;
import java.awt.*;

/**
 * A custom component for displaying a grid
 */
public class GridCanvas extends JPanel {

    private int width, height;

    private boolean gridLinesVisible = false;

    public GridCanvas() {
        super();
        width = 500;
        height = 500;
        this.setPreferredSize(new Dimension(width,height));

    }
}
