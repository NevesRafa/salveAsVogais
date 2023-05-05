package com.kansha.salveasvogais.presentation.route

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kansha.salveasvogais.domain.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RouteViewModel(private val repository: WordRepository) : ViewModel() {

    val loadStateLiveData = MutableLiveData<RouteState>()

    fun loadWordList() {
        viewModelScope.launch {
            loadStateLiveData.postValue(RouteState.Loading)

            try {
                val wordList = withContext(Dispatchers.IO) {
                    repository.getWordList()
                }
                loadStateLiveData.postValue(RouteState.Success(wordList))
            } catch (error: Exception) {
                loadStateLiveData.postValue(RouteState.Error(error.message))
            }
        }
    }
}