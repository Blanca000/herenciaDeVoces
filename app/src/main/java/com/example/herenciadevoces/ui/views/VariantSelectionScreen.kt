package com.example.herenciadevoces.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.herenciadevoces.R
import com.example.herenciadevoces.ui.theme.Orange
import com.example.herenciadevoces.ui.viewmodels.variantSelectionViewModel
import androidx.compose.foundation.Image

@Composable
fun VariantSelectionScreen(
    viewModel: variantSelectionViewModel,
    navigateToSFS: (List<Int>) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (viewModel.isLoading.value) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(painter = painterResource(id = R.drawable.main_screen), contentDescription = "Loading Image")
                CircularProgressIndicator()
            }
        } else {
            Header(Modifier.align(Alignment.TopCenter))
            Body(Modifier.align(Alignment.TopCenter),viewModel,navigateToSFS)
        }

    }
}



@Composable
fun Header(modifier: Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Seleccione las variantes de interés:",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun Body(
    modifier: Modifier,
    viewModel: variantSelectionViewModel,
    navigateToSFS: (List<Int>) -> Unit
) {
    val selectedVariants by viewModel.selectedLanguageVariants.collectAsState()
    val state = viewModel.state.value
    LazyColumn(
        modifier = Modifier.padding(start = 15.dp, top = 60.dp, end = 15.dp, bottom = 20.dp )
    ){
        items(state.languageVariants) { variant ->
            VariantOption(
                name = variant.variantName,
                isSelected = selectedVariants.contains(variant.idLanguageVariant),
                onSelectionChanged = {viewModel.toggleSelection(variant.idLanguageVariant)}
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
    val isButtonEnabled = selectedVariants.isNotEmpty()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        ElevatedButton(
            onClick = {navigateToSFS(selectedVariants)},
            enabled = isButtonEnabled,
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
}

@Composable
fun VariantOption(name: String,isSelected: Boolean, onSelectionChanged: (Boolean) -> Unit){
    var isSelected by rememberSaveable { mutableStateOf(false) }
    val ic_variant = painterResource(id = R.drawable.ic_variant)
    val ic_check_circle = painterResource(id = R.drawable.ic_check_circle)
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        BadgedBox(
            badge = {
                Badge(
                    containerColor = Color.Transparent,
                    contentColor = Orange,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .absoluteOffset(x = -15.dp, y = 70.dp)
                ) {
                    if(isSelected) {
                        Icon(
                            painter = ic_check_circle,
                            contentDescription = "Variante Selecionada",
                            modifier = Modifier
                                .background(Color.Unspecified)
                                .size(25.dp)
                        )
                    }
                }
            }
        ) {
            FilterChip(
                selected = isSelected,
                onClick = {
                    isSelected = !isSelected
                    onSelectionChanged(isSelected)
                },
                label = {
                    Icon(
                        painter = ic_variant,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp),
                        tint = Color.Unspecified
                    )
                },
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = isSelected,
                    selectedBorderColor = Orange,
                    borderColor = Color.LightGray,
                    selectedBorderWidth = 2.dp,
                    borderWidth = 2.dp
                ),
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color.Transparent
                ),
                shape = FilterChipDefaults.shape
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Variante ${name}", textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
    }
}

