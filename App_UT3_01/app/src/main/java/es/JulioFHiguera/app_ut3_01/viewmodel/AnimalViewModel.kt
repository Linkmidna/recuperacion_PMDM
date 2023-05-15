package es.JulioFHiguera.app_ut3_01.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.JulioFHiguera.app_ut3_01.model.Animal
import es.JulioFHiguera.app_ut3_01.model.AnimalRepository
import kotlinx.coroutines.launch

class AnimalViewModel: ViewModel()
{
    val animalesLiveData = MutableLiveData<List<Animal>>()
    val estaCargandoLiveData = MutableLiveData<Boolean>()

    private val repository = AnimalRepository()

    fun cargarDatos()
    {
        viewModelScope.launch {
            estaCargandoLiveData.postValue(true)
            animalesLiveData.postValue(repository.get())
            estaCargandoLiveData.postValue(false)
        }
    }

    fun cambiarVoto(nombre: String, voto: Int)
    {
        val animal = animalesLiveData.value!!.first { a -> a.nombre == nombre }
        animal.votos+=voto
        animalesLiveData.value = animalesLiveData.value
    }
}