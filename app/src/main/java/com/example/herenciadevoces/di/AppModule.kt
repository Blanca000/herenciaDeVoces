package com.example.herenciadevoces.di

import android.content.Context
import androidx.room.Room
import com.example.herenciadevoces.data.local.dao.languageDAO
import com.example.herenciadevoces.data.local.dao.languageVariantDAO
import com.example.herenciadevoces.data.local.dao.languageWordDataDAO
import com.example.herenciadevoces.data.local.dao.semanticFieldDAO
import com.example.herenciadevoces.data.local.dao.spanishWordDataDAO
import com.example.herenciadevoces.data.local.database.herenciadevocesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesherenciaDeVocesRoomDataBase(@ApplicationContext app: Context): herenciadevocesDataBase {
        val database = Room.databaseBuilder(
            app,
            herenciadevocesDataBase::class.java,
            name = "herenciaDeVocesDB.db"
        ).createFromAsset("database/herenciaDeVocesDB.db").build()
        return database
    }

    @Provides
    @Singleton
    fun providesSemanticFieldDao(herenciadevocesDataBase: herenciadevocesDataBase) : semanticFieldDAO = herenciadevocesDataBase.semanticFieldDAO()

    @Provides
    @Singleton
    fun providesLanguageDao(herenciadevocesDataBase: herenciadevocesDataBase) : languageDAO = herenciadevocesDataBase.languageDAO()

    @Provides
    @Singleton
    fun providesLanguageVariantDao(herenciadevocesDataBase: herenciadevocesDataBase) : languageVariantDAO = herenciadevocesDataBase.languageVariant()

    @Provides
    @Singleton
    fun providesLanguageWordDataDao(herenciadevocesDataBase: herenciadevocesDataBase) : languageWordDataDAO = herenciadevocesDataBase.languageWordDataDAO()

    @Provides
    @Singleton
    fun providesSpanishWordDataDao(herenciadevocesDataBase: herenciadevocesDataBase) : spanishWordDataDAO = herenciadevocesDataBase.spanishWordDataDAO()
}