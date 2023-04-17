package com.example.app_ut2_08.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.app_ut2_08.R
import com.example.app_ut2_08.databinding.FragmentInicioBinding


class FragmentInicio : Fragment() {
    private lateinit var binding : FragmentInicioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val botonZoo = binding.botonZoologico
        val botonReptario = binding.botonReptario
        val botonVisita = binding.botonVisitaGuiada
        botonZoo.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentPersonas)
        }
        botonReptario.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentPersonas)
        }
        botonVisita.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentPersonas)
        }
    }
}