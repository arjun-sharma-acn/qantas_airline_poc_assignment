package com.example.qantas_airline_poc_assignment.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.io.Serializable


data class AirportDataClassItem(
    val airportCode: String,
    val airportName: String,
    val city:  City,
    val country:  Country,
    val domesticAirport: Boolean,
    val eticketableAirport: Boolean,
    val internationalAirport: Boolean,
    val location: Location,
    val onlineIndicator: Boolean,
    val preferredInternationalAirportCode: String,
    val region: Region,
    val regionalAirport: Boolean,
    val state:  State
) : Serializable