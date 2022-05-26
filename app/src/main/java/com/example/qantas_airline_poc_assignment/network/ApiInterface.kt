package com.example.qantas_airline_poc_assignment.network

import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem
import com.example.qantas_airline_poc_assignment.models.AirportModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET ("airport")
    fun getAirportList(): Call<List<AirportDataClassItem>>
}