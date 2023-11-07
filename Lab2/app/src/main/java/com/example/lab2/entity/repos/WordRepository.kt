package com.example.lab2.entity.repos

import androidx.annotation.WorkerThread
import com.example.lab2.entity.Word
import com.example.lab2.entity.dao.WordDao
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}