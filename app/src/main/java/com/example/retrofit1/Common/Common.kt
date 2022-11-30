package com.example.retrofit1.Common

import com.example.retrofit1.Interface.RetrofitService
import com.example.retrofit1.Retrofit.RetrofitClient


object Common {
    private val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)

}