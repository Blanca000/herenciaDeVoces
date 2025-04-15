package com.example.herenciadevoces.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herenciadevoces.R
import com.example.herenciadevoces.ui.theme.Orange
import com.example.herenciadevoces.ui.components.Header

data class Language(
    val languageName: String,
    val location: String,
    val region: String,
    val imageResId: Int
)

val languages = listOf(
    Language("Mixteco", "Coicoyán de las Flores, Juxtlahuaca.", "Mixteca Baja", R.drawable.mixteco),
    Language("Zapoteco", "San Agustín Loxicha.", "Costa Centro", R.drawable.zapoteco),
    // Agrega más idiomas aquí
    Language("Otro Idioma 1", "Ubicación 1", "Región 1", R.drawable.idiomaprueba1),
    Language("Otro Idioma 2", "Ubicación 2", "Región 2", R.drawable.idiomaprueba2),
)


@Preview(showSystemUi = true)
@Composable
fun LanguageSelectionScreen(modifier: Modifier = Modifier, navigateToSFS: () -> Unit = {}) {

    //val selectedImageResId = remember { mutableStateOf<Int?>(null) } // Estado para la imagen seleccionada
    val selectedImageResIds = remember { mutableStateListOf<Int>() } // Estado para la lista de imágenes seleccionadas
    Scaffold(
        topBar = {
            Header(title = "IDIOMAS DE MÉXICO!")
        },
        floatingActionButton = {
            ElevatedButton(
                onClick = {navigateToSFS()},
                enabled = true,
                modifier = Modifier.size(65.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                colors = ButtonColors(
                    contentColor = Orange,
                    containerColor = Orange,
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.LightGray
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Icono de flecha derecha
                    contentDescription = "Flecha derecha",
                    tint = Color.White, // Color del icono
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    ){
        innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Ya Seleccionados
            Selected(modifier = Modifier, selectedImageResIds = selectedImageResIds) // Pasamos el estado)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn{
                item {
                    Box(
                        modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                            .height(30.dp)
                    ) {
                        Text(text = "Seleccione los idiomas que desee:", fontSize = 18.sp)
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                }
                items(languages) { language ->
                    LanguageItem(
                        languageName = language.languageName,
                        location = language.location,
                        region = language.region,
                        imageResId = language.imageResId,
                        onItemClick = { imageId ->
                            if (selectedImageResIds.contains(imageId)) {
                                selectedImageResIds.remove(imageId)
                            } else {
                                selectedImageResIds.add(imageId)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }



}


@Composable
fun Selected(modifier: Modifier, selectedImageResIds: SnapshotStateList<Int>){
    Box(
        modifier
            .padding(20.dp)
            .fillMaxWidth()
            .height(120.dp)
        //.background(Color.Red),
    ) {
        Column {
            Box( modifier
                .weight(1f)
                .height(30.dp)
                .fillMaxWidth()
                .padding(5.dp)
                //.background(Color.Yellow)
            ){
                Text(text = "SELECCIONADOS",
                fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box( modifier
                .weight(3f)
                .fillMaxWidth()
                .padding(5.dp),
                //.background(Color.LightGray),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 14.dp)
                ) {
                    selectedImageResIds.forEach { imageId ->
                        LanguageImage(imageResId = imageId, contentDescription = "Imagen seleccionada")
                        Spacer(modifier = Modifier.width(18.dp)) // Espacio entre imágenes
                    }
                }
            }
        }
    }
}



// Definir el estilo que tendrá el Card Language
@Composable
fun LanguageItem(
    languageName: String,
    location: String,
    region: String,
    imageResId: Int,
    onItemClick: (Int) -> Unit // Recibimos la función lambda
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onItemClick(imageResId) }, // Llamamos a la función lambda al hacer clic
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(1.dp, Orange), // Color(1.0f, 0.54117647f, 0.0f)
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = languageName,
                modifier = Modifier
                    .size(85.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = languageName, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                Text(text = location, fontSize = 14.sp)
                Text(text = region, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun CardLanguage(
    languageName: String,
    location: String,
    region: String,
    imageResId: Int,
    onItemClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onItemClick(imageResId) },
        colors = CardDefaults.cardColors(Color.White),
        border = BorderStroke(1.dp, Orange),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LanguageImage(imageResId = imageResId, contentDescription = languageName)

            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = languageName,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Text(text = location, fontSize = 14.sp)
                Text(text = region, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun LanguageImage(imageResId: Int, contentDescription: String) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(60.dp) // Tamaño original
            .clip(CircleShape)
    )
}