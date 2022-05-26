package com.example.qantas_airline_poc_assignment.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qantas_airline_poc_assignment.R
import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.title = "Airport Details";
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val bundle = intent.extras
        val airportDetails = bundle?.get("airport_details") as AirportDataClassItem
        tv_airport_code.text = "Airport Code :: ${airportDetails.airportCode}".ifEmpty { "" }
        tv_airport_name.text = "Airport Name :: ${airportDetails.airportName}".ifEmpty { "" }
        tv_city.text = "City :: ${airportDetails.city.cityName}".ifEmpty { "" }
        tv_country_name.text = "Country :: ${airportDetails.country.countryName}".ifEmpty { "" }
        tv_region_name.text = "Region :: ${airportDetails.region.regionName}".ifEmpty { "" }
        tv_timezone.text = "Time Zone Name :: ${ airportDetails.city.timeZoneName}".ifEmpty { "" }

        btnBack.setOnClickListener {
            this@DetailsActivity.finish()
        }

    }


}