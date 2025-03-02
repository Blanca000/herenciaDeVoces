package com.example.herenciadevoces.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@entity(tableName = "semanticField")
data class semanticFieldEntity(
    @PrimaryKey(autogenerate = true)val idSemanticField: Int = 1,
    @ColumnInfo(name = "semanticFieldName")val semanticFieldName: String,
    @ColumnInfo(name = "pathName")val pathName: String
)
