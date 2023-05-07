package com.kansha.salveasvogais.domain

import com.kansha.salveasvogais.R
import com.kansha.salveasvogais.data.local.dao.WordDetailsDao
import com.kansha.salveasvogais.data.model.WordDetails

class WordRepository(private val database: WordDetailsDao) {

    fun insertStandardWords() {
        val wordList = database.getAllWords()
        val standardWords = listOf(
            WordDetails(word = "Cão", point = 10, id = 0L, image = R.raw.dog),
            WordDetails(word = "Pão", point = 10, id = 0L, image = R.raw.bread),
            WordDetails(word = "Lua", point = 10, id = 0L, image = R.raw.moon),
            WordDetails(word = "Rato", point = 10, id = 0L, image = R.raw.mouse),
            WordDetails(word = "Sapo", point = 10, id = 0L, image = R.raw.frog),
            WordDetails(word = "Foca", point = 10, id = 0L, image = null),
            WordDetails(word = "Bola", point = 10, id = 0L, image = null),
            WordDetails(word = "Gato", point = 10, id = 0L, image = null),
            WordDetails(word = "Lobo", point = 10, id = 0L, image = null),
            WordDetails(word = "Sol", point = 10, id = 0L, image = null),
            WordDetails(word = "Vaca", point = 10, id = 0L, image = null),
            WordDetails(word = "Tigre", point = 10, id = 0L, image = null),
            WordDetails(word = "Abelha", point = 10, id = 0L, image = null),
            WordDetails(word = "Girafa", point = 10, id = 0L, image = null),
            WordDetails(word = "Elefante", point = 10, id = 0L, image = null),
            WordDetails(word = "Coelho", point = 10, id = 0L, image = null),
            WordDetails(word = "Leão", point = 10, id = 0L, image = null),
            WordDetails(word = "Jacaré", point = 10, id = 0L, image = null),
            WordDetails(word = "Borboleta", point = 10, id = 0L, image = null),
            WordDetails(word = "Macaco", point = 10, id = 0L, image = null),
            WordDetails(word = "Melancia", point = 10, id = 0L, image = null),
            WordDetails(word = "Arco-íris", point = 10, id = 0L, image = null),
            WordDetails(word = "Flamingo", point = 10, id = 0L, image = null),
            WordDetails(word = "Hipopótamo", point = 10, id = 0L, image = null),
            WordDetails(word = "Pinguim", point = 10, id = 0L, image = null),
            WordDetails(word = "Morango", point = 10, id = 0L, image = null),
            WordDetails(word = "Esquilo", point = 10, id = 0L, image = null),
            WordDetails(word = "Zebra", point = 10, id = 0L, image = null),
            WordDetails(word = "Papagaio", point = 10, id = 0L, image = null),
            WordDetails(word = "Dinossauro", point = 10, id = 0L, image = null)
        )
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