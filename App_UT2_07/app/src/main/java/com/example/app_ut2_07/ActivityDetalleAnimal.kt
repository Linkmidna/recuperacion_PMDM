package com.example.app_ut2_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        imagenAnimal.setImageResource(animal.imagenId)
        nombreAnimal.text = animal.nombre
        descripcionAnimal.text = animal.descripcion
    }
}