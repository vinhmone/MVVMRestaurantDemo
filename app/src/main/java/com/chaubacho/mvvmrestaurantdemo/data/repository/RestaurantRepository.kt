package com.chaubacho.mvvmrestaurantdemo.data.repository

import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant

interface RestaurantRepository {
    suspend fun getLocalRestaurants(): List<Restaurant>
    suspend fun insertRestaurant(restaurant: Restaurant)
    suspend fun deleteRestaurant(restaurant: Restaurant)
    suspend fun isFavorite(id: Int): Boolean

    suspend fun getRemoteRestaurants(): List<Restaurant>
}
