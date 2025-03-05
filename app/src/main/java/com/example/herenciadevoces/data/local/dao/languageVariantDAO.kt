package com.example.herenciadevoces.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.herenciadevoces.data.local.model.languageVariantEntity

@Dao
interface languageVariantDAO {
    @Query("SELECT * FROM languageVariant")
    fun getAllLanguageVariants(): List<languageVariantEntity>

    @Query("SELECT * FROM languageVariant WHERE idLanguageVariant IN (:idsVariant)")
    fun getVariantsByIds(idsVariant: List<Int>): List<languageVariantEntity>

}