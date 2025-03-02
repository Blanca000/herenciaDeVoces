package com.example.herenciadevoces.ui.views

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.herenciadevoces.ui.viewmodels.wordSoundsViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import com.example.herenciadevoces.R
import com.example.herenciadevoces.ui.utils.VariantData
import com.example.herenciadevoces.ui.utils.WordData
import java.io.InputStream

@Composable
fun WordSoundsScreen(viewModel: wordSoundsViewModel = hiltViewModel()) {
    val actualItem by viewModel.actualItem.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    if (isLoading) {
        CircularProgressIndicator() // Show loading indicator
    } else {
        actualItem?.let { wordData ->
            Column(
                modifier = Modifier.fillMaxSize()
                    .background(color = Color(0xfffcf3cf))
            ) {
                WordImage(wordData)
                Word(wordData)
                SpanishSoundButton(wordData)
                wordData.variantData.forEach { variantData ->
                    VariantSoundButton(variantData)
                }


                NavButtons(viewModel)
            }
        } ?: Text("No hay datos disponibles")

    }
}

@Composable
fun WordImage(wordData: WordData) {
    val context = LocalContext.current
    val currentPath by rememberUpdatedState(newValue = wordData.pathImage)

    var bitmap by remember { mutableStateOf<android.graphics.Bitmap?>(null) }
    LaunchedEffect(key1 = currentPath) {
        bitmap = loadBitmapFromAssets(context, currentPath)
    }
    Box(
        modifier = Modifier.padding(vertical = 12.dp)
    ){
        bitmap?.let{
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Imágen de ${wordData.spanishWord}",
                modifier = Modifier.border(6.dp, color = Color(0xFFf4d03f))
            )
        }
    }

}

@Composable
fun Word(wordData: WordData) {
    Text(text = wordData.spanishWord, modifier = Modifier.padding(vertical = 12.dp) , fontSize = 20.sp)
}


@Composable
fun VariantSoundButton(wordData: VariantData) {
    val context = LocalContext.current
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    Text(text = wordData.variantName)
    ElevatedButton(onClick = {
        mediaPlayer?.release() // Libera recursos si ya está reproduciendo
        mediaPlayer = MediaPlayer().apply {
            val assetFileDescriptor = context.assets.openFd(wordData.pathAudio)
            setDataSource(
                assetFileDescriptor.fileDescriptor,
                assetFileDescriptor.startOffset,
                assetFileDescriptor.length
            )
            prepare()
            start()
        }
    }) {
        Text(text = wordData.mixtecWord, modifier = Modifier.padding(end = 4.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_volumeup),
            contentDescription = "Reproducir Sonido",
            modifier = Modifier.size(20.dp)
        )
    }

}

@Composable
fun SpanishSoundButton(wordData: WordData) {
    val context = LocalContext.current
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    Text(text = "Español")
    ElevatedButton(onClick = {
        mediaPlayer?.release() // Libera recursos si ya está reproduciendo
        mediaPlayer = MediaPlayer().apply {
            val assetFileDescriptor = context.assets.openFd(wordData.pathAudio)
            setDataSource(
                assetFileDescriptor.fileDescriptor,
                assetFileDescriptor.startOffset,
                assetFileDescriptor.length
            )
            prepare()
            start()
        }
    }) {
        Text(text = wordData.spanishWord, modifier = Modifier.padding(end = 4.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_volumeup),
            contentDescription = "Reproducir Sonido",
            modifier = Modifier.size(20.dp)
        )
    }

}

@Composable
fun NavButtons(viewModel: wordSoundsViewModel) {
    Row {
        ElevatedButton(onClick = {
            viewModel.previousItem()
        }) {
            Text(text = "Anterior")
        }
        ElevatedButton(onClick = {
            viewModel.nextItem()
        }) {
            Text(text = "Siguiente")
        }
    }
}

fun loadBitmapFromAssets(context: Context, assetPath: String): Bitmap? {
    return try {
        context.assets.open(assetPath).use { inputStream: InputStream ->
            BitmapFactory.decodeStream(inputStream)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
