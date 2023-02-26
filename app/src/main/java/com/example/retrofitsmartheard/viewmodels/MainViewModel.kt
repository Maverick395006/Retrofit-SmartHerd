package com.example.retrofitsmartheard.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.retrofitsmartheard.models.Destination
import com.example.retrofitsmartheard.services.DestinationService
import com.example.retrofitsmartheard.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    fun loadDestinations() {

        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.getDestinationList()
        requestCall.enqueue(object : Callback<List<Destination>> {
            override fun onResponse(
                call: Call<List<Destination>>,
                response: Response<List<Destination>>
            ) {
                if (response.isSuccessful) {
                    Log.d("LOCAL DATA", "${response.body()}")
                } else {
                    Log.d("LOCAL DATA", "Failed to Retrieve Data from Server")
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                Log.d("LOCAL DATA", "ERROR: ${t.message}")
            }

        })

    }

    fun loadDestination(id: Int) {

        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.getDestination(id)
        requestCall.enqueue(object : Callback<Destination> {
            override fun onResponse(
                call: Call<Destination>,
                response: Response<Destination>
            ) {
                if (response.isSuccessful) {
                    Log.d("LOCAL DATA", "${response.body()}")
                } else {
                    Log.d("LOCAL DATA", "Failed to Retrieve Data from Server")
                }
            }

            override fun onFailure(call: Call<Destination>, t: Throwable) {
                Log.d("LOCAL DATA", "ERROR: ${t.message}")
            }

        })

    }

    fun loadDestinationsByQuery(country:String) {

        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.getDestinationsByQuery(country)
        requestCall.enqueue(object : Callback<List<Destination>> {
            override fun onResponse(
                call: Call<List<Destination>>,
                response: Response<List<Destination>>
            ) {
                if (response.isSuccessful) {
                    Log.d("LOCAL DATA", "${response.body()}")
                } else {
                    Log.d("LOCAL DATA", "Failed to Retrieve Data from Server")
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                Log.d("LOCAL DATA", "ERROR: ${t.message}")
            }

        })

    }

    fun loadDestinationsByQueryMap(filter:HashMap<String,String>) {

        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.getDestinationsByQueryMap(filter)
        requestCall.enqueue(object : Callback<List<Destination>> {
            override fun onResponse(
                call: Call<List<Destination>>,
                response: Response<List<Destination>>
            ) {
                if (response.isSuccessful) {
                    Log.d("LOCAL DATA", "${response.body()}")
                } else {
                    Log.d("LOCAL DATA", "Failed to Retrieve Data from Server")
                }
            }

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                Log.d("LOCAL DATA", "ERROR: ${t.message}")
            }

        })

    }

}