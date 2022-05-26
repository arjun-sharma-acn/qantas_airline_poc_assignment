package com.example.qantas_airline_poc_assignment.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem
import com.example.qantas_airline_poc_assignment.network.ApiInterface
import com.example.qantas_airline_poc_assignment.network.RetroInstance
import retrofit2.Call
import retrofit2.Response

class Repository {
    var liveDataList: MutableLiveData<List<AirportDataClassItem>> = MutableLiveData()

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(ApiInterface::class.java)
        val call = retroService.getAirportList()
        call.enqueue(object : retrofit2.Callback<List<AirportDataClassItem>> {
            override fun onResponse(call: Call<List<AirportDataClassItem>>, response: Response<List<AirportDataClassItem>>) {
                liveDataList.postValue(response.body())

            }

            override fun onFailure(call: Call<List<AirportDataClassItem>>, t: Throwable) {
                liveDataList.postValue(null)
                t.message?.let { Log.i("ARJUN", it) }
            }

        })
    }
}