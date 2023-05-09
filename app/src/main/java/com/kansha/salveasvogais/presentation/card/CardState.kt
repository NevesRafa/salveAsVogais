package com.kansha.salveasvogais.presentation.card

sealed class CardState {

    data class InitGame(val word: String, val image: Int) : CardState()
    data class UpdateWord(val word: String) : CardState()
    object GameWon : CardState()
    object LostGame : CardState()
}