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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.ifpe.gleicekelly.alaga.R

@Preview(showBackground = true)
@Composable
fun BuscarEnderecoPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(colorResource(id = R.color.blue_alaga))
            .wrapContentSize(Alignment.Center)

    ) {
        Text(
            text = "Aqui você vai buscar seus endereços!",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}