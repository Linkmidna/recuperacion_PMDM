package com.example.app_ut2_08.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.app_ut2_08.modelo.ReservaZooViewModel
import com.example.app_ut2_08.R
import com.example.app_ut2_08.databinding.FragmentResumenBinding

class FragmentResumen : Fragment() {
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()

    private lateinit var binding : FragmentResumenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResumenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModelCompartido

        //val botonReservar = binding.botonReservar no hace falta inicializarlo, se puede usar directamente
        binding.botonReservar.setOnClickListener {
            Toast.makeText(this.context, "Se ha realizado la reserva.", Toast.LENGTH_LONG).show()
            viewModelCompartido.resetearReserva()
            view.findNavController().navigate(R.id.fragmentInicio)
        }
    }

}