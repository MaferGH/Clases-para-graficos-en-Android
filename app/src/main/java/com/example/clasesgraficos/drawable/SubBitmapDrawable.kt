package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.View
import com.example.clasesgraficos.R

// BitmapDrawable con una imagen
class SubBitmapDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val bitmapDrawable: BitmapDrawable

    init {
        // 1. Leemos la imagen de res/drawable y la convertimos en Bitmap
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.mi_imagen)

        // 2. Convertimos el Bitmap en un BitmapDrawable
        bitmapDrawable = BitmapDrawable(resources, bitmap)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // La imagen se estira para ocupar toda la vista
        bitmapDrawable.setBounds(0, 0, width, height)
        bitmapDrawable.draw(canvas)
    }
}

/**
package com.example.clasesgraficos.drawable

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Shader
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.View

// BitmapDrawable: es un Drawable que dibuja una IMAGEN (Bitmap).
// Aqui creamos un bitmap chiquito por codigo y lo repetimos (mosaico).
class SubBitmapDrawable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val bitmapDrawable: BitmapDrawable

    init {
        // 1. Creamos un bitmap de 60x60 pixeles
        val bitmap = Bitmap.createBitmap(60, 60, Bitmap.Config.ARGB_8888)

        // 2. Dibujamos en el bitmap con un Canvas
        val canvasBitmap = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.parseColor("#6B50AA")
        canvasBitmap.drawRect(0f, 0f, 30f, 30f, paint)   // cuadro morado
        paint.color = Color.parseColor("#FF4DE6")
        canvasBitmap.drawRect(30f, 30f, 60f, 60f, paint) // cuadro rosa

        // 3. Convertimos el bitmap en un BitmapDrawable
        bitmapDrawable = BitmapDrawable(resources, bitmap)

        // 4. REPEAT = repite la imagen como mosaico en X y en Y
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // El drawable ocupa todo el tamaño de la vista
        bitmapDrawable.setBounds(0, 0, width, height)
        // draw() lo pinta en el canvas
        bitmapDrawable.draw(canvas)
    }
}
*/

