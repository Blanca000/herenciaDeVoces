package com.example.herenciadevoces.data.local.repository

import com.example.herenciadevoces.data.local.dao.languageVariantDAO
import com.example.herenciadevoces.data.local.dao.spanishWordDataDAO
import com.example.herenciadevoces.data.local.model.languageVariantEntity
import javax.inject.Inject

class languageVariantRepository @Inject constructor(
    private val languageVariantDAO: languageVariantDAO
){
    fun getAllLanguageVariants() : List<languageVariantEntity>{
        return languageVariantDAO.getAllLanguageVariants()

    }
}