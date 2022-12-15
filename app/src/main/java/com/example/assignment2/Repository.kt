package com.example.assignment2

import androidx.lifecycle.MutableLiveData
import com.example.assignment2.data.Response

class Repository {

    val retrofitManager = RetrofitManager()
    val token = "Token 78bb251553954d4c34a988e991e28ed8a6be322f" // TODO: Removing it from directly exposing

    fun checkDefinition(input: String, livedata: MutableLiveData<Response>) {
        retrofitManager.getDefinition(token, input) {
            livedata.postValue(it)
        }
    }

}