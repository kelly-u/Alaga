package br.com.ifpe.gleicekelly.alaga.ui.nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
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
        composable<Route.Mapa> { MapaPage(viewModel = viewModel()) }
        composable<Route.EnderecosFavoritos> { EnderecosFavoritosPage(viewModel = viewModel()) }
        composable<Route.BuscarEndereco> { BuscarEnderecoPage(viewModel = viewModel()) }
        composable<Route.Sobre> { SobrePage() }
    }
}