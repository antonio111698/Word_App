package com.tonio.wordapp

import com.tonio.wordapp.model.Word

interface WordRepository {
    suspend fun insertWords(word: Word)
    suspend fun getAllWords(): List<Word>
}