package com.chaubacho.mvvmrestaurantdemo.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chaubacho.mvvmrestaurantdemo.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }
    val isLoading: LiveData<Boolean>
        get() = _isLoading
    private val _message = MutableLiveData<@StringRes Int>()
    val message: LiveData<Int>
        get() = _message
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    protected val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        viewModelScope.launch {
            _message.value = R.string.error_binding
            throwable.printStackTrace()
        }
    }

    fun showLoading() {
        _isLoading.value = true
    }

    fun hideLoading() {
        _isLoading.value = false
    }
}
