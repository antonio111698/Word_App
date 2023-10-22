package com.tonio.wordapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tonio.wordapp.model.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordsDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDAO

}