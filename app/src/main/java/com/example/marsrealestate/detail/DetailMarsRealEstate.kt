package com.example.marsrealestate.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marsrealestate.R
import com.example.marsrealestate.databinding.FragmentDetailMarsRealEstateBinding

class DetailMarsRealEstate : Fragment() {
    private var mBinding : FragmentDetailMarsRealEstateBinding? = null
    private val binding get() = mBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDetailMarsRealEstateBinding.inflate(inflater,container,false)

        return binding?.root
    }
}