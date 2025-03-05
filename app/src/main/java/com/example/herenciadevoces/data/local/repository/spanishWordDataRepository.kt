package com.example.herenciadevoces.data.local.repository

import com.example.herenciadevoces.data.local.dao.spanishWordDataDAO
import com.example.herenciadevoces.data.local.model.spanishWordDataEntity
import javax.inject.Inject

class spanishWordDataRepository @Inject constructor(
    private val spanishWordDataDAO: spanishWordDataDAO
){
    fun getSpanishWordDataBySemanticField(idSemanticField: Int): List<spanishWordDataEntity> {
        return spanishWordDataDAO.getSpanishWordDataBySemanticField(idSemanticField)
    }
}