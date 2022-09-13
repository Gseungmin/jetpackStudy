package com.example.jetpackstudy.viewBinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackstudy.databinding.TextRowItemBinding

class CustomViewBindingAdapter(private val dataSet : MutableList<String>) : RecyclerView.Adapter<CustomViewBindingAdapter.ViewHolder>() {

    inner class ViewHolder(binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val myText : TextView = binding.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myText.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}