package com.kansha.salveasvogais.internal

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SalveAsVogaisApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SalveAsVogaisApplication)
            modules(appModule)
        }
    }
}