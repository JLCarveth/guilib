package com.carvethsolutions.guilib.util;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TileMap manages data about a 2D-array
 */
public class TileMap implements Iterable<Tile> {

    private Tile[][] data;

    private int size;

    /**
     * Class variables for determining what tiles are considered adjacent
     */
    public static final String EIGHT_WAY_DIRECTIONAL = "8";

    public static final String FOUR_WAY_DIRECTIONAL = "4";

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

    /**
     * Will return all tiles adjacent to the given tile. By default, any tile directly beside or diagonal to the
     * tile is considered adjacent. So the maximum output list-size will be 8
     * @param tile the given tile who's neighbors will be fetched
     * @return the list of all adjacent tiles.
     * @throw TileOutOfBoundsException
     */
    public ArrayList<Tile> getAdjacentTiles(Tile tile) {
        return new ArrayList<Tile>();
    }

    /**
     *  Will return all tiles adjacent to the given tile.
     * @param tile the tile contained within the TileMap
     * @param direction one of the directional global variables EIGHT_WAY_DIRECTIONAL or FOUR_WAY_DIRECTIONAL
     * @return the list of all adjacent tiles
     */
    public ArrayList<Tile> getAdjacentTiles(Tile tile, String direction) {
        return new ArrayList<Tile>();
    }
}
