package com.saif.truckitin.data.remote


import com.saif.truckitin.constants.NetworkCallPoints
import com.saif.truckitin.data.models.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(NetworkCallPoints.API_GET_ALL_PRODUCTS)
    suspend fun getProducts(): Response<List<ProductModel>>
}