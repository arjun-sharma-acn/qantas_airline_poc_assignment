package com.example.qantas_airline_poc_assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem
import com.example.qantas_airline_poc_assignment.repository.Repository

class MainActivityViewModel() : ViewModel() {

    private val repository: Repository = Repository()

    fun getLiveDataObserver(): MutableLiveData<List<AirportDataClassItem>> {
        return repository.liveDataList
    }

    fun makeRepoCall(){
        repository.makeAPICall()
    }


}