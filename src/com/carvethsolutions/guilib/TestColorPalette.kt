package com.carvethsolutions.guilib

import com.carvethsolutions.guilib.customcomp.ColorPalette

fun main(args : Array<String>) {
    val frame = ClosableJFrame();
    frame.add(ColorPalette(3, ColorPalette.HORIZONTAL, 10))
    frame.pack()
    frame.show()
}