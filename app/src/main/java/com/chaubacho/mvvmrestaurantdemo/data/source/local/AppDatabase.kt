package com.chaubacho.mvvmrestaurantdemo.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import com.chaubacho.mvvmrestaurantdemo.data.source.local.AppDatabase.Companion.DATABASE_VERSION
import com.chaubacho.mvvmrestaurantdemo.data.source.local.AppDatabase.Companion.EXPORT_SCHEME

@Database(
    entities = [Restaurant::class],
    version = DATABASE_VERSION,
    exportSchema = EXPORT_SCHEME
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDAO

    companion object {
        const val DATABASE_NAME = "MVVMRestaurant"
        const val DATABASE_VERSION = 1
        const val EXPORT_SCHEME = false
    }
}
