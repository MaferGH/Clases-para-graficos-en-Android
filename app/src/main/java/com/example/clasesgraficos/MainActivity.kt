
package com.example.clasesgraficos

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuBotones = findViewById<View>(R.id.menuBotones)
        val paginaCanvas = findViewById<View>(R.id.paginaCanvas)
        val paginaPaint = findViewById<View>(R.id.paginaPaint)
        val paginaPath = findViewById<View>(R.id.paginaPath)
        val paginaDrawable = findViewById<View>(R.id.paginaDrawable)
        val paginaColorsXML = findViewById<View>(R.id.paginaColorsXML)

        val btnCanvas = findViewById<Button>(R.id.btnCanvas)
        val btnPaint = findViewById<Button>(R.id.btnPaint)
        val btnPath = findViewById<Button>(R.id.btnPath)
        val btnDrawable = findViewById<Button>(R.id.btnDrawable)
        val btnColorsXML = findViewById<Button>(R.id.btnColorsXML)

        val btnVolverCanvas =
            findViewById<Button>(R.id.btnVolverCanvas)

        val btnVolverPaint =
            findViewById<Button>(R.id.btnVolverPaint)

        val btnVolverPath=
            findViewById<Button>(R.id.btnVolverPath)

        val btnVolverDrawable=
            findViewById<Button>(R.id.btnVolverDrawable)

        val btnVolverColorsXML=
            findViewById<Button>(R.id.btnVolverColorsXML)

        btnCanvas.setOnClickListener {
            menuBotones.visibility = View.GONE
            paginaCanvas.visibility = View.VISIBLE
        }

        btnPaint.setOnClickListener {
            menuBotones.visibility = View.GONE
            paginaPaint.visibility = View.VISIBLE
        }

        btnPath.setOnClickListener {
            menuBotones.visibility = View.GONE
            paginaPath.visibility = View.VISIBLE
        }

        btnDrawable.setOnClickListener {
            menuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
        }

        btnColorsXML.setOnClickListener {
            menuBotones.visibility = View.GONE
            paginaColorsXML.visibility = View.VISIBLE
        }


        btnVolverCanvas.setOnClickListener {
            paginaCanvas.visibility = View.GONE
            menuBotones.visibility = View.VISIBLE
        }

        btnVolverPaint.setOnClickListener {
            paginaPaint.visibility = View.GONE
            menuBotones.visibility = View.VISIBLE
        }

        btnVolverPath.setOnClickListener {
            paginaPath.visibility = View.GONE
            menuBotones.visibility = View.VISIBLE
        }

        btnVolverDrawable.setOnClickListener {
            paginaDrawable.visibility = View.GONE
            menuBotones.visibility = View.VISIBLE
        }

        btnVolverColorsXML.setOnClickListener {
            paginaColorsXML.visibility = View.GONE
            menuBotones.visibility = View.VISIBLE
        }

//        ------------------SUBMENU DE DRAWABLE ----------------------

        val submenuBotones = findViewById<View>(R.id.submenuBotones)
        val paginaBitmapDrawable = findViewById<View>(R.id.paginaBitmapDrawable)
        val paginaVectorDrawable = findViewById<View>(R.id.paginaVectorDrawable)
        val paginaLayerDrawable = findViewById<View>(R.id.paginaLayerDrawable)
        val paginaStateListDrawable = findViewById<View>(R.id.paginaStateListDrawable)
        val paginaGradientDrawable= findViewById<View>(R.id.paginaGradientDrawable)
        val paginaTransitionDrawable= findViewById<View>(R.id.paginaTransitionDrawable)
        val paginaShapeDrawable = findViewById<View>(R.id.paginaShapeDrawable)
        val paginaAnimationDrawable = findViewById<View>(R.id.paginaAnimationDrawable)


        val btnBitmapDrawable = findViewById<Button>(R.id.btnBitmapDrawable)
        val btnVectorDrawable = findViewById<Button>(R.id.btnVectorDrawable)
        val btnLayerDrawable = findViewById<Button>(R.id.btnLayerDrawable)
        val btnStateListDrawable = findViewById<Button>(R.id.btnStateListDrawable)
        val btnGradientDrawable = findViewById<Button>(R.id.btnGradientDrawable)
        val btnTransitionDrawable = findViewById<Button>(R.id.btnTransitionDrawable)
        val btnShapeDrawable = findViewById<Button>(R.id.btnShapeDrawable)
        val btnAnimationDrawable = findViewById<Button>(R.id.btnAnimationDrawable)


        val btnVolverBitmapDrawable =
            findViewById<Button>(R.id.btnVolverBitmapDrawable)
        val btnVolverVectorDrawable =
            findViewById<Button>(R.id.btnVolverVectorDrawable)
        val btnVolverLayerDrawable =
            findViewById<Button>(R.id.btnVolverLayerDrawable)
        val btnVolverStateListDrawable =
            findViewById<Button>(R.id.btnVolverStateListDrawable)
        val btnVolverGradientDrawable =
            findViewById<Button>(R.id.btnVolverGradientDrawable)
        val btnVolverTransitionDrawable =
            findViewById<Button>(R.id.btnVolverTransitionDrawable)
        val btnVolverShapeDrawable =
            findViewById<Button>(R.id.btnVolverShapeDrawable)
        val btnVolverAnimationDrawable =
            findViewById<Button>(R.id.btnVolverAnimationDrawable)

        btnBitmapDrawable.setOnClickListener {
            submenuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.GONE
            paginaBitmapDrawable.visibility = View.VISIBLE
        }

        btnVectorDrawable.setOnClickListener {
            submenuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.GONE
            paginaVectorDrawable.visibility = View.VISIBLE
        }

        btnLayerDrawable.setOnClickListener {
            submenuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.GONE
            paginaLayerDrawable.visibility = View.VISIBLE
        }

        btnStateListDrawable.setOnClickListener {
            submenuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.GONE
            paginaStateListDrawable.visibility = View.VISIBLE
        }

        btnGradientDrawable.setOnClickListener {
            submenuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.GONE
            paginaGradientDrawable.visibility = View.VISIBLE
        }

        btnTransitionDrawable.setOnClickListener {
            submenuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.GONE
            paginaTransitionDrawable.visibility = View.VISIBLE
        }

        btnShapeDrawable.setOnClickListener {
            submenuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.GONE
            paginaShapeDrawable.visibility = View.VISIBLE
        }

        btnAnimationDrawable.setOnClickListener {
            submenuBotones.visibility = View.GONE
            paginaDrawable.visibility = View.GONE
            paginaAnimationDrawable.visibility = View.VISIBLE
        }

        btnVolverBitmapDrawable.setOnClickListener {
            paginaBitmapDrawable.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
            submenuBotones.visibility = View.VISIBLE
        }

        btnVolverVectorDrawable.setOnClickListener {
            paginaVectorDrawable.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
            submenuBotones.visibility = View.VISIBLE
        }

        btnVolverLayerDrawable.setOnClickListener {
            paginaLayerDrawable.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
            submenuBotones.visibility = View.VISIBLE
        }

        btnVolverStateListDrawable.setOnClickListener {
            paginaStateListDrawable.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
            submenuBotones.visibility = View.VISIBLE
        }

        btnVolverGradientDrawable.setOnClickListener {
            paginaGradientDrawable.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
            submenuBotones.visibility = View.VISIBLE
        }

        btnVolverTransitionDrawable.setOnClickListener {
            paginaTransitionDrawable.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
            submenuBotones.visibility = View.VISIBLE
        }

        btnVolverShapeDrawable.setOnClickListener {
            paginaShapeDrawable.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
            submenuBotones.visibility = View.VISIBLE
        }

        btnVolverAnimationDrawable.setOnClickListener {
            paginaAnimationDrawable.visibility = View.GONE
            paginaDrawable.visibility = View.VISIBLE
            submenuBotones.visibility = View.VISIBLE
        }
    }
}
