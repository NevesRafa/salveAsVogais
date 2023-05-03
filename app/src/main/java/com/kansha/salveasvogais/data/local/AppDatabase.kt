package com.kansha.salveasvogais.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kansha.salveasvogais.data.local.dao.WordDetailsDao
import com.kansha.salveasvogais.data.model.WordDetails

@Database(entities = [WordDetails::class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun salveAsVogais(): WordDetailsDao
}
