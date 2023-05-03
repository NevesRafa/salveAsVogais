package com.kansha.salveasvogais.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordDetails(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var word: String,
    var point: Int,
    var image: Int?
)