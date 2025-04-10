package br.com.ifpe.gleicekelly.alaga.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.ifpe.gleicekelly.alaga.ui.pages.BuscarEnderecoPage
import br.com.ifpe.gleicekelly.alaga.ui.pages.EnderecosFavoritosPage
import br.com.ifpe.gleicekelly.alaga.ui.pages.MapaPage
import br.com.ifpe.gleicekelly.alaga.ui.pages.SobrePage

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = Route.Mapa) {
        composable<Route.Mapa> { MapaPage() }
        composable<Route.EnderecosFavoritos> { EnderecosFavoritosPage() }
        composable<Route.BuscarEndereco> { BuscarEnderecoPage() }
        composable<Route.Sobre> { SobrePage() }
    }
}