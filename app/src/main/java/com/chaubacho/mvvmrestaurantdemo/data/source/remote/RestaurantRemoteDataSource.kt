package com.chaubacho.mvvmrestaurantdemo.data.source.remote

import com.chaubacho.mvvmrestaurantdemo.data.source.RestaurantDataSource
import com.chaubacho.mvvmrestaurantdemo.data.source.remote.utils.ApiService

class RestaurantRemoteDataSource(
    private val apiService: ApiService,
) : RestaurantDataSource.Remote {

    override suspend fun getRemoteRestaurants() =
        apiService.getRemoteRestaurants()
}
