package com.carvethsolutions.guilib.component;

import com.carvethsolutions.guilib.listener.HintListener;

import javax.swing.*;

public class HintTextField extends JTextField {

    private String hint;

    public HintTextField(String hint) {
        super(hint);
        this.hint = hint;

        this.addFocusListener(new HintListener(hint, this));
    }
}
