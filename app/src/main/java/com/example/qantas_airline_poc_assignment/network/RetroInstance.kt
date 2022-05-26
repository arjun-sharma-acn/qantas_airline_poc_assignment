package com.example.qantas_airline_poc_assignment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetroInstance {
    companion object {
        private const val BASE_URL = "https://api.qantas.com/flight/refData/";


        fun getRetroInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }


}