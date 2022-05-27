package com.example.qantas_airline_poc_assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem
import com.example.qantas_airline_poc_assignment.repository.Repository
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest {
    @Mock
    lateinit var repository: Repository

    lateinit var liveDataList: MutableLiveData<List<AirportDataClassItem>>

    @Before
    fun onSetup() {
        Mockito.`when`(repository.liveDataList).thenReturn(liveDataList)
    }

    @Test
    fun makeRepoCall_getObserver_mutablelivedatalist() {
        repository.makeAPICall()
        assertNotNull(liveDataList.value)
    }
}