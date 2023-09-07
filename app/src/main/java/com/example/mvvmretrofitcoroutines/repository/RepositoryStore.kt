package com.example.mvvmretrofitcoroutines.repository

import com.example.mvvmretrofitcoroutines.network.ApiInterface
import com.example.mvvmretrofitcoroutines.network.SafeApiRequest


class RepositoryStore(private val apiInterface: ApiInterface) : SafeApiRequest(){

    suspend fun getStoreItems()= safeApiRequest { apiInterface.getAllStoreItems() }
}