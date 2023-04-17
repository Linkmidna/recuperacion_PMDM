package com.example.app_ut2_08.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.app_ut2_08.R
import com.example.app_ut2_08.databinding.FragmentPersonasBinding

class FragmentPersonas : Fragment() {

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
        binding.numberPickerAdultos.apply {
            minValue = 0
            maxValue = 5
            value = 1
            wrapSelectorWheel = false
        }
        binding.numberPickerNinos.apply {
            minValue = 0
            maxValue = 5
            value = 0
            wrapSelectorWheel = false
        }
        val botonFecha = binding.botonSiguiente
        botonFecha.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentFecha)
        }
    }
}