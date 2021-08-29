@file:Suppress("UNCHECKED_CAST")

package com.chaubacho.mvvmrestaurantdemo.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chaubacho.mvvmrestaurantdemo.base.BindData

@BindingAdapter("app:data")
fun <T> RecyclerView.setDataRecyclerView(data: List<T>?) {
    if (adapter is BindData<*> && data != null) {
        (adapter as BindData<T>).updateData(data)
    }
}
