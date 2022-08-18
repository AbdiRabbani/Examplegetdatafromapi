package com.example.apiapp.network

import com.example.apiapp.DataResponse
import com.example.apiapp.DataResponseItem
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("v1/images/search?format=json&limit=100")
    fun getTheCat() : Flowable<List<DataResponseItem>>
}