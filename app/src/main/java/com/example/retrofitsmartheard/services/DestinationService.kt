package com.example.retrofitsmartheard.services

import com.example.retrofitsmartheard.models.Destination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface DestinationService {

    // Simple Get Method
    @GET("/destination")
    fun getDestinationList(): Call<List<Destination>>

    // Path Parameter
    @GET("/destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>

    // Query Parameter
    @GET("/destination")
    fun getDestinationsByQuery(@Query("country") country: String?): Call<List<Destination>>

    // QueryMap for Multiple Query Parameter
    @GET("/destination")
    fun getDestinationsByQueryMap(@QueryMap filter: HashMap<String, String>): Call<List<Destination>>

}