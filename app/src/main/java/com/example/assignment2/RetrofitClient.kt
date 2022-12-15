package com.example.assignment2

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    const val baseUrl = "https://owlbot.info/api/v4/dictionary/"

    val builder = Retrofit.Builder()

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(5000, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

//    fun checkWord() {
//        return RetrofitAPI.getDefinition()
//    }

}