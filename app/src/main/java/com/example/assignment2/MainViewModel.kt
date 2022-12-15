package com.example.assignment2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment2.data.Definition
import com.example.assignment2.data.Response

class MainViewModel : ViewModel() {

    val repository = Repository()

    fun checkDefinition(input: String) : LiveData<Response> {
        val livedata = MutableLiveData<Response>()
        repository.checkDefinition(input, livedata)
        return livedata
    }

    fun mapResponseToDefinition(response: Response) : ArrayList<Definition> {
        val defList = ArrayList<Definition>()
        for (each in response.definitions!!){
            val def = Definition(each?.type!!, each.definition!!)
            defList.add(def)
        }
        return defList
    }

}