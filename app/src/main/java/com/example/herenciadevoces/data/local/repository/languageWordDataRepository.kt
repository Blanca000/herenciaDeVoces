package com.example.herenciadevoces.data.local.repository

import com.example.herenciadevoces.data.local.dao.languageWordDataDAO
import com.example.herenciadevoces.data.local.model.languageWordDataEntity
import javax.inject.Inject

class languageWordDataRepository @Inject constructor(
    private val languageWordDataDAO: languageWordDataDAO
) {
    fun getLWDByIdSWDandLV(idSpanishWordData: Int, idsLanguagesVariants: List<Int>): List<languageWordDataEntity> {
        return languageWordDataDAO.getLWDByIdSWDandLV(idSpanishWordData,idsLanguagesVariants)
    }
}