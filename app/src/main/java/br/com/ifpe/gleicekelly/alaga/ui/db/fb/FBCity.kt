package br.com.ifpe.gleicekelly.alaga.ui.db.fb

import br.com.ifpe.gleicekelly.alaga.ui.model.City
import com.google.android.gms.maps.model.LatLng

class FBCity {

    var name : String? = null
    var lat : Double? = null
    var lng : Double? = null
    fun toCity(): City {
        val latlng = if (lat!=null&&lng!=null) LatLng(lat!!, lng!!) else null
        return City(name!!, weather = null, location = latlng)
    }
}
fun City.toFBCity() : FBCity {
    val fbCity = FBCity()
    fbCity.name = this.name
    fbCity.lat = this.location?.latitude ?: 0.0
    fbCity.lng = this.location?.longitude ?: 0.0
    return fbCity

}