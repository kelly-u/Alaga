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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import br.com.ifpe.gleicekelly.alaga.R
import br.com.ifpe.gleicekelly.alaga.ui.view.MainViewModel

@Composable
fun MapaPage(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    Column(
        modifier = modifier.fillMaxSize()
        .background(colorResource(id = R.color.yellow_alaga))
        .wrapContentSize(Alignment.Center)

    ) {
        Text(
            text = "Aqui vai ficar o mapa!",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}