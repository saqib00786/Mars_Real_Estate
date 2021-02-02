package com.example.marsrealestate.network

import com.squareup.moshi.Json

data class MarsProperty (
    val id : String,
    val type: String,
    val price : Double,
    @Json(name = "img_src")
    val imgSrcUrl : String
        ){
    enum class MarsApiStatus{
        LOADING,
        DONE,
        FAIL
    }
}