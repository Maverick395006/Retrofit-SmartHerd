package com.example.retrofitsmartheard.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitsmartheard.adapters.DestinationAdapter
import com.example.retrofitsmartheard.databinding.ActivityMainBinding
import com.example.retrofitsmartheard.viewmodels.MainViewModel
import com.example.retrofitsmartheard.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var destinationAdapter: DestinationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModelFactory = MainViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        destinationAdapter = DestinationAdapter()
        binding.rvDestinationList.adapter = destinationAdapter

        binding.btnApiCall.setOnClickListener {
            /**
             * @GET Request - Simple
             */
//            viewModel.loadDestinations()
            /**
             * @Path Parameter
             */
//            viewModel.loadDestination(4)
            /**
             * @Query Parameter
             */
//            viewModel.loadDestinationsByQuery("India")
            /**
             * @QueryMap for Multiple Query Parameter
             */
            val filter = HashMap<String, String>()
            filter["country"] = "India"
            filter["count"] = "1"
            viewModel.loadDestinationsByQueryMap(filter)
        }

    }

}