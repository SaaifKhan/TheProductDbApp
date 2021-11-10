package com.saif.truckitin.ui.activity.mainActivity

import com.saif.truckitin.baseclasses.BaseViewModel
import com.saif.truckitin.data.remote.reporitory.MainRepository
import com.saif.truckitin.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {


}
