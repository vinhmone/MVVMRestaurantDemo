package com.chaubacho.mvvmrestaurantdemo.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

sealed class DaysInWeek {
    abstract val name: String

    @SerializedName("opens_at")
    open var opensAt: String = ""

    @SerializedName("closes_at")
    open var closesAt: String = ""

    @SerializedName("is_closed")
    open var isClosed: Boolean = false

    @Parcelize
    data class Monday(
        override val name: String = MONDAY
    ) : DaysInWeek(), Parcelable

    @Parcelize
    class Tuesday(
        override val name: String = TUESDAY
    ) : DaysInWeek(), Parcelable

    @Parcelize
    class Wednesday(
        override val name: String = WEDNESDAY
    ) : DaysInWeek(), Parcelable

    @Parcelize
    class Thursday(
        override val name: String = THURSDAY
    ) : DaysInWeek(), Parcelable

    @Parcelize
    class Friday(
        override val name: String = FRIDAY
    ) : DaysInWeek(), Parcelable

    @Parcelize
    class Saturday(
        override val name: String = SATURDAY
    ) : DaysInWeek(), Parcelable

    @Parcelize
    class Sunday(
        override val name: String = SUNDAY
    ) : DaysInWeek(), Parcelable

    companion object {
        private const val MONDAY = "Monday"
        private const val TUESDAY = "Tuesday"
        private const val WEDNESDAY = "Wednesday"
        private const val THURSDAY = "Thursday"
        private const val FRIDAY = "Friday"
        private const val SATURDAY = "Saturday"
        private const val SUNDAY = "Sunday"
    }
}
