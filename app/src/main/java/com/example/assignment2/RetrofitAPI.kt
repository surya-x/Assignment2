package com.example.assignment2

import com.example.assignment2.data.Response
import retrofit2.Call
import retrofit2.http.*

interface RetrofitAPI {

    @GET("{word}")
    fun getDefinition( @Header("Authorization") auth_token: String, @Path("word") word: String): Call<Response>
}