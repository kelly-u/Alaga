package br.com.ifpe.gleicekelly.alaga.ui.model

import com.google.android.gms.maps.model.LatLng

//Mudar para rua
data class City(
    val name: String,
    val weather: String? = null,
    val location: LatLng? = null
)