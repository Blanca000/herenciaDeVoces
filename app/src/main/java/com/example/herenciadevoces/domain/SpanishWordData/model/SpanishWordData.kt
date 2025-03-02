package com.example.herenciadevoces.domain.SpanishWordData.model

import com.example.herenciadevoces.data.local.model.spanishWordDataEntity

data class SpanishWordData(
    val idSpanishWordData: Int,
    val idSemanticField: Int,
    val spanishWord: String,
    val pathAudio: String,
    val pathImage: String
)

fun spanisheWordDataEntity.toSemanticField(): SpanishWordData {
    return  SpanishWordData(
        idSpanishWordData = idSpanishWordData,
        idSemanticField = idSemanticField,
        spanishWord = spanishWord,
        pathAudio = pathAudio,
        pathImage = pathImage
    )
}

fun spanishWordData.toSpanishWordData(): spanishWordDataEntity {
    return  SpanishWordDataEntity(
        idSpanishWordData = idSpanishWordData,
        idSemanticField = idSemanticField,
        spanishWord = spanishWord,
        pathAudio = pathAudio,
        pathImage = pathImage
    )
}