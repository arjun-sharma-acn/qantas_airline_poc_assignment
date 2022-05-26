package com.example.qantas_airline_poc_assignment.adapter

import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem

interface ItemClickListener {
    fun onItemClickListener (position: Int, airportDataClass: AirportDataClassItem)
}