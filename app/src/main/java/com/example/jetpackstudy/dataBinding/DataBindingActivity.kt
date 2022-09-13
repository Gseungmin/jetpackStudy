package com.example.jetpackstudy.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackstudy.R
import com.example.jetpackstudy.databinding.ActivityDataBindingBinding
import com.example.jetpackstudy.databinding.ActivityViewBindingBinding
import com.example.jetpackstudy.viewBinding.CustomViewBindingAdapter

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

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

        val customAdapter = CustomDataBindingAdapter(array)

        val rv = binding.rv
        rv.adapter = customAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}