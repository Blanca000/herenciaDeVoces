package com.example.herenciadevoces.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "languageVariant",
    foreignKeys = [
        ForeignKey(
            entity = languageEntity::class,
            parentColumns = ["idLanguage"],
            childColumns = ["idLanguage"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [Index(value = ["idLanguage"])]
)
data class languageVariantEntity(
    @PrimaryKey(autoGenerate = true)val idLanguageVariant: Int = 1,
    @ColumnInfo(name = "idLanguage")val idLanguage: Int,
    @ColumnInfo(name = "variantName")val variantName: String,
    @ColumnInfo(name = "variantRegionName")val variantRegionName: String,
)