package com.example.itacademyrickmortyexample.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        val interceptor = HttpLoggingInterceptor()//read about this
        interceptor.level = HttpLoggingInterceptor.Level.BODY//read about this
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit!!
    }
}