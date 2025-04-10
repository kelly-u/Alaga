package br.com.ifpe.gleicekelly.alaga

import br.com.ifpe.gleicekelly.alaga.ui.theme.AlagaTheme
import br.com.ifpe.gleicekelly.alaga.ui.nav.BottomNavItem
import br.com.ifpe.gleicekelly.alaga.ui.nav.BottomNavBar
import br.com.ifpe.gleicekelly.alaga.ui.nav.MainNavHost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.ifpe.gleicekelly.alaga.ui.view.MainViewModel
import androidx.compose.runtime.* //remember
import br.com.ifpe.gleicekelly.alaga.ui.CityDialog
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavDestination.Companion.hasRoute
import br.com.ifpe.gleicekelly.alaga.ui.nav.Route
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel : MainViewModel by viewModels()
            val navController = rememberNavController()
            var showDialog by remember { mutableStateOf(false) }
            val currentRoute = navController.currentBackStackEntryAsState()
            val showButton = currentRoute.value?.destination?.hasRoute(Route.EnderecosFavoritos::class)?:false
            val launcher = rememberLauncherForActivityResult(contract =
            ActivityResultContracts.RequestPermission(), onResult = {} )
            AlagaTheme {
                if (showDialog) {
                    CityDialog(
                        onDismiss = { showDialog = false }, // Fecha o diálogo
                        onConfirm = { city ->
                            if (city.isNotBlank()) {
                                viewModel.add(city)
                                showDialog = false
                            }
                        }
                    )
                }
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Bem-vindo/a!") },
                            actions = {
                                IconButton( onClick = { Firebase.auth.signOut()
                                    finish() } ) {
                                    Icon(
                                        imageVector =
                                        Icons.AutoMirrored.Filled.ExitToApp,
                                        contentDescription = "Localized description"
                                    )
                                }
                            }
                        )
                    },
                    bottomBar = {
                        val items = listOf(
                            BottomNavItem.MapaButton,
                            BottomNavItem.EnderecosFavoritosButton,
                            BottomNavItem.BuscarEnderecoButton,
                            BottomNavItem.SobreButton,
                        )
                        BottomNavBar(navController = navController, items)
                    },
                    floatingActionButton = {
                        if (showButton) {
                            FloatingActionButton(onClick = { showDialog = true }) {
                                Icon(Icons.Default.Add, contentDescription = "Adicionar")
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                        MainNavHost(navController = navController)
                    }
                }
            }

        }
    }
}

