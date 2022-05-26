package com.example.qantas_airline_poc_assignment.models

import java.io.Serializable

data class Location(
    val aboveSeaLevel: Int,
    val latitude: Double,
    val latitudeDirection: String,
    val latitudeRadius: Double,
    val longitude: Double,
    val longitudeDirection: String,
    val longitudeRadius: Double
) : Serializable