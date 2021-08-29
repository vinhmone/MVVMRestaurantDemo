package com.chaubacho.mvvmrestaurantdemo.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant.Companion.RESTAURANT_TABLE_NAME

@Dao
interface RestaurantDAO {

    @Query("SELECT * FROM $RESTAURANT_TABLE_NAME")
    suspend fun getLocalRestaurants(): List<Restaurant>

    @Insert
    suspend fun insertRestaurant(restaurant: Restaurant)

    @Delete
    suspend fun deleteRestaurant(restaurant: Restaurant)

    @Query("SELECT COUNT(*) FROM $RESTAURANT_TABLE_NAME WHERE restaurantID = :id")
    suspend fun isFavorite(id: Int): Int
}
