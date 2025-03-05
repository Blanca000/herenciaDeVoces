package com.example.herenciadevoces.domain.languageWordData.model

import android.media.Image
import com.example.herenciadevoces.data.local.model.languageWordDataEntity
import com.example.herenciadevoces.domain.SemanticField.model.SemanticField
import com.example.herenciadevoces.domain.SpanishWordData.model.SpanishWordData

data class LanguageWordData(
    val idLanguageWordData: Int,
    val idSpanishWordData: Int,
    val idSemanticField: Int,
    val idLanguageVariant: Int,
    val pathAudio: String,
    val languageWord: String
)

fun languageWordDataEntity.toLanguageWordData(): LanguageWordData {
    return LanguageWordData(
        idLanguageWordData = idLanguageWordData,
        idSpanishWordData = idSpanishWordData,
        idSemanticField = idSemanticField,
        idLanguageVariant = idLanguageVariant,
        pathAudio = pathAudio,
        languageWord = languageWord
    )
}