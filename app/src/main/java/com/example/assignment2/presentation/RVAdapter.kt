package com.example.assignment2.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.data.model.Definition

class RVAdapter(private val context: Context) : RecyclerView.Adapter<RVAdapter.MyViewHolder>() {

    val list = ArrayList<Definition>()
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val type = itemView.findViewById<TextView>(R.id.type)
        val definition = itemView.findViewById<TextView>(R.id.definition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val myType = context.getString(R.string.type) + list[position].type
        val myDef = context.getString(R.string.definition) + list[position].definition
        holder.type.text = myType
        holder.definition.text = myDef
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newList: ArrayList<Definition>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}