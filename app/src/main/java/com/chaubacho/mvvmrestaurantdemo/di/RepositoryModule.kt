package com.chaubacho.mvvmrestaurantdemo.di

import com.chaubacho.mvvmrestaurantdemo.data.repository.RestaurantRepository
import com.chaubacho.mvvmrestaurantdemo.data.repository.RestaurantRepositoryImpl
import com.chaubacho.mvvmrestaurantdemo.data.source.RestaurantDataSource
import com.chaubacho.mvvmrestaurantdemo.data.source.local.RestaurantLocalDataSource
import com.chaubacho.mvvmrestaurantdemo.data.source.remote.RestaurantRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single<RestaurantDataSource.Local> { RestaurantLocalDataSource(get()) }
    single<RestaurantDataSource.Remote> { RestaurantRemoteDataSource(get()) }
    single<RestaurantRepository> { RestaurantRepositoryImpl(get(), get()) }
}
