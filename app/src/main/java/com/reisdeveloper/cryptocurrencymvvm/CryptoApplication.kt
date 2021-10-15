package com.reisdeveloper.cryptocurrencymvvm

import android.app.Application
import com.reisdeveloper.cryptocurrencymvvm.di.cryptoDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CryptoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@CryptoApplication)
            modules(listOf(cryptoDataModule))
        }
    }
}