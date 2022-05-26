package com.example.qantas_airline_poc_assignment.models

import java.io.Serializable

data class State(
    val stateCode: String?,
    val stateName: String?
) : Serializable