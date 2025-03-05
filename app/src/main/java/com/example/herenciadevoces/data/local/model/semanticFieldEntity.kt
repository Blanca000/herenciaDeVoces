package com.example.herenciadevoces.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "semanticField")
data class semanticFieldEntity(
    @PrimaryKey(autoGenerate = true)val idSemanticField: Int = 1,
    @ColumnInfo(name = "semanticFieldName")val semanticFieldName: String,
    @ColumnInfo(name = "pathImage")val pathName: String
)
