package br.com.ifpe.gleicekelly.alaga

import br.com.ifpe.gleicekelly.alaga.ui.theme.AlagaTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import br.com.ifpe.gleicekelly.alaga.ui.MapaPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlagaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MapaPage(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

