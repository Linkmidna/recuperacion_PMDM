package com.example.examen_abril_julio_f.vistas

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toIcon
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.examen_abril_julio_f.R
import com.example.examen_abril_julio_f.databinding.FragmentDetalleParticipanteBinding
import com.example.examen_abril_julio_f.viewmodel.FestivalViewModel

class FragmentDetalleParticipante : Fragment() {
    private lateinit var binding: FragmentDetalleParticipanteBinding
    private val FestivalViewModel: FestivalViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleParticipanteBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!FestivalViewModel.participanteSeleccionado.value!!.favorito){
            //binding.imageViewFavorito.setImageIcon( el icono de no favorito iría aqui)
        }
        binding.textViewNombre.text = FestivalViewModel.participanteSeleccionado.value!!.nombre
        binding.textViewCancion.text = FestivalViewModel.participanteSeleccionado.value!!.cancion
        //binding.editTextJurado.text = FestivalViewModel.participanteSeleccionado.value!!.puntosJurado me dice que debería ser de tipo editable? en vez de int o string
        binding.seekBarDemoscopico.setOnTouchListener({_,_->true})
        binding.seekBarDemoscopico.progress = FestivalViewModel.participanteSeleccionado.value!!.puntosDemoscopico
        if (FestivalViewModel.participanteSeleccionado.value!!.puntosTelevoto == 16){
            binding.radioButton16.isSelected = true
        }
        if (FestivalViewModel.participanteSeleccionado.value!!.puntosTelevoto == 20){
            binding.radioButton20.isSelected = true
        }
        if (FestivalViewModel.participanteSeleccionado.value!!.puntosTelevoto == 25){
            binding.radioButton25.isSelected = true
        }
        if (FestivalViewModel.participanteSeleccionado.value!!.puntosTelevoto == 30){
            binding.radioButton30.isSelected = true
        }
        if (FestivalViewModel.participanteSeleccionado.value!!.puntosTelevoto == 35){
            binding.radioButton35.isSelected = true
        }
        if (FestivalViewModel.participanteSeleccionado.value!!.puntosTelevoto == 40){
            binding.radioButton40.isSelected = true
        }
        binding.imageViewDetalle.setImageResource(FestivalViewModel.participanteSeleccionado.value!!.imagen)


        binding.apply {
            radioButton16.setOnClickListener {televoto(16) }
            radioButton20.setOnClickListener { televoto(20)}
            radioButton25.setOnClickListener {televoto(25) }
            radioButton30.setOnClickListener { televoto(30)}
            radioButton35.setOnClickListener {televoto(35) }
            radioButton40.setOnClickListener {televoto(40) }
        }

    }

    fun televoto(valor: Int)
    {
       // FestivalViewModel.participanteSeleccionado.value!!.puntosTelevoto = valor

    }


}