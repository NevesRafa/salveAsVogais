package com.kansha.salveasvogais.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class WordDetails(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var word: String,
    var point: Int,
    var image: Int?
) : Parcelable