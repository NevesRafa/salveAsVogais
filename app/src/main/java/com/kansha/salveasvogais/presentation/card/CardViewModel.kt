package com.kansha.salveasvogais.presentation.card


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kansha.salveasvogais.data.model.WordDetails

class CardViewModel : ViewModel() {

    val cardLiveData = MutableLiveData<CardState>()
    lateinit var cardDetails: WordDetails
    var word = ""
    private var wordWithoutVowel = ""

    fun initGame(cardDetails: WordDetails) {
        this.cardDetails = cardDetails
        loadCardDetails()
    }

    fun loadCardDetails() {

        word = cardDetails.word.uppercase()
        wordWithoutVowel = word.replace("[AÂÃÁEÉÊIÍOÓÕÔUÚ]".toRegex(), "_")

        cardLiveData.postValue(CardState.InitGame(wordWithoutVowel, cardDetails.image!!))
    }

    fun updateWordWithoutVowel(letter: String) {

        val index = wordWithoutVowel.indexOf("_")

        // Verifica se a palavra contém a letra clicada e se ainda existem "_" para serem substituídos
        if (index >= 0) {
            val updatedWord = wordWithoutVowel.substring(0, index) + letter + wordWithoutVowel.substring(index + 1)
            wordWithoutVowel = updatedWord
            cardLiveData.postValue(CardState.UpdateWord(wordWithoutVowel))
        }
    }

    fun checkWord() {
        if (word == wordWithoutVowel) {
            cardLiveData.postValue(CardState.GameWon)
        } else
            cardLiveData.postValue(CardState.LostGame)
    }
}