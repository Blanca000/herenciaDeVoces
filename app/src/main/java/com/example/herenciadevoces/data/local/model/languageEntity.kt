package com.example.herenciadevoces.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@entity(tableName="language")
data class languageEntity(
    @primaryKey(autogenerate = true)val idLanguage: Int = 1,
    @ColumnInfo(name = "languageName")val languageName: String
)