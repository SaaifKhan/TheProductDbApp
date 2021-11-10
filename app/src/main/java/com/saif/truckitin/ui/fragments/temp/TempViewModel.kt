package com.saif.truckitin.ui.fragments.temp


import com.saif.truckitin.baseclasses.BaseViewModel
import com.saif.truckitin.data.remote.reporitory.MainRepository
import com.saif.truckitin.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TempViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {

}