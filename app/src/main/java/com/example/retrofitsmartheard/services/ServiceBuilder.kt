package com.example.retrofitsmartheard.services

import android.os.Build
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object ServiceBuilder {

    // Before Release, Change this URL to Live Server URL
    private const val URL = "http://192.168.29.52:9000"

    // Create Logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    // Create Custom Interceptor to apply Headers Application wide
    val headerInterceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request.newBuilder()
                .addHeader("x-device-type", Build.DEVICE)
                .addHeader("Accept-Language", Locale.getDefault().language)
                .addHeader("Accept-Country", Locale.getDefault().country)
                .addHeader("Accept-Country-Display", Locale.getDefault().displayCountry)
                .addHeader("Accept-Name-Display", Locale.getDefault().displayName)
                .build()
            val response = chain.proceed(request)
            return response
        }
    }

    // Create OkHttp Client
    private val okHttpBuilder = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)

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