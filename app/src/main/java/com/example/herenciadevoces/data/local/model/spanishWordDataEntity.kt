package com.example.herenciadevoces.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "spanishWordData",
    foreignKey = [
        ForeignKey(
            entity = semanticFieldEntity::class,
            parentColumns = ["idSemanticField"],
            childColumns = [ "idSemanticField" ],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [ Index(value = ["idSemanticField"]) ]
)

data class spanishWordDataEntity(
    @PrimaryKey(autoGenerate = true)val idSpanishWordData: Int = 1,
    @ColumnInfo(name = "idSemanticField")val idSemanticField : Int,
    @ColumnInfo(name = "spanishWord")val spanishWord : String,
    @ColumnInfo(name = "pathAudio")val pathAudio : String,
    @ColumnInfo(name = "pathImage")val pathImage : String,
)
