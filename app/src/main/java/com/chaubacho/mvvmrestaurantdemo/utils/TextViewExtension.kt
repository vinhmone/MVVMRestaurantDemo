package com.chaubacho.mvvmrestaurantdemo.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.chaubacho.mvvmrestaurantdemo.data.model.Hours

@BindingAdapter("app:textOpen")
fun TextView.setOpenDays(hours: Hours?) {
    var openDays = ""
    hours?.let {
        listOf(
            it.monday,
            it.tuesday,
            it.wednesday,
            it.thursday,
            it.friday,
            it.saturday,
            it.sunday
        ).forEach { weekday ->
            if (!weekday.isClosed) openDays += "${weekday.name}, "
        }
    }
    openDays = openDays.removeSuffix(", ")
    text = openDays
}
