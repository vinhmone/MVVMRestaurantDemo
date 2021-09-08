package com.chaubacho.mvvmrestaurantdemo.ui.restaurants

import androidx.navigation.fragment.findNavController
import com.chaubacho.mvvmrestaurantdemo.R
import com.chaubacho.mvvmrestaurantdemo.base.BaseFragment
import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant
import com.chaubacho.mvvmrestaurantdemo.databinding.FragmentRestaurantBinding
import com.chaubacho.mvvmrestaurantdemo.ui.restaurants.adapter.RestaurantAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestaurantFragment : BaseFragment<FragmentRestaurantBinding>() {

    override val layoutResource get() = R.layout.fragment_restaurant
    override val viewModel: RestaurantViewModel by viewModel()
    private val adapter = RestaurantAdapter(::clickItemRestaurant)

    override fun initViews() {
        viewBinding.recyclerRestaurant.adapter = adapter
    }

    override fun initData() {
        viewModel.getData()
        with(viewBinding) {
            lifecycleOwner = viewLifecycleOwner
            restaurantVM = viewModel
        }
    }

    override fun initEvents() {}

    override fun showLoading() {}

    override fun hideLoading() {}

    private fun clickItemRestaurant(restaurant: Restaurant) {
        val action =
            RestaurantFragmentDirections.actionRestaurantFragmentToRestaurantDetailFragment(
                restaurant
            )
        findNavController().navigate(action)
    }
}
