package com.example.examen_abril_julio_f.vistas

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
import com.example.examen_abril_julio_f.databinding.FragmentFavoritosBinding
import com.example.examen_abril_julio_f.modelo.Participante
import com.example.examen_abril_julio_f.viewmodel.FestivalViewModel

class FragmentFavoritos : Fragment() {
    private lateinit var binding: FragmentFavoritosBinding
    private val FestivalViewModel: FestivalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Aqui en vez de los participantes se deberia meter la lista de favoritos, pero como dije en el viewModel no me ha salido
        FestivalViewModel.getFavoritos().observe(viewLifecycleOwner) { participante ->
            with (binding.recyclerViewFavoritos){
                adapter = AdapterParticipantes(){ participante -> onClickParticipante(participante)}
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, androidx.recyclerview.widget.DividerItemDecoration.VERTICAL))
            }
        }
    }

    private fun onClickParticipante(participante: Participante)
    {
        FestivalViewModel.setSeleccionado(participante)
        findNavController().navigate(R.id.action_fragmentFavoritos_to_fragmentDetalleParticipante)

    }

}