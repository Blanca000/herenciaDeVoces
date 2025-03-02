package com.example.herenciadevoces.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.herenciadevoces.data.local.model.semanticFieldEntity

@Dao
interface semanticFieldDAO {
    @Query("SELECT * FROM semanticField")
    fun getAllSemanticFields(): List<semanticFieldEntity>
}