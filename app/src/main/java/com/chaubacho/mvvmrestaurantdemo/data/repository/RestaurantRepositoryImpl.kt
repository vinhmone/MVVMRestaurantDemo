package com.chaubacho.mvvmrestaurantdemo.data.repository

import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import com.chaubacho.mvvmrestaurantdemo.data.source.RestaurantDataSource

class RestaurantRepositoryImpl(
    private val local: RestaurantDataSource.Local,
    private val remote: RestaurantDataSource.Remote,
) : RestaurantRepository {

    override suspend fun getLocalRestaurants() =
        local.getLocalRestaurants()

    override suspend fun insertRestaurant(restaurant: Restaurant) =
        local.insertRestaurant(restaurant)

    override suspend fun deleteRestaurant(restaurant: Restaurant) =
        local.deleteRestaurant(restaurant)

    override suspend fun isFavorite(id: Int) =
        local.isFavorite(id)

    override suspend fun getRemoteRestaurants() =
        remote.getRemoteRestaurants()
}
