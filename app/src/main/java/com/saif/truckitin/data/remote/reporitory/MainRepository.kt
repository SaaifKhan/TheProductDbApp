package com.saif.truckitin.data.remote.reporitory

import com.saif.truckitin.data.local.db.AppDao
import com.saif.truckitin.data.remote.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    localDataSource: AppDao,
   // localDataSource: AppDao
) {

    suspend fun getProducts() = apiService.getProducts()

}