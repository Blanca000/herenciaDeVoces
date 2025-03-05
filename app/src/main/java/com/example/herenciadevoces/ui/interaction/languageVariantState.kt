package com.example.herenciadevoces.ui.interaction

import com.example.herenciadevoces.domain.languageVariant.model.LanguageVariant

data class languageVariantState (
    var languageVariants: List<LanguageVariant> = emptyList()
)