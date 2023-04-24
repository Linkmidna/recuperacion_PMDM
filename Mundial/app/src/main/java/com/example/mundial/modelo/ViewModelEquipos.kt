package com.example.mundial.modelo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mundial.datos.DatosSelecciones

class ViewModelEquipos : ViewModel() {
    val equipos = MutableLiveData<List<Equipo>>()

    init{
        equipos.postValue(DatosSelecciones.equipos)
    }
}