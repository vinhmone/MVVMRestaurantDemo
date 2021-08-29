package com.chaubacho.mvvmrestaurantdemo.ui.restaurantdetail

import androidx.navigation.fragment.navArgs
import com.chaubacho.mvvmrestaurantdemo.R
import com.chaubacho.mvvmrestaurantdemo.base.BaseFragment
import com.chaubacho.mvvmrestaurantdemo.databinding.FragmentRestaurantDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestaurantDetailFragment : BaseFragment<FragmentRestaurantDetailBinding>() {

    override val layoutResource get() = R.layout.fragment_restaurant_detail
    override val viewModel: RestaurantDetailViewModel by viewModel()
    private val arg: RestaurantDetailFragmentArgs by navArgs()

    override fun initViews() {
    }

    override fun initData() {
        viewModel.apply {
            setData(arg.restaurant)
            isFavorite(arg.restaurant.id)
        }
        viewBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            restaurantDetailVM = viewModel
        }
    }

    override fun initEvents() {
        viewBinding.imageIsFavorite.setOnClickListener {
            viewModel.changeFavoriteStatus()
        }
    }

    override fun showLoading() {}

    override fun hideLoading() {}
}
