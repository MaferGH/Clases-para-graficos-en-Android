package com.example.clasesgraficos

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class ClasePath(context: Context, attrs: AttributeSet?) : View(context, attrs) {

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

        canvas.drawColor(Color.parseColor("#E3F2FD"))

        val pincel = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 5f
            color = Color.BLUE
        }

        // Mostrar las coordenadas exactas al tocar la pantalla
        if (mostrarTexto) {
            val pincelTemp = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                style = Paint.Style.FILL
                textSize = 24f
                color = Color.BLACK
            }
            canvas.drawCircle(toqueX, toqueY, 10f, pincelTemp)
            canvas.drawText("X: ${toqueX.toInt()}, Y: ${toqueY.toInt()}", toqueX + 15f, toqueY, pincelTemp)
        }

        // --- 1. moveTo(x, y): Establece el punto inicial sin dibujar línea ---
        pincel.color = Color.RED
        val pathMove = Path().apply {
            moveTo(50f, 60f)   // Mueve el cursor invisible a estas coordenadas sin trazar nada
            lineTo(150f, 60f)  // Dibuja una línea recta desde ahí hasta este punto
        }
        canvas.drawPath(pathMove, pincel)

        pincel.style = Paint.Style.FILL
        pincel.textSize = 20f
        pincel.color = Color.BLACK
        canvas.drawText("1. moveTo(x, y)", 50f, 95f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 2. lineTo(x, y): Traza una línea recta desde la posición actual ---
        pincel.color = Color.BLUE
        val pathLine = Path().apply {
            moveTo(200f, 60f)
            lineTo(320f, 60f)  // Traza una línea recta continua hasta el nuevo punto
        }
        canvas.drawPath(pathLine, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("2. lineTo(x, y)", 200f, 95f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 3. close(): Cierra el recorrido uniendo con el punto inicial ---
        pincel.color = Color.GREEN
        val pathClose = Path().apply {
            moveTo(380f, 80f)
            lineTo(440f, 35f)
            lineTo(500f, 80f)
            close() // Une automáticamente el punto actual con el punto inicial del contorno
        }
        canvas.drawPath(pathClose, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("3. close()", 380f, 115f, pincel)
        pincel.style = Paint.Style.STROKE


        
        // --- 4. quadTo(x1, y1, x2, y2): Crea una curva cuadrática ---
        pincel.color = Color.parseColor("#E65100")
        val pathQuad = Path().apply {
            moveTo(50f, 160f)
            quadTo(125f, 90f, 200f, 160f) // (125,90) es el punto de control que curva el trazo, (200,160) es el punto final
        }
        canvas.drawPath(pathQuad, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("4. quadTo()", 50f, 195f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 5. cubicTo(x1, y1, x2, y2, x3, y3): Crea una curva cúbica ---
        pincel.color = Color.parseColor("#7B1FA2")
        val pathCubic = Path().apply {
            moveTo(250f, 190f)
            cubicTo(280f, 110f, 370f, 110f, 400f, 190f) // Usa dos puntos de control y un punto final
        }
        canvas.drawPath(pathCubic, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("5. cubicTo()", 250f, 220f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 6. addRect(): Agrega un rectángulo completo al recorrido ---
        pincel.color = Color.parseColor("#00796B")
        val pathRect = Path().apply {
            addRect(50f, 250f, 180f, 320f, Path.Direction.CW) // (Izquierda, arriba, derecha, abajo, dirección)
        }

        /**
         * Nota: Cuando utilizas métodos en un objeto Path para agregar figuras geométricas cerradas de golpe (como addRect, addCircle, addOval o addArc), Android te pide obligatoriamente que especifiques una dirección. Tienes dos opciones:
         * Path.Direction.CW (Clockwise): Dibuja el contorno de la figura en el sentido de las agujas del reloj.
         * Path.Direction.CCW (Counter-Clockwise): Dibuja el contorno en contra de las agujas del reloj (sentido antihorario).
         */
        canvas.drawPath(pathRect, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("6. addRect()", 50f, 350f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 7. addCircle(): Agrega un círculo al recorrido ---
        pincel.color = Color.parseColor("#C2185B")
        val pathCircle = Path().apply {
            addCircle(270f, 285f, 35f, Path.Direction.CW) // (x centro, y centro, radio, dirección)
        }
        canvas.drawPath(pathCircle, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("7. addCircle()", 230f, 350f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 8. addOval(): Agrega una forma ovalada al recorrido ---
        pincel.color = Color.parseColor("#F57C00")
        val pathOval = Path().apply {
            val rectOval = RectF(340f, 260f, 480f, 315f)
            addOval(rectOval, Path.Direction.CW) // (rectángulo delimitador, dirección)
        }
        canvas.drawPath(pathOval, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("8. addOval()", 360f, 350f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 9. addArc(): Agrega un arco al recorrido ---
        pincel.color = Color.parseColor("#388E3C")
        val pathArc = Path().apply {
            val rectArc = RectF(50f, 390f, 180f, 470f)
            addArc(rectArc, 0f, 180f) // (rectángulo, ángulo inicial, ángulo de barrido)
        }
        canvas.drawPath(pathArc, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("9. addArc()", 50f, 490f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 10. rewind(): Limpia el recorrido conservando el almacenamiento interno ---
        pincel.color = Color.parseColor("#512DA8")
        val pathRewind = Path().apply {
            moveTo(220f, 430f)
            lineTo(300f, 390f)
           rewind() // Limpia los puntos anteriores pero optimiza memoria para reutilizar
            moveTo(305f, 419f)
            lineTo(228f, 451f) // Nuevo trazo dibujado después del rewind
        }
        canvas.drawPath(pathRewind, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("10. rewind()", 220f, 490f, pincel)
        pincel.style = Paint.Style.STROKE

        // --- 11. reset(): Borra por completo los puntos y segmentos del recorrido ---
        pincel.color = Color.parseColor("#D32F2F")
        val pathReset = Path().apply {
            moveTo(360f, 430f)
            lineTo(440f, 390f)
            reset() // Borra puntos y segmentos por completo para reutilizar el objeto
            moveTo(360f, 430f)
            lineTo(440f, 450f) // Nuevo trazo después del reset
        }
        canvas.drawPath(pathReset, pincel)

        pincel.style = Paint.Style.FILL
        canvas.drawText("11. reset()", 360f, 490f, pincel)
    }
}