package com.chaubacho.mvvmrestaurantdemo

import android.app.Application
import com.chaubacho.mvvmrestaurantdemo.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    networkModule,
                    roomModule,
                    apiModule,
                    repositoryModule,
                    viewModelModule,
                )
            )
        }
    }
}
