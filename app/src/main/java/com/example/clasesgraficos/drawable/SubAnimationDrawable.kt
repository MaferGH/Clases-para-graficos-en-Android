package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.View

// AnimationDrawable: animacion cuadro por cuadro (como un gif).
// Aqui cada "cuadro" es un color distinto que cambia cada 500 ms.
class SubAnimationDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val animacion = AnimationDrawable()

    init {
        // addFrame(drawable, duracion en milisegundos)
        animacion.addFrame(ColorDrawable(Color.RED), 500)
        animacion.addFrame(ColorDrawable(Color.YELLOW), 500)
        animacion.addFrame(ColorDrawable(Color.GREEN), 500)
        animacion.addFrame(ColorDrawable(Color.BLUE), 500)

        // true = solo una vez, false = se repite infinito
        animacion.isOneShot = false

        background = animacion
    }

    // Cuando la vista aparece en pantalla, arrancamos la animacion
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animacion.start()
    }

    // Cuando se quita de la pantalla, la paramos para no gastar bateria
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animacion.stop()
    }
}
