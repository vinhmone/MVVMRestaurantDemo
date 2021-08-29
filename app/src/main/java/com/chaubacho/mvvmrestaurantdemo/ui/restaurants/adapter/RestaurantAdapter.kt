package com.chaubacho.mvvmrestaurantdemo.ui.restaurants.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chaubacho.mvvmrestaurantdemo.R
import com.chaubacho.mvvmrestaurantdemo.base.BaseAdapter
import com.chaubacho.mvvmrestaurantdemo.base.BaseViewHolder
import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import com.chaubacho.mvvmrestaurantdemo.databinding.ItemRestaurantBinding

class RestaurantAdapter(
    private val onItemClick: (Restaurant) -> Unit
) : BaseAdapter<Restaurant, RestaurantAdapter.RestaurantViewHolder>(
    mutableListOf(),
    Restaurant.diffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RestaurantViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_restaurant,
                parent,
                false
            ), onItemClick
        )

    class RestaurantViewHolder(
        private val viewBinding: ItemRestaurantBinding,
        onItemClick: (Restaurant) -> Unit,
    ) : BaseViewHolder<Restaurant>(viewBinding, onItemClick) {

        override fun bindData(item: Restaurant) {
            super.bindData(item)
            viewBinding.restaurant = item
        }
    }
}
