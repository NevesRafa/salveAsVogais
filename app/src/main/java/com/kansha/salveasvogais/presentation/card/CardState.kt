package com.kansha.salveasvogais.presentation.card

import com.kansha.salveasvogais.data.model.WordDetails

sealed class CardState {

    object Loading : CardState()

    data class Success(val result: WordDetails?) : CardState()

    data class Error(val errorMessage: String?) : CardState()

}