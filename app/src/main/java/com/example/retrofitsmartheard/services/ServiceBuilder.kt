package com.example.retrofitsmartheard.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    // Before Release, Change this URL to Live Server URL
    private const val URL = "http://192.168.29.52:9000"

    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // Create OkHttp Client
    private val okHttpBuilder = OkHttpClient.Builder().addInterceptor(logger)

    // Create Retrofit Client
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpBuilder.build())

    // Create Retrofit Instance
    private val retrofit = retrofitBuilder.build()

    // Generic Service Builder Using Interface
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

}