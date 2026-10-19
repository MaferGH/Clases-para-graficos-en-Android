package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import android.view.View

// LayerDrawable: junta VARIOS drawables apilados como capas.
// La primera capa queda hasta abajo y la ultima hasta arriba.
class SubLayerDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    init {
        // Capa 0 (fondo): rectangulo gris
        val capaFondo = GradientDrawable()
        capaFondo.setColor(Color.LTGRAY)

        // Capa 1: circulo morado
        val capaCirculo = GradientDrawable()
        capaCirculo.shape = GradientDrawable.OVAL
        capaCirculo.setColor(Color.parseColor("#6B50AA"))

        // Capa 2: circulo rosa mas chico
        val capaCirculoChico = GradientDrawable()
        capaCirculoChico.shape = GradientDrawable.OVAL
        capaCirculoChico.setColor(Color.parseColor("#FF4DE6"))

        // Juntamos las capas en un LayerDrawable
        val layer = LayerDrawable(arrayOf(capaFondo, capaCirculo, capaCirculoChico))

        // setLayerInset(capa, izq, arriba, der, abajo) -> margen en pixeles
        layer.setLayerInset(1, 60, 60, 60, 60)    // circulo morado
        layer.setLayerInset(2, 200, 200, 200, 200) // circulo rosa (mas chico)

        // Lo usamos como fondo de la vista
        background = layer
    }
}
