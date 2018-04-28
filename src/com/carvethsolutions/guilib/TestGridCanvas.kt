package com.carvethsolutions.guilib

import com.carvethsolutions.guilib.customcomp.GridCanvas
import javax.swing.JFrame

fun main(args : Array<String>) {
    val gc = GridCanvas(1000,1000)

    val frame = ClosableJFrame("GridCanvas test")
    frame.add(gc)
    frame.pack()
    frame.show()
}