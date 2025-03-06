package com.example.crypto

import android.app.Application
import com.example.crypto.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptoTrackerApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@CryptoTrackerApp)
             androidLogger()
            modules(appModule)
        }
    }
}