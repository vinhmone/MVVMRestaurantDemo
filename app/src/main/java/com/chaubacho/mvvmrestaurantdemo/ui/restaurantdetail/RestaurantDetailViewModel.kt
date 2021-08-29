package com.chaubacho.mvvmrestaurantdemo.ui.restaurantdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.chaubacho.mvvmrestaurantdemo.base.BaseViewModel
import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import com.chaubacho.mvvmrestaurantdemo.data.repository.RestaurantRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RestaurantDetailViewModel(
    private val restaurantRepository: RestaurantRepository,
) : BaseViewModel() {

    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant>
        get() = _restaurant
    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean>
        get() = _isFavorite

    fun setData(restaurant: Restaurant) {
        _restaurant.postValue(restaurant)
    }

    fun changeFavoriteStatus() {
        _restaurant.value?.let {
            if (_isFavorite.value == true) {
                deleteRestaurant(it)
            } else {
                insertRestaurant(it)
            }
        }
    }

    private fun insertRestaurant(restaurant: Restaurant) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            restaurantRepository.insertRestaurant(restaurant)
            _isFavorite.postValue(true)
        }
    }

    private fun deleteRestaurant(restaurant: Restaurant) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            restaurantRepository.deleteRestaurant(restaurant)
            _isFavorite.postValue(false)
        }
    }

    fun isFavorite(id: Int) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val result = restaurantRepository.isFavorite(id)
            _isFavorite.postValue(result)

        }
    }
}
