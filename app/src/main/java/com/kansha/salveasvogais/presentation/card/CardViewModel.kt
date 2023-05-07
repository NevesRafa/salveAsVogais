package com.kansha.salveasvogais.presentation.card

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CardViewModel : ViewModel() {

    val wordLiveData = MutableLiveData<CardState>()

}