package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.util.AttributeSet
import android.view.View

// TransitionDrawable: hace una transicion suave (fade) entre 2 drawables.
// Toca la vista para cambiar de un color al otro.
class SubTransitionDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val transicion: TransitionDrawable
    private var estaEnSegundo = false

    init {
        // Solo acepta exactamente 2 drawables: el inicial y el final
        val capas: Array<Drawable> = arrayOf(
            ColorDrawable(Color.parseColor("#6B50AA")), // morado
            ColorDrawable(Color.parseColor("#FF4DE6"))  // rosa
        )
        transicion = TransitionDrawable(capas)
        background = transicion

        // Al tocar, hacemos la transicion
        setOnClickListener {
            if (!estaEnSegundo) {
                transicion.startTransition(1000)   // morado -> rosa en 1 segundo
            } else {
                transicion.reverseTransition(1000) // rosa -> morado en 1 segundo
            }
            estaEnSegundo = !estaEnSegundo
        }
    }
}
