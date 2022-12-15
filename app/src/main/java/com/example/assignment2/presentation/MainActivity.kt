package com.example.assignment2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment2.R
import com.example.assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewmodel: MainViewModel
    private lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this)[MainViewModel::class.java]
        adapter = RVAdapter(this)

        Log.d("surya", "listener setup")
        binding.btClick.setOnClickListener(this)

        Log.d("surya", "rv setup")
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

//        setupListeners()
        Log.d("surya", "end setup")

    }

//    private fun setupListeners() {
//        binding.btClick.setOnClickListener {
//            Log.d("MainActivity", "CLICKEDD")
//            checkDefinition()
//        }
//    }

    private fun checkDefinition() {
        val input = binding.etInput.text.toString()
        if (input.isNotEmpty()){
            viewmodel.checkDefinition(input).observe(this){
                if (it != null){
                    adapter.updateList(viewmodel.mapResponseToDefinition(it))
                }
            }
        }
    }

    override fun onClick(v: View) {
        Log.d("surya", "CLICKEDD")
        when(v.id){
            R.id.btClick -> {
                Log.d("surya", "CLICKEDD But")
                checkDefinition()
            }
        }

    }

}