package com.example.app_ut3_02.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Centro(
    @SerializedName("nombre")
    val nombre:String,
    @SerializedName("email")
    val email: String,
    @SerializedName("direccion")
    val direccion: String = "",
    @SerializedName("horario")
    var horario: String = "",
    @SerializedName("localizacion")
    val localizacion:String,
    @SerializedName("telefono")
    val telefono: String,
    @SerializedName("web")
    val web: String = ""
) : Serializable