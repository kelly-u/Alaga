package br.com.ifpe.gleicekelly.alaga.ui.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.IconButton
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.Close
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext
import br.com.ifpe.gleicekelly.alaga.ui.view.MainViewModel
import br.com.ifpe.gleicekelly.alaga.ui.model.City

@Composable
fun EnderecosFavoritosPage(
    modifier: Modifier = Modifier, viewModel: MainViewModel
) {
    val cityList = viewModel.cities
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(cityList) { city ->
            CityItem(city = city, onClose = {
                viewModel.remove(city)
                Toast.makeText(context, "Cidade removida: ${city.name}", Toast.LENGTH_SHORT).show()
            },
                onClick = {
                    Toast.makeText(context, "Cidade selecionada: ${city.name}", Toast.LENGTH_SHORT).show()
                })
        }
    }
}

//Mudar para rua
@Composable
fun CityItem(
    city: City,
    onClick: () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Rounded.FavoriteBorder,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column(modifier = modifier.weight(1f)) {
            Text(
                modifier = Modifier,
                text = city.name,
                fontSize = 24.sp
            )
            Text(
                modifier = Modifier,
                text = city.weather ?: "Carregando clima...",
                fontSize = 16.sp
            )
        }
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}
