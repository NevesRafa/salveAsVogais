package com.kansha.salveasvogais.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kansha.salveasvogais.domain.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenViewModel(private val repository: WordRepository) : ViewModel() {

    fun loadList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insertStandardWords()
            }
        }
    }
}