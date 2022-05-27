package com.example.qantas_airline_poc_assignment.repository

import androidx.lifecycle.LiveData
import com.example.qantas_airline_poc_assignment.models.AirportDataClassItem
import com.example.qantas_airline_poc_assignment.network.ApiInterface
import com.example.qantas_airline_poc_assignment.network.RetroInstance
import junit.framework.TestCase.assertTrue
import okhttp3.Response

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import java.util.concurrent.CountDownLatch

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {

    @Mock
    lateinit var retroInstance: Retrofit

    @Mock
    lateinit var apiInterfaceClass: Class<ApiInterface>

    @Mock
    lateinit var apiInterface: ApiInterface

    private lateinit var response: Call<List<AirportDataClassItem>>
    private lateinit var liveData: LiveData<List<AirportDataClassItem>>

    @Before
    fun onSetup() {
        Mockito.`when`(RetroInstance.getRetroInstance()).thenReturn(retroInstance)
        Mockito.`when`(ApiInterface::class.java).thenReturn(apiInterfaceClass)
        Mockito.`when`(retroInstance.create(apiInterfaceClass)).thenReturn(apiInterface)
    }

    @Test
    fun makeApiCall_To_get_Airport_List() {
        response = apiInterface.getAirportList()
        response.execute()
        liveData.value?.isNotEmpty()?.let { assertTrue(it) }
    }

//    @Test
//    fun testApiResponse() {
//        val latch = CountDownLatch(1)
//        apiInterface.getAirportList(object : Callback() {
//            fun onResponse(call: Call<*>?, response: Response?) {
//                println("Success")
//                latch.countDown()
//            }
//
//            fun onFailure(call: Call<*>?, t: Throwable?) {
//                println("Failure")
//                latch.countDown()
//            }
//        })
//        try {
//            latch.await()
//        } catch (e: InterruptedException) {
//            e.printStackTrace()
//        }
//    }

}