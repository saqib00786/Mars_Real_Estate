package com.example.marsrealestate.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestate.PhotoGridAdapter
import com.example.marsrealestate.databinding.*

class OverviewMarsRealEstate : Fragment() {

    private var mBinding : FragmentOverviewMarsRealEstateBinding? = null
    private val binding get() = mBinding

    private val viewModel : OverviewMarsViewModel by lazy{
            ViewModelProvider(this).get(OverviewMarsViewModel::class.java)
        }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentOverviewMarsRealEstateBinding.inflate(inflater, container, false)



       /* val viewModel = ViewModelProvider(this).get(OverviewMarsViewModel::class.java)*/

        mBinding!!.overviewModel = viewModel
        mBinding!!.lifecycleOwner = this

        mBinding!!.recyclerViewID.adapter = PhotoGridAdapter()

       /* mBinding!!.TestBtnId.setOnClickListener {
            val action = OverviewMarsRealEstateDirections.actionOverviewMarsRealEstate2ToDetailMarsRealEstate()
            findNavController().navigate(action)
        }*/
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}