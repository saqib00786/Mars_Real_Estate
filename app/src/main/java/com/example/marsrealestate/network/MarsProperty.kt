package com.example.marsrealestate.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarsProperty (
    val id : String,
    val type: String,
    val price : Double,
    @Json(name = "img_src")
    val imgSrcUrl : String
        ) : Parcelable {
    enum class MarsApiStatus{
        LOADING,
        DONE,
        FAIL
    }

    val isRental
    get() = type == "rent"
}