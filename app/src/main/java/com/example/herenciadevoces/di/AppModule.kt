package com.example.herenciadevoces.di

import  android.content.Context
import  androidx.room.Room
import  com.example.herenciadevoces.data.local.dao.semanticFieldDAO
import  com.example.herenciadevoces.data.local.dao.spanishWordDataDAO
import  com.example.herenciadevoces.data.local.database.herenciadevocesDataBase
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
    fun providesherenciaDeVocesRoomDataBase(@ApplicationContext app:Context): herenciaDeVoces{
        val database = Room.databaseBuilder(
            app,
            herenciaDeVocesDataBase::class.java,
            name = "herenciaDeVocesDB.db"
        ).createFromAsset("database/herenciaDeVocesDB.db").build()
        return database
    }

    @Provides
    @Singleton
    fun providesSemanticFieldDao(HerenciaDevocesDataBase: herenciaDevocesDataBase) : SemanticFieldDAO = herenciadevocesDataBase.semanticFieldDAO()

    @Provides
    @Singleton
    fun providesSpanishWordDataDao(HerenciaDevocesDataBase: herenciaDevocesDataBase) : SpanishWordDatadDAO = herenciadevocesDataBase.spanishWordDataDAO()
