package com.example.examen_abril_julio_f.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_abril_julio_f.R
import com.example.examen_abril_julio_f.datos.DatosParticipantes
import com.example.examen_abril_julio_f.modelo.Participante

class AdapterParticipantes (private val onClickAdapter: (Participante) -> Unit) : RecyclerView.Adapter<AdapterParticipantes.ParticipanteViewHolder>()
{
    private val listaParticipantes = DatosParticipantes.participantes

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipanteViewHolder
    {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_participante, parent, false)

        return ParticipanteViewHolder(adapterLayout){ pos -> onClickAdapter(listaParticipantes[pos]) }
    }

    override fun onBindViewHolder(holder: ParticipanteViewHolder, position: Int)
    {
        val participante = listaParticipantes[position]
        holder.textViewNombre.text = participante.nombre
        holder.imageViewParticipante.setImageResource(participante.imagen)
        val puntos = participante.puntosJurado+participante.puntosDemoscopico+participante.puntosTelevoto
        val puntosString = puntos.toString() + "puntos"
        holder.textViewPuntos.text = puntosString
    }

    override fun getItemCount() = listaParticipantes.size


    class ParticipanteViewHolder(view: View, private val onClickHolder: (Int) -> Unit): RecyclerView.ViewHolder(view)
    {
        val textViewNombre = view.findViewById<TextView>(R.id.textViewNombre)
        val imageViewParticipante = view.findViewById<ImageView>(R.id.imageViewParticipante)
        val textViewPuntos = view.findViewById<TextView>(R.id.textViewPuntos)

        init {
            view.setOnClickListener { onClickHolder(adapterPosition) }
        }

    }
}