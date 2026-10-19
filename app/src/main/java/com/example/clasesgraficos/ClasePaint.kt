
package com.example.clasesgraficos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class ClasePaint(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var toqueX = 0f
    private var toqueY = 0f
    private var mostrarTexto = false

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            toqueX = event.x
            toqueY = event.y
            mostrarTexto = true
            invalidate()
        }
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        canvas.drawColor(Color.parseColor("#FFF3E0"))

        val pincel = Paint(Paint.ANTI_ALIAS_FLAG)

        // 1. setColor(): Establece el color del pincel
        pincel.color = Color.RED
        canvas.drawCircle(80f, 60f, 30f, pincel)

        // Mostrar las coordenadas al tocar la pantalla
        if (mostrarTexto) {
            pincel.style = Paint.Style.FILL
            pincel.textSize = 24f
            pincel.color = Color.BLACK

            canvas.drawCircle(toqueX, toqueY, 10f, pincel)

            canvas.drawText(
                "X: ${toqueX.toInt()}, Y: ${toqueY.toInt()}",
                toqueX + 15f,
                toqueY,
                pincel
            )
        }

        // 2. setStrokeWidth(): Grosor de las líneas
        pincel.color = Color.BLUE
        pincel.strokeWidth = 10f
        pincel.style = Paint.Style.STROKE
        canvas.drawLine(130f, 60f, 300f, 60f, pincel)

        pincel.color = Color.GREEN
        pincel.strokeWidth = 50f
        pincel.style = Paint.Style.STROKE
        canvas.drawLine(325f, 55f, 495f, 67f, pincel)

        // 3. setStyle(): Estilo del pincel
        pincel.style = Paint.Style.STROKE //Dibuja el contorno
        pincel.strokeWidth = 6f
        pincel.color = Color.DKGRAY
        canvas.drawRect(50f, 110f, 180f, 180f, pincel)

        pincel.style = Paint.Style.FILL // Principal
        pincel.strokeWidth = 6f
        pincel.color = Color.RED
        canvas.drawRect(350f, 111f, 428f, 175f, pincel)

       /** pincel.style = Paint.Style.FILL_AND_STROKE //Rellena y dibuja el borde
        pincel.strokeWidth = 6f
        pincel.color = Color.parseColor("#FF6F00")
        canvas.drawRect(50f, 110f, 180f, 180f, pincel)
        */


        /**
         * Nota: la transparencia se mide usando un byte de información. un byte con 8 bits puede almacenar
         * 2 elevado a la 8 = 256
         * Como en programación empezamos a contar desde el cero, los valores van del 0 al 255
         */
        // 4. setAlpha(): Transparencia
        pincel.style = Paint.Style.FILL
        pincel.color = Color.MAGENTA
        pincel.alpha = 20
        canvas.drawRect(200f, 110f, 330f, 180f, pincel)
        canvas.drawText("transparenciaaa", 61f, 994f, pincel)

        // 5. setTextSize(): Tamaño del texto
        pincel.alpha = 255
        pincel.color = Color.BLACK
        pincel.textSize = 50f
        pincel.style = Paint.Style.FILL
        canvas.drawText("5. setTextSize (50px)", 50f, 220f, pincel)

        pincel.textSize = 30f

        // 6. setTextAlign(): Alineación del texto
        pincel.textAlign = Paint.Align.CENTER
       // pincel.textAlign = Paint.Align.RIGHT
        canvas.drawText("6. setTextAlign (Centrado)", (canvas.width / 2).toFloat(), 260f, pincel)
        pincel.textAlign = Paint.Align.LEFT


        // 7. setTypeface(): Tipografías
        pincel.textSize = 28f

        pincel.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText("7. Typeface: Negrita", 50f, 310f, pincel)

        pincel.typeface = Typeface.SANS_SERIF
        canvas.drawText("7. Typeface: SANS_SERIF", 50f, 350f, pincel)

        pincel.typeface = Typeface.MONOSPACE
        canvas.drawText("7. Typeface: MONOSPACE", 50f, 390f, pincel)

        pincel.typeface = Typeface.defaultFromStyle(Typeface.ITALIC)
        canvas.drawText("7. Typeface: ITALIC", 50f, 430f, pincel)

        pincel.typeface = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC)
        canvas.drawText("7. Typeface: Negrita y Cursiva", 50f, 470f, pincel)

        // 8. setStrokeCap(): Extremos de las líneas
        pincel.typeface = Typeface.DEFAULT
        pincel.textSize = 24f
        pincel.strokeWidth = 18f

        // ROUND: Extremos redondeados
        pincel.color = Color.parseColor("#4CAF50")
        pincel.strokeCap = Paint.Cap.ROUND

        pincel.style = Paint.Style.FILL
        canvas.drawText("8. StrokeCap: ROUND", 50f, 530f, pincel)

        pincel.style = Paint.Style.STROKE
        canvas.drawLine(50f, 565f, 300f, 565f, pincel)

        // SQUARE: Extremos cuadrados
        pincel.color = Color.BLUE
        pincel.strokeCap = Paint.Cap.SQUARE

        pincel.style = Paint.Style.FILL
        canvas.drawText("StrokeCap: SQUARE", 50f, 620f, pincel)

        pincel.style = Paint.Style.STROKE
        canvas.drawLine(50f, 655f, 300f, 655f, pincel)

        // BUTT: Extremos rectos sin sobresalir
        pincel.color = Color.RED
        pincel.strokeCap = Paint.Cap.BUTT

        pincel.style = Paint.Style.FILL
        canvas.drawText("StrokeCap: BUTT", 50f, 710f, pincel)

        pincel.style = Paint.Style.STROKE
        canvas.drawLine(50f, 745f, 300f, 745f, pincel)

        // --- 9. setStrokeJoin() ---

        pincel.style = Paint.Style.STROKE
        pincel.strokeWidth = 14f
        pincel.color = Color.parseColor("#FF6F00")

        // MITER: Deja la esquina completamente recta, puntiaguda y afilada (valor por defecto)
        val pathMiter = Path().apply {
            moveTo(40f, 850f)
            lineTo(90f, 780f)
            lineTo(140f, 850f)
        }
        pincel.strokeJoin = Paint.Join.MITER // Aplica la unión en ángulo recto / puntiagudo
        canvas.drawPath(pathMiter, pincel)   // Dibuja la figura usando el path y el pincel

        pincel.style = Paint.Style.FILL
        pincel.textSize = 20f
        pincel.color = Color.BLACK
        canvas.drawText("Join: MITER", 45f, 890f, pincel)

        // ROUND: Suaviza y redondea automáticamente la esquina o vértice del trazo
        val pathRound = Path().apply {
            moveTo(210f, 850f)
            lineTo(260f, 780f)
            lineTo(310f, 850f)
        }
        pincel.style = Paint.Style.STROKE
        pincel.strokeJoin = Paint.Join.ROUND // Aplica la unión curva y redondeada en la esquina superior
        canvas.drawPath(pathRound, pincel)   // Dibuja la figura redondeada

        pincel.style = Paint.Style.FILL
        canvas.drawText("Join: ROUND", 215f, 890f, pincel)

        // BEVEL: Corta la esquina en línea recta
        val pathBevel = Path().apply {
            moveTo(380f, 850f)
            lineTo(430f, 780f)
            lineTo(480f, 850f)
        }
        pincel.style = Paint.Style.STROKE
        pincel.strokeJoin = Paint.Join.BEVEL // Aplica la unión biselada
        canvas.drawPath(pathBevel, pincel)   // Dibuja la figura con esquina achatada

        pincel.style = Paint.Style.FILL
        canvas.drawText("Join: BEVEL", 385f, 890f, pincel)

        // 10. reset(): Restablecer las propiedades del pincel
        pincel.reset()
        pincel.isAntiAlias = true
        pincel.textSize = 26f
        pincel.color = Color.BLACK
        pincel.style = Paint.Style.FILL

        canvas.drawText(
            "10. Pincel después de reset()",
            50f,
            940f,
            pincel
        )
    }
}
