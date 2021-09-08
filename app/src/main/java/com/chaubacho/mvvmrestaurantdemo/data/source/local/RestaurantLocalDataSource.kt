package com.chaubacho.mvvmrestaurantdemo.data.source.local

import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import com.chaubacho.mvvmrestaurantdemo.data.source.RestaurantDataSource

class RestaurantLocalDataSource(
    private val restaurantDAO: RestaurantDAO,
) : RestaurantDataSource.Local {

    override suspend fun getLocalRestaurants() =
        restaurantDAO.getLocalRestaurants()

    override suspend fun insertRestaurant(restaurant: Restaurant) =
        restaurantDAO.insertRestaurant(restaurant)

    override suspend fun deleteRestaurant(restaurant: Restaurant) =
        restaurantDAO.deleteRestaurant(restaurant)

    override suspend fun isFavorite(id: Int) =
        restaurantDAO.isFavorite(id) > 0
}
