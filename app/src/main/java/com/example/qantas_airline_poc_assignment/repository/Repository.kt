package com.example.qantas_airline_poc_assignment.repository

import com.example.qantas_airline_poc_assignment.network.ApiInterface

class Repository (){
    fun getAirportList(apiInterface: ApiInterface) = apiInterface.getAirportList()
}