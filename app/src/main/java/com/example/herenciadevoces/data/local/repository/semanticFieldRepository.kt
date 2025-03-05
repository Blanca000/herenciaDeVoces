package com.example.herenciadevoces.data.local.repository

import  com.example.herenciadevoces.data.local.dao.semanticFieldDAO
import  com.example.herenciadevoces.data.local.model.semanticFieldEntity
import javax.inject.Inject

class semanticFieldRepository @Inject constructor(
    private val semanticFieldDAO: semanticFieldDAO
) {
    fun getAllSemanticFields():List<semanticFieldEntity>{
        return semanticFieldDAO.getAllSemanticFields()
    }
}