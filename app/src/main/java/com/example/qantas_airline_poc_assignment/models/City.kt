package com.example.qantas_airline_poc_assignment.models

import java.io.Serializable

data class City(
    val cityCode: String?,
    val cityName: String?,
    val timeZoneName: String?
) : Serializable