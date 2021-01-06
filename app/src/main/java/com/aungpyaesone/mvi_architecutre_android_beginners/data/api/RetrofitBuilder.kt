package com.aungpyaesone.mvi_architecutre_android_beginners.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitBuilder {
    private const val  BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    var logging: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }
    var client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    private fun getRetrofit()= Retrofit.Builder()
        .baseUrl(BASE_URL).client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val apiService : ApiService = getRetrofit().create(ApiService::class.java)

}