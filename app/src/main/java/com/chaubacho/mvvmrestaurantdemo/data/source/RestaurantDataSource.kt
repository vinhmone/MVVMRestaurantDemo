package com.chaubacho.mvvmrestaurantdemo.data.source

import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant

interface RestaurantDataSource {

    interface Local {
        suspend fun getLocalRestaurants(): List<Restaurant>
        suspend fun insertRestaurant(restaurant: Restaurant)
        suspend fun deleteRestaurant(restaurant: Restaurant)
        suspend fun isFavorite(id: Int): Boolean
    }

    interface Remote {
        suspend fun getRemoteRestaurants(): List<Restaurant>
    }
}
