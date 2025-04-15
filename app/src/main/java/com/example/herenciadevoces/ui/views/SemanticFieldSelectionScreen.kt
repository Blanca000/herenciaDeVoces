package com.example.herenciadevoces.ui.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.herenciadevoces.R
import com.example.herenciadevoces.domain.SemanticField.model.SemanticField
import com.example.herenciadevoces.ui.theme.Orange
import com.example.herenciadevoces.ui.viewmodels.SemanticFieldSelectionViewModel
import com.example.herenciadevoces.ui.components.Header

@Composable
fun SemanticFieldSelectionScreen(
    viewModel: SemanticFieldSelectionViewModel = hiltViewModel(),
    navigateToWS: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(title = "CAMPO SEMÁNTICO")
        Text(text = "Seleccione el campo semántico que desee:", fontSize = 18.sp, modifier = Modifier.padding(start = 20.dp, top = 10.dp))
        Grid(viewModel,navigateToWS)
    }
}


@Composable
fun Grid(viewModel: SemanticFieldSelectionViewModel, navigateToWS: (Int) -> Unit) {
    val buttonCount = 20 // Total de botones
    val state = viewModel.state.value
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 20.dp), // Espaciado alrededor de la cuadrícula
        contentPadding = PaddingValues(8.dp), // Espaciado dentro de la cuadrícula
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        items(state.semanticField) { semanticField ->
            SemanticFieldButton(semanticField,navigateToWS)
        }
    }
}

@Composable
fun SemanticFieldButton(semanticField: SemanticField,navigateToWS: (Int) -> Unit) {
    Column()
    {
        ElevatedButton(
            onClick = { navigateToWS(semanticField.idSemanticField) },
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f), // Hace que los botones sean cuadrados
            shape = CircleShape, // Forma redondeada
            colors = ButtonColors(containerColor = Color.Transparent, contentColor = Color.Transparent, disabledContentColor = Color.Transparent, disabledContainerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.campo),
                contentDescription = "Icono del botón",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Text(
            text = semanticField.semanticFieldName,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
