package com.tonio.wordapp.di

import com.tonio.wordapp.WordRepository
import com.tonio.wordapp.WordRepositoryImpl
import com.tonio.wordapp.database.WordDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object WordsModule {

    @Provides
    fun provideWordRepository(wordDAO: WordDAO) :  WordRepository{
        return WordRepositoryImpl(wordDAO)
    }

}