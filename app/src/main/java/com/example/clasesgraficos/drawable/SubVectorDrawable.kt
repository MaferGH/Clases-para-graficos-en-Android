package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.clasesgraficos.R

// VectorDrawable: dibujo definido con PUNTOS y LINEAS (en un XML),
// no con pixeles. Se ve nitido en cualquier tamaño sin perder calidad.
// Necesita el archivo res/drawable/ic_estrella.xml (viene incluido).
class SubVectorDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    // Cargamos el vector desde res/drawable
    private val vector = ContextCompat.getDrawable(context, R.drawable.ic_estrella)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Lo dibujamos grande, centrado en la vista (500x500 px)
        val tam = 500
        val izq = (width - tam) / 2
        val arriba = (height - tam) / 2
        vector?.setBounds(izq, arriba, izq + tam, arriba + tam)
        vector?.draw(canvas)
    }
}
