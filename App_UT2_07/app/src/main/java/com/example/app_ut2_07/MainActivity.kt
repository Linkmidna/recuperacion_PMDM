package com.example.app_ut2_07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_07.datos.Animal
import com.example.app_ut2_07.modelo.AnimalAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewAnimales: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewAnimales = findViewById<RecyclerView>(R.id.recyclerViewAnimales)
        recyclerViewAnimales.adapter = AnimalAdapter() {animal -> onClickAnimal(animal)}
        recyclerViewAnimales.layoutManager = LinearLayoutManager(this)

        recyclerViewAnimales.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        val botonAnadir = findViewById<FloatingActionButton>(R.id.boton_anadir)
        botonAnadir.setOnClickListener {
            dialogoNuevoAnimal()
        }

    }
    private fun onClickAnimal(animal: Animal)
    {
        //Toast.makeText(this, animal.descripcion, Toast.LENGTH_LONG).show()
        val intent = Intent(applicationContext, ActivityDetalleAnimal::class.java)
        intent.putExtra("animal", animal)
        startActivity(intent)

    }

    private fun dialogoNuevoAnimal()
    {
        val inputEditTextField = EditText(this)
        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle("Nuevo animal")
            .setMessage("Introduce el nombre de un nuevo animal")
            .setView(inputEditTextField)
            .setPositiveButton("Añadir") { _, _ ->
                val nuevoAnimal = Animal(
                    inputEditTextField .text.toString(),
                    R.drawable.desconocido,
                    "",
                    10
                )
                (recyclerViewAnimales.adapter as AnimalAdapter).addAnimal(nuevoAnimal)
            }
            .setNegativeButton("Cancelar", null)
            .create()
        dialog.show()
    }



}