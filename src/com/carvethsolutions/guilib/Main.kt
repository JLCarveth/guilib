package com.carvethsolutions.guilib

import com.carvethsolutions.guilib.customcomp.TodoList
import com.carvethsolutions.guilib.fields.HiddenTextField
import com.carvethsolutions.guilib.fields.HintTextField
import com.carvethsolutions.guilib.fields.ToggleHiddenTextField
import java.awt.GridLayout
import javax.swing.*

fun main(args : Array<String>) {
    val panel = JPanel()
    panel.layout = GridLayout(5,2)

    panel.add(JLabel("HintTextField: "))
    panel.add(HintTextField("John"))

    panel.add(JLabel("JTextField"))
    panel.add(JTextField("John"))

    panel.add(JLabel("HiddenTextField"))
    val h = HiddenTextField()
    h.addActionListener {
        println(h.text)
    }
    panel.add(h)

    panel.add(JLabel("ToggleHiddenTextField"))
    panel.add(ToggleHiddenTextField());

    val todo = TodoList(arrayListOf("Mow the lawn.","Weed the garden.", "Clean the bathroom."))
    todo.assignActionListener({
        val cb = it.source as JCheckBox
        println("Todo Trigger: ${cb.text}")
        println("Checkbox Status: ${cb.isSelected}")
    })
    panel.add(todo)

    val frame = JFrame()

    frame.add(panel)
    frame.pack()
    frame.show()
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}
