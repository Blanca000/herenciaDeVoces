package com.example.herenciadevoces.domain.languageVariant.model

import com.example.herenciadevoces.data.local.model.languageVariantEntity
import com.example.herenciadevoces.domain.language.model.Language

data class LanguageVariant(
    val idLanguageVariant: Int,
    val idLanguage: Int,
    val variantName: String,
    val variantRegionName: String
)

fun languageVariantEntity.toLanguageVariant(): LanguageVariant {
    return LanguageVariant(
        idLanguageVariant = idLanguageVariant,
        idLanguage = idLanguage,
        variantName = variantName,
        variantRegionName = variantRegionName
    )
}

fun LanguageVariant.toLanguageVariantEntity(): languageVariantEntity {
    return languageVariantEntity(
        idLanguageVariant = idLanguageVariant,
        idLanguage = idLanguage,
        variantName = variantName,
        variantRegionName = variantRegionName
    )
}