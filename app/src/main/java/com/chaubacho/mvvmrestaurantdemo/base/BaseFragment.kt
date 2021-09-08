package com.chaubacho.mvvmrestaurantdemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.chaubacho.mvvmrestaurantdemo.R
import com.chaubacho.mvvmrestaurantdemo.utils.showToast

abstract class BaseFragment<V : ViewDataBinding> : Fragment() {

    @get:LayoutRes
    protected abstract val layoutResource: Int
    abstract val viewModel: BaseViewModel
    private var _viewBinding: V? = null
    protected val viewBinding: V
        get() = _viewBinding ?: throw Exception(getString(R.string.error_binding))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = DataBindingUtil
        .inflate<V>(inflater, layoutResource, container, false)
        .apply { _viewBinding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initViews()
        initData()
        initEvents()
    }

    protected abstract fun initViews()

    protected abstract fun initData()

    protected abstract fun initEvents()

    protected open fun observeViewModel() = with(viewModel) {
        isLoading.observe(viewLifecycleOwner, Observer(::handleLoading))
        message.observe(viewLifecycleOwner, {
            hideLoading()
            if (getString(it).isNotBlank()) context?.showToast(getString(it))
        })
    }

    private fun handleLoading(isLoading: Boolean?) =
        if (isLoading == true) showLoading() else hideLoading()

    abstract fun showLoading()

    abstract fun hideLoading()

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}
