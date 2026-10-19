package com.example.clasesgraficos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Colors_xml(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.parseColor("#E3F2FD"))

        val pincel = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textSize = 20f
            color = Color.BLUE
        }

        val textoXml = """
            <?xml version="1.0" encoding="utf-8"?>
            <resources>
                
                <color name="black">#FF000000</color>
                <color name="white">#FFFFFFFF</color>
                <color name="colorcitorosita">#FA6C9A</color>
                
            </resources>
        """.trimIndent()

        val lineas = textoXml.split("\n")

        var x = 42f
        var y = 696f

        val espaciadoLinea = pincel.fontSpacing

        for (linea in lineas) {
            canvas.drawText(linea, x, y, pincel)
            y += espaciadoLinea
        }
    }
}