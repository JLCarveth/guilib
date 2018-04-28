package com.carvethsolutions.guilib.customcomp;

import com.carvethsolutions.guilib.util.Tile;
import com.carvethsolutions.guilib.util.TileMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A custom component for displaying a grid
 */
public class GridCanvas extends JPanel implements MouseListener, MouseMotionListener {

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
     * A list that keeps track of tiles during a mouse drag
     */
    private ArrayList<Tile> dragData;

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
        this.addMouseMotionListener(this);

        paintbrush = new Paintbrush(Color.blue);

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

        g.setColor(Color.black);
        if (gridLinesVisible) {
            // Vertical Lines
            for (int x=0; x <= width; x += gridScale) {
                g.drawLine(x, 0, x, height);
            }

            for (int y=0; y <= height; y += gridScale) {
                g.drawLine(0, y, width, y);
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
        startDrag();
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        stopDrag();
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

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX() / gridScale;
        int y = e.getY() / gridScale;

        Tile tile = new Tile(x,y);

        System.out.println("(x: " + x + ", y: " + y + ")");


        if (!dragData.contains(tile)) {
            //dragData.add(tile);
            tilemap.placeTile(paintbrush.getColor(), tile.getX(), tile.getY());
            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) { }

    private void startDrag() {
        dragData = new ArrayList<Tile>();
    }

    private void stopDrag() {
        for (Tile t : dragData) {
            tilemap.placeTile(paintbrush.getColor(), t.getX(), t.getY());
        }

        repaint();

        dragData = null;
    }
}
