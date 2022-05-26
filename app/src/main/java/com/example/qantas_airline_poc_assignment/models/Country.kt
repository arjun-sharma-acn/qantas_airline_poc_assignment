package com.example.qantas_airline_poc_assignment.models

import java.io.Serializable

data class Country(
    val countryCode: String?,
    val countryName: String?
) : Serializable