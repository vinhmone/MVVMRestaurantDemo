package com.chaubacho.mvvmrestaurantdemo.di

import android.content.Context
import androidx.room.Room
import com.chaubacho.mvvmrestaurantdemo.data.source.local.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single { initAppDatabase(androidContext()) }
    single { get<AppDatabase>().restaurantDao() }
}

fun initAppDatabase(context: Context) =
    Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        AppDatabase.DATABASE_NAME
    ).build()
