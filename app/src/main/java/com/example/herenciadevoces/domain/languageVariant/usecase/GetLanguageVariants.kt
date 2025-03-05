package com.example.herenciadevoces.domain.languageVariant.usecase

import com.example.herenciadevoces.data.local.repository.languageVariantRepository
import com.example.herenciadevoces.domain.languageVariant.model.LanguageVariant
import com.example.herenciadevoces.domain.languageVariant.model.toLanguageVariant
import javax.inject.Inject

class GetLanguageVariants @Inject constructor(
    private val languageVariantRepository: languageVariantRepository
){
    suspend operator fun invoke(): List<LanguageVariant> {
        return languageVariantRepository.getAllLanguageVariants().map { it.toLanguageVariant() }
    }
}