package com.example.assignment2.data.api

import com.example.assignment2.data.model.Response
import retrofit2.Call
import retrofit2.http.*

interface RetrofitAPI {

    @GET("{word}")
    fun getDefinition( @Header("Authorization") auth_token: String, @Path("word") word: String): Call<Response>
}