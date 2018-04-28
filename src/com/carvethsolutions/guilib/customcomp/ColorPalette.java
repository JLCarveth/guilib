package com.carvethsolutions.guilib.customcomp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A custom component to represent a color palette.
 * The user can customize the number of colors shown by the palette,
 * the orientation, and number of rows
 */
public class ColorPalette extends JPanel {

    private static final ArrayList<Color> colors =  new ArrayList<Color>(
            Arrays.asList(Color.RED,
                    Color.blue,
                    Color.green,
                    Color.yellow,
                    Color.orange,
                    Color.magenta,
                    Color.pink,
                    Color.gray,
                    Color.white,
                    Color.black)
    );

    /**
     * Global variables for controlling the orientation of the component
     */
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;

    private int rowCount;

    private int colorCount = colors.size();

    private int orientation;

    /**
     * Constructor
     * @param rows number of rows in which to render the colors
     * @param orientation VERTICAL or HORIZONTAL
     * @param colorCount the number of colors to display.
     */
    public ColorPalette(int rows, int orientation, int colorCount) {
        super();
        rowCount = rows;
        this.orientation = orientation;
        this.colorCount = colorCount;

        if (orientation == VERTICAL) {
            this.setLayout(new GridLayout(rows, colorCount / rows));
            //this.setPreferredSize(new Dimension((colorCount / rows) * 50, rows * 50));
        } else {
            this.setLayout(new GridLayout(colorCount / rows, rows));
            //this.setPreferredSize(new Dimension((colorCount / rows) * 50, rows * 50));
        }

        for (int x = 0; x < colorCount; x++) {
            JPanel panel = new JPanel();
            JPanel fl = new JPanel();

            panel.setBackground(colors.get(x));
            panel.setPreferredSize(new Dimension(30,30));
            panel.setBorder(BorderFactory.createLoweredBevelBorder());

            fl.setLayout(new FlowLayout());
            fl.add(panel);
            this.add(fl);
        }

        this.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    /**
     * Constructor with default values
     */
    public ColorPalette() {
        this(2, HORIZONTAL, 10);
    }
}
