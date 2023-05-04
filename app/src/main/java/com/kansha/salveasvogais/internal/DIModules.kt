package com.kansha.salveasvogais.internal

import androidx.room.Room
import com.kansha.salveasvogais.data.local.AppDatabase
import org.koin.dsl.module

const val DATABASE_NAME = "salveAsVogais.db"

val appModule = module {

    //database
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    single { get<AppDatabase>().wordDetailsDao() }
}