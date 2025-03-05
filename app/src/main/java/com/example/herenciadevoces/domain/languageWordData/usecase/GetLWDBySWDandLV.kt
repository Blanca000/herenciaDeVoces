package com.example.herenciadevoces.domain.languageWordData.usecase

import com.example.herenciadevoces.data.local.repository.languageWordDataRepository
import com.example.herenciadevoces.domain.languageWordData.model.LanguageWordData
import com.example.herenciadevoces.domain.languageWordData.model.toLanguageWordData
import javax.inject.Inject

class GetLWDBySWDandLV @Inject constructor(
    private val languageWordDataRepository: languageWordDataRepository
) {
    suspend operator fun invoke(idSpanishWordData: Int, idsLanguagesVariants: List<Int>): List<LanguageWordData> {
        return languageWordDataRepository.getLWDByIdSWDandLV(idSpanishWordData,idsLanguagesVariants).map { it.toLanguageWordData() }
    }
}