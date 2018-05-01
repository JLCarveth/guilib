package com.carvethsolutions.guilib.component;

import javax.swing.*;

/**
 * Self-Destructing JFrame. No difference from stock JFrame other than
 * the default close operation.
 */
public class SDJFrame extends JFrame {

    public SDJFrame() {
        super("SDJFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public SDJFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
