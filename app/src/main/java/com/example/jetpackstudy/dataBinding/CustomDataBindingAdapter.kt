package com.example.jetpackstudy.dataBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackstudy.R
import com.example.jetpackstudy.databinding.TextRowItemBinding

class CustomDataBindingAdapter(private val dataSet : MutableList<String>) : RecyclerView.Adapter<CustomDataBindingAdapter.ViewHolder>() {

    inner class ViewHolder(binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val myText : TextView = binding.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = DataBindingUtil.inflate<TextRowItemBinding>(LayoutInflater.from(parent.context), R.layout.text_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myText.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}