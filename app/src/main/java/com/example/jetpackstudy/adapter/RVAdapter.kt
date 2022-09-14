package com.example.jetpackstudy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpackstudy.R
import com.example.jetpackstudy.model.Plant

class RVAdapter(val context : Context, val dataSet : List<Plant>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.textArea)
        val imageView : ImageView = view.findViewById(R.id.imageArea)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ViewHolder(view)
    }

    //binding
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].name
        Glide.with(context).load(dataSet[position].imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}