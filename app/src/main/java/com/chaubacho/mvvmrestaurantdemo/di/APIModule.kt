package com.chaubacho.mvvmrestaurantdemo.di

import com.chaubacho.mvvmrestaurantdemo.data.source.remote.utils.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(ApiService::class.java) }
}
