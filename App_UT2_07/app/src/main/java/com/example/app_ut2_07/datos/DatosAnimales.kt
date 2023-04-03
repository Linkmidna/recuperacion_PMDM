package com.example.app_ut2_07.datos

import com.example.app_ut2_07.R

object DatosAnimales {
    fun getDatosAnimales(): ArrayList<Animal>
    {
        return arrayListOf<Animal>(
            Animal("Ballena", R.drawable.ballena, "Descripción de ballena",0),
            Animal("Bisonte", R.drawable.bisonte, "Los bisontes son potentes ungulados de carácter muy vivaz y de una asombrosa agilidad. Forman rebaños independientes de machos y hembras que se unen únicamente en la época de celo, en la que los machos son más vigorosos. Finalizado este periodo, las hembras se alejan de la manada y vuelven a su vida tranquila; nueve meses después dan a luz un ternero.\n" +
                    "\n" +
                    "Ha sido una de las especies más representadas artísticamente por el hombre del Paleolítico en arte rupestre. Se han hallado numerosas representaciones de bisontes a lo largo de toda Europa, destacando las de Altamira (Santillana del Mar) y Covaciella (Cabrales) por su belleza y grado de detalle.\n" +
                    "\n" +
                    "Antaño se encontraba en todo el continente, pero desapareció totalmente de los bosques a finales de la primera guerra mundial. Actualmente solo vive en los bosques de Bialoweiza, repoblados a partir de 1956 con unos pocos animales de raza pura preservados en los zoos.",0),
            Animal("Camaleón", R.drawable.camaleon, "Descripción de camaleón",0),
            Animal("Cebra", R.drawable.cebra, "Descripción de cebra",0),
            Animal("Cocodrilo", R.drawable.cocodrilo, "Descripción de cocodrilo",0),
            Animal("Elefante", R.drawable.elefante, "Descripción de elefante",0),
            Animal("Hipopótamo", R.drawable.hipopotamo, "Descripción de hipopótamo",0),
            Animal("Jirafa", R.drawable.jirafa, "Descripción de jirafa",0),
            Animal("Mono", R.drawable.mono, "Descripción de mono",0),
            Animal("Venado", R.drawable.venado, "Descripción de venado",0),
            Animal("Zorro", R.drawable.zorro, "Descripción de zorro",0)
        )
    }

}