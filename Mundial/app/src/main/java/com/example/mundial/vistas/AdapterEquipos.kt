package com.example.mundial.vistas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mundial.R

class AdapterEquipos:RecyclerView.Adapter<AdapterEquipos.EquiposViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquiposViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return EquiposViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: EquiposViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    class EquiposViewHolder(view: View): RecyclerView.ViewHolder(view)
    {

    }
}