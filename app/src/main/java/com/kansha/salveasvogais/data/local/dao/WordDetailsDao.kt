package com.kansha.salveasvogais.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kansha.salveasvogais.data.model.WordDetails

@Dao
interface WordDetailsDao {
    @Insert
    fun insertAll(list: List<WordDetails>)

    @Query("SELECT * FROM worddetails")
    fun getAllWords(): List<WordDetails>

    @Query("SELECT * FROM worddetails WHERE id = :wordId")
    fun getById(wordId: Int): WordDetails?

}