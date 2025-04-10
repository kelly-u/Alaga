package br.com.ifpe.gleicekelly.alaga.ui.view

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import br.com.ifpe.gleicekelly.alaga.ui.model.City
import com.google.android.gms.maps.model.LatLng

class MainViewModel : ViewModel() {
    private val _cities = List(20) { i ->
        City(name = "Cidade $i", weather = "Carregando clima...")
    }.toMutableStateList()
    val cities
        get() = _cities.toList()

    fun remove(city: City) {
        _cities.remove(city)
    }

    fun add(name: String, location: LatLng? = null) {
        _cities.add(City(name = name, location = location))
    }

}