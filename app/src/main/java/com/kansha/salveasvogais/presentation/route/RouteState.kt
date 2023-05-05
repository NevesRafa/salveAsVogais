package com.kansha.salveasvogais.presentation.route

import com.kansha.salveasvogais.data.model.WordDetails

sealed class RouteState {

    object Loading : RouteState()

    data class Success(val result: List<WordDetails>) : RouteState()

    data class Error(val errorMessage: String?) : RouteState()
}