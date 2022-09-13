package com.example.jetpackstudy.viewBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackstudy.CustomAdapter
import com.example.jetpackstudy.R
import com.example.jetpackstudy.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val array = mutableListOf<String>()
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("d")
        array.add("e")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("d")
        array.add("e")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("d")
        array.add("e")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("d")
        array.add("e")

        val customAdapter = CustomViewBindingAdapter(array)

        val rv = binding.rv
        rv.adapter = customAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}