package com.example.examen_abril_julio_f.modelo

import java.io.Serializable

data class Participante(val nombre : String, val cancion : String, val imagen : Int, val puntosJurado : Int, val puntosDemoscopico : Int, val puntosTelevoto : Int, val favorito : Boolean) :
    Serializable
