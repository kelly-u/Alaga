package br.com.ifpe.gleicekelly.alaga.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.ifpe.gleicekelly.alaga.ui.pages.BuscarEnderecoPage
import br.com.ifpe.gleicekelly.alaga.ui.pages.EnderecosFavoritosPage
import br.com.ifpe.gleicekelly.alaga.ui.pages.MapaPage
import br.com.ifpe.gleicekelly.alaga.ui.pages.SobrePage
import br.com.ifpe.gleicekelly.alaga.ui.view.MainViewModel

@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier, viewModel: MainViewModel) {
    NavHost(navController, startDestination = Route.Mapa) {
        composable<Route.Mapa> { MapaPage(viewModel) }
        composable<Route.EnderecosFavoritos> { EnderecosFavoritosPage(modifier, viewModel) }
        composable<Route.BuscarEndereco> { BuscarEnderecoPage(viewModel) }
        composable<Route.Sobre> { SobrePage(modifier) }
    }
}