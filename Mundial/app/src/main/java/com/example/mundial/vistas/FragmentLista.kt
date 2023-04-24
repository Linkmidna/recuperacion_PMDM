package com.example.mundial.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mundial.R
import com.example.mundial.databinding.FragmentListaBinding
import com.example.mundial.datos.DatosSelecciones.equipos
import com.example.mundial.modelo.ViewModelEquipos

class FragmentLista : Fragment() {
    private lateinit var binding: FragmentListaBinding
    private lateinit var recyclerViewEquipos: RecyclerView
    private val viewModelEquipos: ViewModelEquipos by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelEquipos.equipos.observe(viewLifecycleOwner) { equipos ->
            with (binding.recyclerViewEquipos){
                adapter = AdapterEquipos(equipos){ centro -> onClickCentro(centro)}
                layoutManager = LinearLayoutManager(context)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }
    }

}