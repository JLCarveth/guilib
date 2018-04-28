package com.carvethsolutions.guilib.fields;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Obscures inputted text from being visible to the user.
 * Ideal for password fields or other sensitive data entry.
 */
public class HiddenTextField extends JTextField implements KeyListener {

    /**
     * Holds the data the user enters.
     */
    private StringBuilder userInput;

    /**
     * For keeping track of backspaces
     */
    private int length;

    public HiddenTextField() {
        super(20);
        // Add password listener
        this.addKeyListener(this);
        userInput = new StringBuilder();
        length = 0;
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE && length > 0) {
            length --;
            userInput.setLength(length);
        } else {
            length ++;

            // Add the inputted char
            userInput.append(e.getKeyChar());

            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < length-1; x++) {
                sb.append("*");
            }

            // This method replaces the data, we don't want that
            // We need to store the string somewhere, but where?
            this.setText(sb.toString());
        }
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public String getText() {
        return userInput.toString();
    }

    /**
     * Used to reveal the data held by the field
     */
    public void showInput() {
        this.setText(userInput.toString());
    }

    /**
     * Used to obfuscate the user input
     */
    public void hideInput() {
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < length-1; x++) {
            sb.append('*');
        }

        this.setText(sb.toString());
    }
}
