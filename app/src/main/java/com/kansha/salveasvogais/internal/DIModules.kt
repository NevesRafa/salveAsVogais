package com.kansha.salveasvogais.internal

import androidx.room.Room
import com.kansha.salveasvogais.data.local.AppDatabase
import com.kansha.salveasvogais.domain.WordRepository
import com.kansha.salveasvogais.presentation.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
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

    // repository
    factory { WordRepository(get()) }

    //viewmodels
    viewModel { SplashScreenViewModel(get()) }
}