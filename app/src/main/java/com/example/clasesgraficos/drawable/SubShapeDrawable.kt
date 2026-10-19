package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.util.AttributeSet
import android.view.View

// ShapeDrawable: dibuja una forma geometrica (Rect, Oval, etc.) POR CODIGO.
// Se le pone un color con su "paint" y se dibuja en el canvas.
class SubShapeDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    // Un rectangulo morado
    private val rectangulo = ShapeDrawable(RectShape()).apply {
        paint.color = Color.parseColor("#6B50AA")
    }

    // Un ovalo rosa
    private val ovalo = ShapeDrawable(OvalShape()).apply {
        paint.color = Color.parseColor("#FF4DE6")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // setBounds(izq, arriba, der, abajo) = donde se dibuja y que tamaño tiene
        rectangulo.setBounds(100, 100, 600, 400)
        rectangulo.draw(canvas)

        ovalo.setBounds(100, 500, 600, 800)
        ovalo.draw(canvas)
    }
}
