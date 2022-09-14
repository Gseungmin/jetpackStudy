package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackstudy.adapter.RVAdapter
import com.example.jetpackstudy.api.MyApi
import com.example.jetpackstudy.api.RetrofitInstance
import com.example.jetpackstudy.dto.DataDto
import com.example.jetpackstudy.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Simple Retrofit Ex
// https://jsonplaceholder.typicode.com/
// https://jsonplaceholder.typicode.com/posts
// https://jsonplaceholder.typicode.com/posts/3
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getPost1()
        viewModel.getPostNumber(3)
        viewModel.getPosts()

        val area1 = findViewById<TextView>(R.id.area1)
        val area2 = findViewById<TextView>(R.id.area2)

        //변경이 되면 실행을 의미
        viewModel.liveWord1.observe(this, Observer {
            area1.text = it.toString()
        })

        //변경이 되면 실행을 의미
        viewModel.liveWord2.observe(this, Observer {
            area2.text = it.toString()
        })

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.liveWord3.observe(this, Observer {
            val rvAdapter = RVAdapter(it as ArrayList<DataDto> /* = java.util.ArrayList<com.example.jetpackstudy.dto.DataDto> */)
            rv.adapter = rvAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })
    }
}