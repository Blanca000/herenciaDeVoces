package com.example.herenciadevoces.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "languageWordData",
    foreignKeys = [
        ForeignKey(
            entity = spanishWordDataEntity::class,
            parentColumns = ["idSpanishWordData"],
            childColumns = [ "idSpanishWordData" ],
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = semanticFieldEntity::class,
            parentColumns = ["idSemanticField"],
            childColumns = [ "idSemanticField" ],
            onDelete = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = languageVariantEntity::class,
            parentColumns = ["idLanguageVariant"],
            childColumns = [ "idLanguageVariant" ],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [
        Index(value = ["idSpanishWordData"]),
        Index(value = ["idSemanticField"]),
        Index(value = ["idLanguageVariant"])
    ]
)

data class languageWordDataEntity(
    @PrimaryKey(autoGenerate = true)val idLanguageWordData: Int = 1,
    @ColumnInfo(name = "idSpanishWordData")val idSpanishWordData : Int,
    @ColumnInfo(name = "idSemanticField")val idSemanticField : Int,
    @ColumnInfo(name = "idLanguageVariant")val idLanguageVariant : Int,
    @ColumnInfo(name = "pathAudio")val pathAudio : String,
    @ColumnInfo(name = "languageWord")val languageWord : String,
)