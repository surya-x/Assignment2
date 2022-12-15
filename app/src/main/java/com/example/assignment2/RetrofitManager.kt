package com.example.assignment2

import com.example.assignment2.data.Response
import retrofit2.Call
import retrofit2.Callback

class RetrofitManager {
    private val retrofit = RetrofitClient.buildService(RetrofitAPI::class.java)

    fun getDefinition(token: String, word: String, onResult: (Response?) -> Unit){
        retrofit.getDefinition(auth_token = token, word).enqueue(
            object : Callback<Response> {
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    onResult(response.body())
                }
            }
        )
    }
}