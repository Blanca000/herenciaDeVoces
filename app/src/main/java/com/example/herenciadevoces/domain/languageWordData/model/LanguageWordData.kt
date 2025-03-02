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
        val idLanguageWordData: Int,
        val idSpanishWordData: idSpanishWordData,
        val idSemanticField: idSemanticField,
        val idLanguageVariant: idLanguageVariant,
        val pathAudio: pathAudio,
        val languageWord: languageWord
    )
}