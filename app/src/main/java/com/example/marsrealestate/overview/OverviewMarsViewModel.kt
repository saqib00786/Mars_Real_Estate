package com.example.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marsrealestate.network.MarsApi
import com.example.marsrealestate.network.MarsProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class OverviewMarsViewModel : ViewModel() {
    private val _status = MutableLiveData<MarsProperty.MarsApiStatus>()
    val status: LiveData<MarsProperty.MarsApiStatus> = _status

    private val _properties = MutableLiveData<List<MarsProperty>>()
    val properties: LiveData<List<MarsProperty>> = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getResponseProperties()
    }

    private fun getResponseProperties() {

        coroutineScope.launch {
            val getPropertiesDeferred = MarsApi.retrofitService.getProperties()
            try {
                MarsProperty.MarsApiStatus.LOADING
                val listResult = getPropertiesDeferred
                _status.value = MarsProperty.MarsApiStatus.DONE
                _properties.value=listResult
            } catch (e: Exception) {
                _status.value = MarsProperty.MarsApiStatus.FAIL
                _properties.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}