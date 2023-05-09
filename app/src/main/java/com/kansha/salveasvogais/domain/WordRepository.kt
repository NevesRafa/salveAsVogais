package com.kansha.salveasvogais.domain

import com.kansha.salveasvogais.data.local.dao.WordDetailsDao
import com.kansha.salveasvogais.data.model.WordDetails
import com.kansha.salveasvogais.data.standardWords

class WordRepository(private val database: WordDetailsDao) {

    fun insertStandardWords() {
        val wordList = database.getAllWords()

        if (wordList.isEmpty()) {
            database.insertAll(standardWords)
        }
    }

    fun getWordList(): List<WordDetails> {
        return database.getAllWords()
    }

    fun loadWord(id: Int): WordDetails? {
        return database.getById(id)
    }
}