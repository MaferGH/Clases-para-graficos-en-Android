package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.util.StateSet
import android.view.View

// StateListDrawable: cambia el dibujo segun el ESTADO de la vista
// (presionado, enfocado, deshabilitado, etc).
// Aqui: rojo cuando lo tocas, morado cuando no.
class SubStateListDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    init {
        val estados = StateListDrawable()

        // Si la vista esta PRESIONADA -> rojo
        estados.addState(
            intArrayOf(android.R.attr.state_pressed),
            ColorDrawable(Color.RED)
        )

        // Cualquier otro estado (WILD_CARD) -> morado
        // OJO: el WILD_CARD siempre va al final
        estados.addState(
            StateSet.WILD_CARD,
            ColorDrawable(Color.parseColor("#6B50AA"))
        )

        background = estados

        // Para que reaccione al toque la vista debe ser clickeable
        isClickable = true
    }
}
