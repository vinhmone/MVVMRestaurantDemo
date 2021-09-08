package com.chaubacho.mvvmrestaurantdemo.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chaubacho.mvvmrestaurantdemo.data.model.Restaurant.Companion.RESTAURANT_TABLE_NAME
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = RESTAURANT_TABLE_NAME)
data class Restaurant(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "restaurantID")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("review")
    val review: String,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("phone_number")
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("hours")
    @Embedded(prefix = "hours_")
    val hours: Hours,
) : Parcelable {

    companion object {
        const val RESTAURANT_TABLE_NAME = "restaurant"
        val diffUtil = object : DiffUtil.ItemCallback<Restaurant>() {
            override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
                oldItem == newItem
        }
    }
}
