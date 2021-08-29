package com.chaubacho.mvvmrestaurantdemo.ui.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chaubacho.mvvmrestaurantdemo.base.BaseViewModel
import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import com.chaubacho.mvvmrestaurantdemo.data.repository.RestaurantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RestaurantViewModel(
    private val restaurantRepository: RestaurantRepository,
) : BaseViewModel() {

    private val _restaurants = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>>
        get() = _restaurants

    fun getData() {
        showLoading()
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            getAllRestaurant()
        }
        hideLoading()
    }

    private suspend fun getAllRestaurant() {
        restaurantRepository.getLocalRestaurants().also {
            _restaurants.postValue(it)
        }
    }
}
