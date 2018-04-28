package com.carvethsolutions.guilib.util;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TileMap manages data about a 2D-array
 */
public class TileMap implements Iterable<Tile> {

    private Tile[][] data;

    private int size;

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @NotNull
    @Override
    public Iterator<Tile> iterator() {
        return new TileMapIterator();
    }

    private class TileMapIterator implements Iterator<Tile> {

        private int currentRow, currentColumn;

        public TileMapIterator() {
            currentRow = currentColumn = 0;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentRow != size - 1 || currentColumn != size - 1;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Tile next() {
            Tile tile = new Tile(-99,-99);
            try {
                tile = data[currentRow][currentColumn];

                if (currentColumn == size - 1) {
                    currentColumn = 0;
                    currentRow++;
                } else {
                    currentColumn++;
                }

            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }

            return tile;
        }
    }

    public TileMap(int size) {
        this.size = size;
        data = new Tile[size][size];
    }

    public void placeTile(Color color, int x, int y) {
        System.out.println("placeTile(" + x + ", " + y + ")");
        data[y][x] = new Tile(color, x, y);
    }
}
