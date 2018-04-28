package com.carvethsolutions.guilib.customcomp;

import com.carvethsolutions.guilib.util.Tile;
import com.carvethsolutions.guilib.util.TileMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

/**
 * A custom component for displaying a grid
 */
public class GridCanvas extends JPanel implements MouseListener {

    /**
     * Width and height of the canvas, in pixels
     */
    private int width, height;

    /**
     * How many pixels represent one square on the grid
     */
    private int gridScale;

    /**
     * Why are making useful comments so hard?
     *
     * Tilemap holds all the drawing data about the canvas (colors and where to put them)
     */
    private TileMap tilemap;

    private boolean gridLinesVisible = true;

    /**
     * Holds color selections
     */
    private Paintbrush paintbrush;

    public GridCanvas() {
        super();
        width = 500;
        height = 500;

        setupComponent();
    }

    public GridCanvas(int width, int height) {
        super();
        this.width = width;
        this.height = height;

        setupComponent();
    }

    /**
     * Private function to prepare the component.
     */
    private void setupComponent() {
        gridScale = 50;
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.WHITE);

        this.addMouseListener(this);

        paintbrush = new Paintbrush(Color.black);

        tilemap = new TileMap(width / gridScale);
    }

    /**
     * Enable or disable grid lines from appearing on the Canvas
     */
    public void toggleGridlines() {
        gridLinesVisible = !gridLinesVisible;
    }

    @Override
    public void paintComponent(Graphics g) {
        // Called whenever the JPanel is being painted
        // Here we need to get the data from tilemap and paint it
        Iterator<Tile> iterator = tilemap.iterator();
        while (iterator.hasNext()) {
            Tile tile = iterator.next();
            if (tile != null) {
                System.out.println(tile);
                g.setColor(paintbrush.getColor());
                g.fillRect(tile.getX() * gridScale, tile.getY() * gridScale, gridScale, gridScale);
            }
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / gridScale;
        int y = e.getY() / gridScale;

        System.out.println("mouseClicked Event : (" + x + ", " + y + ")");
        tilemap.placeTile(paintbrush.getColor(), x, y);
        repaint();
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
