package com.example.herenciadevoces.ui.utils

data class WordData(
    val pathImage: String,
    val spanishWord: String,
    val pathAudio: String,
    val variantData: List<VariantData> = emptyList()
)
