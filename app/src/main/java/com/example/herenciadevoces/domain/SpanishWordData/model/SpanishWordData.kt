package com.example.herenciadevoces.domain.SpanishWordData.model

import com.example.herenciadevoces.data.local.model.spanishWordDataEntity
import com.example.herenciadevoces.domain.languageWordData.model.LanguageWordData

data class SpanishWordData(
    val idSpanishWordData: Int,
    val idSemanticField: Int,
    val spanishWord: String,
    val pathAudio: String,
    val pathImage: String,
    val LWD: MutableList<LanguageWordData> = mutableListOf()
)

fun spanishWordDataEntity.toSpanishWordData(): SpanishWordData {
    return  SpanishWordData(
        idSpanishWordData = idSpanishWordData,
        idSemanticField = idSemanticField,
        spanishWord = spanishWord,
        pathAudio = pathAudio,
        pathImage = pathImage,
    )
}

fun SpanishWordData.toSpanishWordDataEntity(): spanishWordDataEntity {
    return  spanishWordDataEntity(
        idSpanishWordData = idSpanishWordData,
        idSemanticField = idSemanticField,
        spanishWord = spanishWord,
        pathAudio = pathAudio,
        pathImage = pathImage
    )
}