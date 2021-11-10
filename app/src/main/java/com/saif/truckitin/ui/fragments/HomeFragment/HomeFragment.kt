package com.saif.truckitin.ui.fragments.HomeFragment

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.saif.truckitin.BR
import com.saif.truckitin.R
import com.saif.truckitin.baseclasses.BaseFragment
import com.saif.truckitin.data.models.ProductModel
import com.saif.truckitin.data.remote.Resource
import com.saif.truckitin.databinding.FragmentHomeBinding
import com.saif.truckitin.utils.DialogHelperClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.bottom_sheet_music_player.*
import kotlinx.android.synthetic.main.bottom_sheet_music_player.view.*
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {


    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewModel: Class<HomeViewModel>
        get() = HomeViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel

    lateinit var productListAdapter: ProductIstAdapter
    lateinit var bottomSheetProductInfo: BottomSheetBehavior<RelativeLayout>
    var selectedProductModel: ProductModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.hitGetMusicAPI()
        initAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        mViewDataBinding.productList.adapter = productListAdapter
    }

    private fun initAdapter() {
        productListAdapter = ProductIstAdapter(object : ProductIstAdapter.OnItemClickListener {
            override fun onItemClick(itemPosition: Int, productModel: ProductModel) {

//                selectedProductModel = productModel
//                bottomSheetProductInfo.setState(BottomSheetBehavior.STATE_EXPANDED);

            }
        })
    }

    override fun subscribeToNetworkLiveData() {
        super.subscribeToNetworkLiveData()

        mViewModel.getMusics.observe(this, Observer {
            when (it.status) {
                Resource.Status.LOADING -> {
                    shimmerFrameLayout.startShimmer()
                }
                Resource.Status.SUCCESS -> {
                    shimmerFrameLayout.stopShimmer()
                    shimmerFrameLayout.visibility = View.GONE
                    it.data?.let {
                        it.let {
                            if (it.isNotEmpty() && this::productListAdapter.isInitialized) {
                                productListAdapter.submitList(it)
                            }
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    shimmerFrameLayout.stopShimmer()
                    DialogHelperClass.errorDialog(requireContext(), it.message!!,object : DialogHelperClass.ClickAble{
                        override fun onclick() {
                            mViewModel.hitGetMusicAPI()
                        }
                    })
                }
            }
        })
    }
}