package com.example.app_ut2_08.fragments

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
import com.example.app_ut2_08.databinding.FragmentFechaBinding
import java.util.*

class FragmentFecha : Fragment() {
    private val viewModelCompartido: ReservaZooViewModel by activityViewModels()

    private lateinit var binding : FragmentFechaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFechaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModelCompartido
        binding.lifecycleOwner = viewLifecycleOwner

        val hoy = Calendar.getInstance()
        binding.datePicker.init(hoy.get(Calendar.YEAR), hoy.get(Calendar.MONTH),
            hoy.get(Calendar.DAY_OF_MONTH))
        { _, year, month, day ->
            var fecha = Calendar.getInstance()
            fecha.set(year, month, day)
            viewModelCompartido.setFecha(fecha)
        }

        val botonResumen = binding.botonSiguiente
        botonResumen.setOnClickListener {
            view.findNavController().navigate(R.id.fragmentResumen)
        }
    }

}