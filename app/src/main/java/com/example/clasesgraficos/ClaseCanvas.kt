package com.example.clasesgraficos

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class ClaseCanvas(context: Context, attrs: AttributeSet?) : View(context, attrs) { // Creamos nuestra propia vista llamada ClaseCanvas

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(Color.YELLOW)

        /**
         * Creamos el pincel activando Anti-Alias desde el inicio
         * Es una configuración para suavizar los bordes de los dibujos y textos en el Canvas, evitando que se vean pixelados
         */
        val pincel = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.RED
            textSize = 35f
        }

        // --- save() ---
        // save() guarda el estado actual del lienzo
        canvas.save()

        pincel.color = Color.GRAY
        pincel.strokeWidth = 2f
        canvas.drawLine(0f, 0f, 500f, 0f, pincel)
        canvas.drawLine(0f, 0f, 0f, 500f, pincel)
        pincel.textSize = 25f
        canvas.drawText("(0,0) Original", 10f, 30f, pincel)

        // 2. Movemos el sistema de coordenadas 20 píxeles a la derecha y abajo
        canvas.translate(20f, 20f)
        canvas.scale(1.0f, 1.0f)

        // --- SEGUNDO PLANO CARTESIANO (Para ver el nuevo (0,0) movido) ---
        pincel.color = Color.RED // Lo ponemos rojo para distinguirlo
        canvas.drawLine(0f, 0f, 400f, 0f, pincel)
        canvas.drawLine(0f, 0f, 0f, 400f, pincel)
        canvas.drawText("(0,0) Nuevo tras Translate", 10f, 30f, pincel)



        // --- drawCircle(): Dibuja un círculo ---
        canvas.drawCircle(100f, 100f, 50f, pincel)

        // --- drawRect(): Dibuja un rectángulo ---
        pincel.color = Color.BLUE
        canvas.drawRect(200f, 50f, 350f, 150f, pincel)

        // --- drawOval(): Dibuja un óvalo ---
        pincel.color = Color.MAGENTA
        canvas.drawOval(400f, 50f, 550f, 130f, pincel)

        // --- drawLine(): Dibuja una línea ---
        pincel.color = Color.BLACK
        pincel.strokeWidth = 5f
        canvas.drawLine(50f, 200f, 350f, 200f, pincel)

        // --- drawArc(): Dibuja un arco ---
        pincel.color = Color.DKGRAY
        canvas.drawArc(50f, 220f, 150f, 320f, 0f, 180f, true, pincel)

        // --- drawPath(): Dibuja una figura o trazo definido mediante Path ---
        pincel.color = Color.GREEN
        val path = Path().apply {
            moveTo(200f, 280f)
            lineTo(250f, 350f)
            lineTo(150f, 350f)
            close() // Cierra la figura para formar un triángulo
        }
        canvas.drawPath(path, pincel)

        // --- rotate(): Gira el sistema de coordenadas ---
        canvas.save() // Guardamos antes de rotar para no afectar lo demás
        canvas.translate(300f, 250f)
        canvas.rotate(45f) // Gira 45 grados
        pincel.color = Color.CYAN
        canvas.drawRect(0f, 0f, 80f, 80f, pincel)
        canvas.restore() // Restauramos el giro

        // --- drawText(): Dibuja un texto ---
        pincel.color = Color.BLACK
        pincel.textSize = 40f
        pincel.strokeWidth = 1f
        canvas.drawText("Hola Canvas completo", 50f, 420f, pincel)

        // --- drawBitmap(): Dibuja una imagen tipo Bitmap redimensionada ---
//        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.mi_imagen)
//        if (bitmap != null) {
//            // Creamos un rectángulo donde queremos que quepa (izquierda, arriba, derecha, abajo)
//            val destino = android.graphics.Rect(50,50,550,550)
//            canvas.drawBitmap(bitmap, null, destino, pincel)
//        }


        // restore() recupera el estado guardado previamente al inicio con save()
       canvas.restore()
    }
}