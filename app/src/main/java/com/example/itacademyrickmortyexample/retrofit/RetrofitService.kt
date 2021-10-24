package com.example.itacademyrickmortyexample.retrofit

import com.example.itacademyrickmortyexample.models.Heroes
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("character")
    fun getHeroList(): Call<Heroes>
}