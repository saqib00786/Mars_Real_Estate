package com.example.marsrealestate.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestate.network.MarsProperty

class DetailMarsViewModelFactory(
    private val marsProperty: MarsProperty,
    private val application: Application
) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailMarsViewModel::class.java)){
            return DetailMarsViewModel(marsProperty,application) as T
        }
        throw IllegalArgumentException("Unknown Model Class")
    }

}