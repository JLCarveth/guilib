package com.carvethsolutions.guilib

import com.carvethsolutions.guilib.component.HintTextField
import com.carvethsolutions.guilib.component.SDJFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

fun main(args : Array<String>) {
    val frame = SDJFrame()
    val panel = JPanel()

    panel.add(JLabel("Test Window"))
    panel.add(JTextField(20))
    panel.add(HintTextField("Hint..."))

    frame.add(panel)
    frame.pack()
    frame.show()
}
