package com.example.retrofitsmartheard.helpers

import android.content.Context
import android.net.ConnectivityManager

object Utils {

    fun Context.isInternetAvailable(): Boolean {
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

}