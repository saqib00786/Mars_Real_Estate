package com.example.marsrealestate.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.marsrealestate.R
import com.example.marsrealestate.databinding.FragmentOverviewMarsRealEstateBinding

class OverviewMarsRealEstate : Fragment() {
    private var mBinding : FragmentOverviewMarsRealEstateBinding? = null
    private val binding get() = mBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentOverviewMarsRealEstateBinding.inflate(inflater,container,false)

        mBinding!!.TestBtnId.setOnClickListener {
            val action = OverviewMarsRealEstateDirections.actionOverviewMarsRealEstate2ToDetailMarsRealEstate()
            findNavController().navigate(action)
        }
        return binding?.root
    }
}