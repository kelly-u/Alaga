package br.com.ifpe.gleicekelly.alaga.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

    sealed interface Route {
        @Serializable
        data object Mapa : Route //Home

        @Serializable
        data object EnderecosFavoritos : Route //Favoritos

        @Serializable
        data object Alerta : Route //Favoritos

        @Serializable
        data object BuscarEndereco : Route //Mapa

        @Serializable
        data object Sobre : Route //*Sobre
    }
    sealed class BottomNavItem(
        var title: String,
        var icon: ImageVector,
        var route: Route)
    {
        data object MapaButton :
            BottomNavItem("Mapa", Icons.Default.LocationOn, Route.Mapa)
        data object EnderecosFavoritosButton :
            BottomNavItem("Favoritos", Icons.Default.Favorite, Route.EnderecosFavoritos)
        data object AlertaButton :
            BottomNavItem("ALERTA", Icons.Default.Notifications, Route.Alerta)
        data object BuscarEnderecoButton :
            BottomNavItem("Buscar", Icons.Default.Search, Route.BuscarEndereco)
        data object SobreButton :
            BottomNavItem("Sobre", Icons.Default.Info, Route.Sobre)

    }
