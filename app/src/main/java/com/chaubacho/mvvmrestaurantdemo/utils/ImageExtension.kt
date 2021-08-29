package com.chaubacho.mvvmrestaurantdemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chaubacho.mvvmrestaurantdemo.R

@BindingAdapter("app:srcCorner")
fun ImageView.loadImageCorners(url: String?) {
    Glide.with(context)
        .load(url)
        .apply(RequestOptions.bitmapTransform(RoundedCorners(resources.getDimensionPixelSize(R.dimen.dp_6))))
        .error(R.drawable.ic_error)
        .placeholder(R.drawable.ic_holder)
        .into(this)
}

@BindingAdapter("app:imageOpenStatus")
fun ImageView.loadImageOpenStatus(complete: String?) {
    val src = when (complete) {
        resources.getString(R.string.value_open) -> R.drawable.ic_open
        resources.getString(R.string.values_close) -> R.drawable.ic_close
        else -> R.drawable.ic_error
    }
    Glide.with(context)
        .load(src)
        .error(R.drawable.ic_error)
        .into(this)
}
