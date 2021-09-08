package com.chaubacho.mvvmrestaurantdemo.base

interface BindData<T> {
    fun updateData(data: List<T>)
}
