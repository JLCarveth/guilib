package com.carvethsolutions.guilib.fields;

import com.carvethsolutions.guilib.listeners.HintListener;

import javax.swing.JTextField;

public class HintTextField extends JTextField {

    public HintTextField(String hint) {
        super(hint, 20);
        this.addFocusListener(new HintListener(hint, this));
    }
}
