package com.example.itacademyrickmortyexample.utils

import com.example.itacademyrickmortyexample.retrofit.RetrofitClient
import com.example.itacademyrickmortyexample.retrofit.RetrofitService

object Common {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"
    val retrofitService:RetrofitService
    get() =
        RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}