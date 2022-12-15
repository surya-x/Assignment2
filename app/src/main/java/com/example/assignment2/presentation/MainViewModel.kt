package com.example.assignment2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment2.data.repository.Repository
import com.example.assignment2.data.model.Definition
import com.example.assignment2.data.model.Response

class MainViewModel : ViewModel() {

    val repository = Repository()   // TODO: should be passed as constructor

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