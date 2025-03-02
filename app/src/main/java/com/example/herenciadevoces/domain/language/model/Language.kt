package com.example.herenciadevoces.domain.language.model

import com.example.herenciadevoces.data.local.model.languageEntity

data class Language(
    val idLanguage: Int,
    val languageName: String
)

fun languageEntity.toLanguage(): Language {
    return Language(
        val idLanguage: Int,
        val languageName: String
    )
}

fun Language.toLanguageEntity(): languageEntity {
    return Language(
        val idLanguage: Int,
        val languageName: String
    )
}