package com.example.marsrealestate

import android.content.Context
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.marsrealestate.network.MarsProperty
import kotlinx.coroutines.withContext

@BindingAdapter("listData")
fun bindRecyclerViewA(recyclerView: RecyclerView,data:List<MarsProperty>?){
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}
@BindingAdapter("img_Url")
fun imgBindingAdapter(imgView : ImageView, imgUrl : String?){
    imgUrl?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions())
            .placeholder(R.drawable.loading_drawable)
            .error(R.drawable.error_pic)
            .into(imgView)
    }
}

@BindingAdapter("marsApiStatus")
fun marsApiStatus(statusImgView : ImageView,status : MarsProperty.MarsApiStatus?){
    when(status){
        MarsProperty.MarsApiStatus.LOADING->{
            statusImgView.visibility = View.VISIBLE
            statusImgView.setImageResource(R.drawable.loading_drawable)
        }
        MarsProperty.MarsApiStatus.FAIL->{
            statusImgView.visibility = View.VISIBLE
            statusImgView.setImageResource(R.drawable.error_pic)
        }
        MarsProperty.MarsApiStatus.DONE->{
            statusImgView.visibility = View.GONE
        }
    }
}