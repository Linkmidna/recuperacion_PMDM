package com.example.app_ut2_04

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.opcionViaje)

        val switch = findViewById<Switch>(R.id.switch_iva)

        radioGroup.setOnCheckedChangeListener { radioGroup, opcion ->
            establecerPrecio(opcion, switch.isChecked)
            modificarImagen(opcion)
        }

        switch.setOnCheckedChangeListener { compoundButton, b ->
            establecerPrecio(radioGroup.checkedRadioButtonId,
                switch.isChecked)
        }
    }


    private fun establecerPrecio(radioButtonId: Int, iva: Boolean)
    {
        val textViewPrecioFinal = findViewById<TextView>(R.id.precio_final)
        val precio = calcularPrecio(radioButtonId, iva)
        textViewPrecioFinal.text = "${String.format("%.2f", precio)} €"

        //Cambiar color en función del precio
        val presupuestoEditText = findViewById<EditText>(R.id.presupuesto)
        val presupuesto = presupuestoEditText.text.toString().toDoubleOrNull()

        if (presupuesto != null) {
            if(presupuesto>precio)
                textViewPrecioFinal.setTextColor(getColor(R.color.verde))
            else
                textViewPrecioFinal.setTextColor(getColor(R.color.rojo))
        }


    }

    private fun calcularPrecio(radioButtonId: Int, iva: Boolean): Double
    {
        var precio: Double = when(radioButtonId)
        {
            R.id.opcion_peninsula -> 600.0
            R.id.opcion_islas -> 900.0
            else -> 520.0
        }
        if(iva)
            precio *= 1.21

        return precio
    }

    private fun modificarImagen(radioButtonId: Int)
    {
        val imagen = findViewById<ImageView>(R.id.imagen)
        if (radioButtonId == R.id.opcion_peninsula) {
            imagen.setImageResource(R.drawable.costa_peninsular)
        }
        else if (radioButtonId == R.id.opcion_islas) {
            imagen.setImageResource(R.drawable.costa_insular)
        }
        else{
            imagen.setImageResource(R.drawable.turismo_interior)
        }

    }
}