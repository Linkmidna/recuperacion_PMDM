package com.example.app_ut2_07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.app_ut2_07.datos.Animal

class ActivityDetalleAnimal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_animal)
        val animal = intent.extras?.get("animal") as Animal

        val imagenAnimal = findViewById<ImageView>(R.id.imageViewDetalle)
        val nombreAnimal = findViewById<TextView>(R.id.textViewNombreDetalle)
        val descripcionAnimal = findViewById<TextView>(R.id.textViewDescripcionDetalle)
        val botonPositivo = findViewById<Button>(R.id.buttonSumarVoto)
        val botonNegativo = findViewById<Button>(R.id.buttonRestarVoto)

        imagenAnimal.setImageResource(animal.imagenId)
        nombreAnimal.text = animal.nombre
        descripcionAnimal.text = animal.descripcion

        botonPositivo.setOnClickListener {
            crearIntentAMain(animal, 1)
        }
        botonNegativo.setOnClickListener {
            crearIntentAMain(animal, -1)
        }
    }

    fun crearIntentAMain(animal: Animal, voto: Int)
    {
        val intentDevuelto = Intent()
        intentDevuelto.putExtra("voto", voto)
        intentDevuelto.putExtra("animal", animal.nombre)
        setResult(RESULT_OK, intentDevuelto)
        finish()
    }

}