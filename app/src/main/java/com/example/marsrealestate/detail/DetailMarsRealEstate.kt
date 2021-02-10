package com.example.marsrealestate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestate.databinding.FragmentDetailMarsRealEstateBinding
import retrofit2.Invocation.of

class DetailMarsRealEstate : Fragment() {
    private var mBinding : FragmentDetailMarsRealEstateBinding? = null
    private val binding get() = mBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDetailMarsRealEstateBinding.inflate(inflater,container,false)

        mBinding!!.lifecycleOwner = this
        val application = requireNotNull(activity).application
        val marsProperty = DetailMarsRealEstateArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailMarsViewModelFactory(marsProperty,application)

        mBinding!!.detailViewModel = ViewModelProvider(this,viewModelFactory).get(DetailMarsViewModel::class.java)

        return binding?.root
    }
}