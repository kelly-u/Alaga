package br.com.ifpe.gleicekelly.alaga.ui.pages

import android.content.pm.PackageManager
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import br.com.ifpe.gleicekelly.alaga.ui.view.MainViewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import androidx.compose.runtime.* //remember
import android.Manifest
import com.google.maps.android.compose.*

@Composable
fun MapaPage(viewModel: MainViewModel) {
    val camPosState = rememberCameraPositionState ()
    val recife = LatLng(-8.05, -34.9)
    val caruaru = LatLng(-8.27, -35.98)
    val joaopessoa = LatLng(-7.12, -34.84)
    val context = LocalContext.current
    val hasLocationPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED
        )
    }
    GoogleMap (modifier = Modifier.fillMaxSize(),
        onMapClick = { viewModel.add("Nova cidade", location = it) },
        cameraPositionState = camPosState,
        properties = MapProperties(isMyLocationEnabled = hasLocationPermission),
        uiSettings = MapUiSettings(myLocationButtonEnabled = true))
    {
        Marker(
            state = MarkerState(position = recife),
            title = "Recife",
            snippet = "Marcador em Recife",
            icon = BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_BLUE)
        )
        Marker(
            state = MarkerState(position = caruaru),
            title = "Caruaru",
            snippet = "Marcador em Caruaru",
            icon = BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_ORANGE)
        )
        Marker(
            state = MarkerState(position = joaopessoa),
            title = "João Pessoa",
            snippet = "Marcador em João Pessoa",
            icon = BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_CYAN)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapaPagePreview() {
    MapaPage(viewModel = MainViewModel())
}