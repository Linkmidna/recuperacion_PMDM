package com.example.examen_abril_julio_f.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.examen_abril_julio_f.datos.DatosParticipantes
import com.example.examen_abril_julio_f.modelo.Participante

class FestivalViewModel : ViewModel() {
    var participantes = MutableLiveData<List<Participante>>()
    var participanteSeleccionado = MutableLiveData<Participante>()

    init{
        participantes.postValue(DatosParticipantes.participantes)
    }

    fun setSeleccionado(participante: Participante){
        participanteSeleccionado.postValue(participante)
    }

    fun getFavoritos() : LiveData<List<Participante>> {
        return participantes.map { lista -> lista.filter { it.favorito }.sortedByDescending { it.nombre } }
    }

    fun setTelevoto(participante: Participante,televoto : Int){

        participantes
    }
}