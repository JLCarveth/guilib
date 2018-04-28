package com.carvethsolutions.guilib.util;

public class TileOutOfBoundsException extends Exception {

    public TileOutOfBoundsException(Tile tile, int size) {
        super("Tile coordinates out of bounds: " + tile.toString()
                + "\nTileMap size: " + size);
    }
}
