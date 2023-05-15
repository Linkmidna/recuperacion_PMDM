package com.example.examen_abril_julio_f.vistas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen_abril_julio_f.R
import com.example.examen_abril_julio_f.databinding.FragmentParticipantesBinding
import com.example.examen_abril_julio_f.modelo.Participante
import com.example.examen_abril_julio_f.viewmodel.FestivalViewModel

class FragmentParticipantes : Fragment() {
    private lateinit var binding: FragmentParticipantesBinding
    private val FestivalViewModel: FestivalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentParticipantesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FestivalViewModel.participantes.observe(viewLifecycleOwner) { participante ->
            with (binding.recyclerViewParticipantes){
                adapter = AdapterParticipantes(){ participante -> onClickParticipante(participante)}
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
    }

    private fun onClickParticipante(participante: Participante)
    {
        FestivalViewModel.setSeleccionado(participante)
        findNavController().navigate(R.id.action_fragmentParticipantes_to_fragmentDetalleParticipante)

    }

}