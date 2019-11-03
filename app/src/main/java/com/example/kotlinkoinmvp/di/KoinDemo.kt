package com.example.kotlinkoinmvp.di

import android.app.Application
import com.example.kotlinkoinmvp.di.myModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinDemo : Application() {
    override fun onCreate() {
        super.onCreate()
          startKoin {
            androidContext(this@KoinDemo)
            modules(myModule)
            //modules(mySecoundModule)
        }
    }
}