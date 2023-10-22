package com.tonio.wordapp

import com.tonio.wordapp.database.WordDAO
import com.tonio.wordapp.model.Word
import javax.inject.Inject

class WordRepositoryImpl(private val wordDAO: WordDAO) : WordRepository {
    override suspend fun insertWords(word: Word) {
        wordDAO.insertWord(word)
    }

    override suspend fun getAllWords(): List<Word> {
        return wordDAO.getAllWords()
    }
}