package br.com.ifpe.gleicekelly.alaga.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun SobrePage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)

    ) {
        Text(
            text = "SOBRE NÓS",
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
        )
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomStart)

    ) {
        Text(
            text = "Este app foi desenvolvido por mim, Gleice Kelly. No momento da codificação deste" +
                    "aplicativo, sou estudant do IFPE - Instituto Federal de Educação, Ciência e Tecnologia" +
                    "de Pernambuco. O Alaga Aqui, Alaga lá, nasceu da preocupação de meus amigos e pessoas queridas" +
                    "em momentos de chuva forte. Visto que, muitos sofriam com alagamentos, enchentes e perda de seus bens." +
                    "Mas, para que mais pessoas pudessem ser ajudadas, disponibilizei este para todos e assim chegou até você!" +
                    "Muito obrigada pelo download e espero que você esteja em segurança!",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            textAlign = TextAlign.Justify,
            fontSize = 25.sp,
        )
    }
}