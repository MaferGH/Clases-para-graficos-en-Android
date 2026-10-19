package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.View

// GradientDrawable: dibuja una forma (rectangulo, ovalo...)
// con un color solido o con DEGRADADO.
class SubGradientDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    init {
        // Degradado de arriba hacia abajo con 3 colores
        val degradado = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.parseColor("#FF0000"), // rojo
                Color.parseColor("#FFED00"), // amarillo
                Color.parseColor("#4CAF50")  // verde
            )
        )

        // Esquinas redondeadas (en pixeles)
        degradado.cornerRadius = 60f

        // Borde: grosor 8px, color morado
        degradado.setStroke(8, Color.parseColor("#6B50AA"))

        background = degradado
    }
}
