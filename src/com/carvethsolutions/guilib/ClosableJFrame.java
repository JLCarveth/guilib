package com.carvethsolutions.guilib;

import javax.swing.*;

/**
 * Very simple change to the JFrame class to enable EXIT_ON_CLOSE behaviour by default
 *
 * @author John L. Carveth - 2018/04/28
 */
public class ClosableJFrame extends JFrame {

    public ClosableJFrame() {
        super("Closable JFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public ClosableJFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
