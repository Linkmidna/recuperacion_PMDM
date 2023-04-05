package com.example.app_ut2_07.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_ut2_07.R
import com.example.app_ut2_07.datos.Animal
import com.example.app_ut2_07.datos.DatosAnimales

class AnimalAdapter (private val onClickAdapter: (Animal) -> Unit) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{
    private val listaAnimales = DatosAnimales.getDatosAnimales()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder
    {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(adapterLayout){ pos -> onClickAdapter(listaAnimales[pos]) }
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int)
    {
        val animal = listaAnimales[position]
        holder.textViewNombreAnimal.text = animal.nombre
        holder.imageViewAnimal.setImageResource(animal.imagenId)
        val votos = animal.votos.toString() + " votos"
        holder.textViewVotos.text = votos
    }

    override fun getItemCount() = listaAnimales.size

    class AnimalViewHolder(view: View, private val onClickHolder: (Int) -> Unit): RecyclerView.ViewHolder(view)
    {
        val textViewNombreAnimal = view.findViewById<TextView>(R.id.textViewNombreAnimal)
        val imageViewAnimal = view.findViewById<ImageView>(R.id.imageView)
        val textViewVotos = view.findViewById<TextView>(R.id.textViewVotos)

        init {
            view.setOnClickListener { onClickHolder(adapterPosition) }
        }

    }

    fun addAnimal(animal: Animal)
    {
        listaAnimales.add(animal)
        notifyDataSetChanged()
    }

    fun CambiarVoto(nombre : String, voto : Int){
        val animal = listaAnimales.first{a -> a.nombre == nombre}
        animal.votos += voto;
    }
}