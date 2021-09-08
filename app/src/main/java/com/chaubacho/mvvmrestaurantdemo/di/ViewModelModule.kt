package com.chaubacho.mvvmrestaurantdemo.di

import com.chaubacho.mvvmrestaurantdemo.ui.restaurantdetail.RestaurantDetailViewModel
import com.chaubacho.mvvmrestaurantdemo.ui.restaurants.RestaurantViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { RestaurantViewModel(get()) }
    single { RestaurantDetailViewModel(get()) }
}
