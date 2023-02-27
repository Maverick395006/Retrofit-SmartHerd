package com.example.retrofitsmartheard.viewmodels

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.retrofitsmartheard.exceptions.NoConnectivityException
import com.example.retrofitsmartheard.models.Destination
import com.example.retrofitsmartheard.services.DestinationService
import com.example.retrofitsmartheard.services.ServiceBuilder
import com.example.retrofitsmartheard.views.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    lateinit var serviceBuilder: ServiceBuilder

    fun loadDestinations(context: Context) {

        serviceBuilder = ServiceBuilder(context)

        val destinationService = serviceBuilder.buildService(DestinationService::class.java)
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
                if (t is NoConnectivityException) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }
                Log.d("LOCAL DATA", "ERROR: ${t.message}")
            }

        })

    }

    fun loadDestination(context: Context,id: Int) {

        serviceBuilder = ServiceBuilder(context)

        val destinationService = serviceBuilder.buildService(DestinationService::class.java)
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

    fun loadDestinationsByQuery(context: Context,country: String) {

        serviceBuilder = ServiceBuilder(context)

        val destinationService = serviceBuilder.buildService(DestinationService::class.java)
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

    fun loadDestinationsByQueryMap(context: Context,filter: HashMap<String, String>) {

        serviceBuilder = ServiceBuilder(context)

        val destinationService = serviceBuilder.buildService(DestinationService::class.java)
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

    fun addNewDestination(context: Context,newDestination: Destination) {

        serviceBuilder = ServiceBuilder(context)

        val destinationService = serviceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.addNewDestination(newDestination)
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

    fun updateDestinationById(context: Context,id: Int, city: String, description: String, country: String) {

        serviceBuilder = ServiceBuilder(context)

        val destinationService = serviceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.updateDestinationById(id, city, description, country)
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

    fun deleteDestinationById(context: Context,id: Int) {

        serviceBuilder = ServiceBuilder(context)

        val destinationService = serviceBuilder.buildService(DestinationService::class.java)
        val requestCall = destinationService.deleteDestinationById(id)
        requestCall.enqueue(object : Callback<Unit> {
            override fun onResponse(
                call: Call<Unit>,
                response: Response<Unit>
            ) {
                if (response.isSuccessful) {
                    Log.d("LOCAL DATA", "${response.body()}")
                } else {
                    Log.d("LOCAL DATA", "Failed to Retrieve Data from Server")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("LOCAL DATA", "ERROR: ${t.message}")
            }

        })

    }

}