package br.com.ifpe.gleicekelly.alaga.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import br.com.ifpe.gleicekelly.alaga.ui.view.MainViewModel

@Composable
fun BuscarEnderecoPage(viewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxSize()
            .wrapContentSize(Alignment.Center)

    ) {
        Text(
            text = "Clique no botão '+' para encontrar um novo endereço!!",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}
