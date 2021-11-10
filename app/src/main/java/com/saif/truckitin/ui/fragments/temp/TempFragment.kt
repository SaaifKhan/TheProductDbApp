package com.saif.truckitin.ui.fragments.temp

import android.os.Bundle
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import com.saif.truckitin.R
import com.saif.truckitin.baseclasses.BaseFragment
import com.saif.truckitin.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TempFragment : BaseFragment<ActivitySplashBinding, TempViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_splash
    override val viewModel: Class<TempViewModel>
        get() = TempViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickListener()
    }

    private fun clickListener() {

    }

}