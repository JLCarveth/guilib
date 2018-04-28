package com.carvethsolutions.guilib.listeners;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class HintListener implements FocusListener {

    private String hint;

    private JTextField subject;

    public HintListener(String hint, JTextField subject) {
        this.hint = hint;
        this.subject = subject;
    }

    /**
     * Invoked when a component gains the keyboard focus.
     *
     * @param e
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (subject.getText().equals(hint)) {
            subject.setText("");
        }
    }

    /**
     * Invoked when a component loses the keyboard focus.
     *
     * @param e
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (subject.getText().trim().equals("")) {
            subject.setText(hint);
        }
    }
}
