package com.example.herenciadevoces.domain.language.usecase

import com.example.herenciadevoces.data.local.repository.languageRepository
import com.example.herenciadevoces.domain.language.model.Language
import com.example.herenciadevoces.domain.language.model.toLanguage
import javax.inject.Inject

class GetLanguages @inject constructor(
    private val languageRepository: languageRepository
){
    suspend operator fun invoke():List<Language>{
        return languageRepository.getAllLanguage().map { it.toLanguage() }
    }
}