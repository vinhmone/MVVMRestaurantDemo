package com.chaubacho.mvvmrestaurantdemo.data.model

import android.os.Parcelable
import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hours(
    @SerializedName("monday")
    @Embedded(prefix = "monday_")
    val monday: DaysInWeek.Monday,
    @SerializedName("tuesday")
    @Embedded(prefix = "tuesday_")
    val tuesday: DaysInWeek.Tuesday,
    @SerializedName("wednesday")
    @Embedded(prefix = "wednesday_")
    val wednesday: DaysInWeek.Wednesday,
    @SerializedName("thursday")
    @Embedded(prefix = "thursday_")
    val thursday: DaysInWeek.Thursday,
    @SerializedName("friday")
    @Embedded(prefix = "friday_")
    val friday: DaysInWeek.Friday,
    @SerializedName("saturday")
    @Embedded(prefix = "saturday_")
    val saturday: DaysInWeek.Saturday,
    @SerializedName("sunday")
    @Embedded(prefix = "sunday_")
    val sunday: DaysInWeek.Sunday,
) : Parcelable
