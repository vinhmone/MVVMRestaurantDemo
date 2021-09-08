package com.chaubacho.mvvmrestaurantdemo.data.source.remote.utils

import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiConfig.BASE_RESTAURANT)
    suspend fun getRemoteRestaurants(
        @Query(ApiConfig.PARAM_SIZE) item: String = ApiConfig.DEFAULT_ITEM
    ): List<Restaurant>
}
