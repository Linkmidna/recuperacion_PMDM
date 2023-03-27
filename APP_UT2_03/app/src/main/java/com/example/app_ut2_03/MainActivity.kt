package com.example.app_ut2_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contar = findViewById<Button>(R.id.contar)
        val mostrar = findViewById<Button>(R.id.mostrar)
        val resultado = findViewById<TextView>(R.id.resultado)

        resultado.text=contador.toString()

        contar.setOnClickListener{
            contador++
            resultado.text=contador.toString()
        }
        mostrar.setOnClickListener{
            contador++
            resultado.text=contador.toString()
            Toast.makeText(this,"Has pulsado el boton $contador veces.",Toast.LENGTH_SHORT).show()
        }

    }
}