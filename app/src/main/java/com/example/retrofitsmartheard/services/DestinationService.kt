package com.example.retrofitsmartheard.services

import com.example.retrofitsmartheard.models.Destination
import retrofit2.Call
import retrofit2.http.*

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

    // Post Method
    @POST("/destination")
    fun addNewDestination(@Body newDestination: Destination): Call<Destination>

    // Post Method
    @FormUrlEncoded
    @PUT("/destination/{id}")
    fun updateDestinationById(
        @Path("id") id: Int,
        @Field("city") city: String,
        @Field("description") description: String,
        @Field("country") country: String,
    ): Call<Destination>

    // Post Method
    @DELETE("/destination/{id}")
    fun deleteDestinationById(@Path("id") id: Int): Call<Unit>

}