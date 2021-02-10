package com.example.marsrealestate.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marsrealestate.PhotoGridAdapter
import com.example.marsrealestate.R
import com.example.marsrealestate.databinding.*
import com.example.marsrealestate.network.MarsApiFilter

class OverviewMarsRealEstate : Fragment() {

    private var mBinding: FragmentOverviewMarsRealEstateBinding? = null
    private val binding get() = mBinding

    private val viewModel: OverviewMarsViewModel by lazy {
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

        mBinding!!.recyclerViewID.adapter = PhotoGridAdapter(PhotoGridAdapter.OnListener {
            viewModel.displayPropertyDetail(it)
        })

        viewModel.navigateToDetailFragment.observe(viewLifecycleOwner) {
            if (null != it) {
                this.findNavController().navigate(
                    OverviewMarsRealEstateDirections.actionOverviewMarsRealEstate2ToDetailMarsRealEstate(
                        it
                    )
                )
                viewModel.displayPropertyDetailCompelete()
            }
        }

        /* mBinding!!.TestBtnId.setOnClickListener {
             val action = OverviewMarsRealEstateDirections.actionOverviewMarsRealEstate2ToDetailMarsRealEstate()
             findNavController().navigate(action)
         }*/
        return binding?.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sort_menu_overview, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilter(
            when(item.itemId){
                R.id.showById -> MarsApiFilter.SHOW_BUY
                R.id.showRentId -> MarsApiFilter.SHOW_RENT
                else -> MarsApiFilter.SHOW_ALL
            }
        )
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}