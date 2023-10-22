package com.tonio.wordapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tonio.wordapp.model.Word
import javax.inject.Inject

class WordsViewModel @Inject constructor(
    private val wordsRepository: WordRepository
): ViewModel() {

    fun saveWord(word: String) = liveData {
        try {
            wordsRepository.insertWords(Word(0, word))
            emit(true)
        }catch (e: Exception){
            emit(false)
        }
    }

    fun getAllWords() = liveData<List<Word>>{
        emit(wordsRepository.getAllWords())
    }

}