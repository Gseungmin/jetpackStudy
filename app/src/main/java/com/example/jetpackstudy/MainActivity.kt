package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val customAdapter = CustomAdapter(array)

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = customAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}