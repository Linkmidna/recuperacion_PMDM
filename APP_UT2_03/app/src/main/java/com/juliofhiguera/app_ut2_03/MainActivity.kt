package com.juliofhiguera.app_ut2_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.juliofhiguera.app_ut2_02.R

class MainActivity : AppCompatActivity() {
    private val datos = linkedMapOf<String, Int>(
        "Iván" to R.drawable.avatar3,
        "María" to R.drawable.avatar1,
        "Rosa" to R.drawable.avatar2,
        "Pepe" to R.drawable.avatar4)

    private var contador = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val boton = findViewById<Button>(R.id.button)
        val texto = findViewById<TextView>(R.id.textView)
        val imagen = findViewById<ImageView>(R.id.imageView)

        cambiarImagen(texto,imagen)

        boton.setOnClickListener{
            cambiarImagen(texto,imagen)
        }

    }

    private fun cambiarImagen(textView: TextView, imageView: ImageView){
        contador++
        if (contador>3 || contador<0) contador=0

        textView.text = datos.keys.elementAt(contador)
        imageView.setImageResource(datos[textView.text]!!)

        Toast.makeText(this,"Ahora se muestra a ${textView.text}",Toast.LENGTH_SHORT).show()
    }
}