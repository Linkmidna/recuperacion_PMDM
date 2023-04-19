package com.example.app_ut2_08.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.app_ut2_08.modelo.ReservaZooViewModel
import com.example.app_ut2_08.R
import com.example.app_ut2_08.databinding.FragmentPersonasBinding

class FragmentPersonas : Fragment() {
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()

    private lateinit var binding: FragmentPersonasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModelCompartido
        binding.lifecycleOwner = viewLifecycleOwner

        binding.numberPickerAdultos.apply {
            minValue = 0
            maxValue = 5
            value = 1
            wrapSelectorWheel = false

            setOnValueChangedListener {_, _, nuevo
                -> viewModelCompartido.setNumeroAdultos(nuevo)
            }

        }
        binding.numberPickerNinos.apply {
            minValue = 0
            maxValue = 5
            value = 0
            wrapSelectorWheel = false

            setOnValueChangedListener {_, _, nuevo
                -> viewModelCompartido.setNumeroNinos(nuevo)
            }
        }
        val botonFecha = binding.botonSiguiente
        botonFecha.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentFecha)
        }
    }
}