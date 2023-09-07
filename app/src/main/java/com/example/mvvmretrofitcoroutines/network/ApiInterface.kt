package com.example.mvvmretrofitcoroutines.network

import com.example.mvvmretrofitcoroutines.model.StoreItems
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
   suspend fun getAllStoreItems(): Response<List<StoreItems>>

    companion object{
        operator fun invoke(): ApiInterface {
          return Retrofit.Builder()
              .baseUrl("https://fakestoreapi.com/")
              .addConverterFactory(GsonConverterFactory.create())
              .build()
              .create(ApiInterface::class.java)
        }
    }
}