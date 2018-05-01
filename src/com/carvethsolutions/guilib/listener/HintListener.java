package com.carvethsolutions.guilib.listener;

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

    @Override
    public void focusGained(FocusEvent e) {
        if (subject.getText().equals(hint)) {
            subject.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (subject.getText().equals("")) {
            subject.setText(hint);
        }
    }
}
