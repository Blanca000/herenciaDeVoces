package com.example.herenciadevoces.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.herenciadevoces.data.local.dao.languageDAO
import com.example.herenciadevoces.data.local.dao.languageVariantDAO
import com.example.herenciadevoces.data.local.dao.languageWordDataDAO
import com.example.herenciadevoces.data.local.dao.spanishWordDataDAO
import com.example.herenciadevoces.data.local.dao.semanticFieldDAO
import com.example.herenciadevoces.data.local.model.languageEntity
import com.example.herenciadevoces.data.local.model.languageVariantEntity
import com.example.herenciadevoces.data.local.model.languageWordDataEntity
import com.example.herenciadevoces.data.local.model.semanticFieldEntity
import com.example.herenciadevoces.data.local.model.spanishWordDataEntity

@Database(
    entities = [
        languageEntity::class,
        languageVariantEntity::class,
        languageWordDataEntity::class,
        semanticFieldEntity::class,
        spanishWordDataEntity::class
    ],
    version = 1)

abstract class herenciadevocesDataBase : RoomDatabase() {
    abstract fun languageDAO():languageDAO
    abstract fun languageVariant():languageVariantDAO
    abstract fun languageWordDataDAO():languageWordDataDAO
    abstract fun semanticFieldDAO():semanticFieldDAO
    abstract fun spanishWordDataDAO():spanishWordDataDAO
}


