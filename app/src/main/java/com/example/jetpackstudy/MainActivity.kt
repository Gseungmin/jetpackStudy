package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Simple Retrofit Ex
// https://jsonplaceholder.typicode.com/
// https://jsonplaceholder.typicode.com/posts
// https://jsonplaceholder.typicode.com/posts/3
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
        api.getPost1().enqueue(object : Callback<DataDto>{
            //응답 성공시
            override fun onResponse(call: Call<DataDto>, response: Response<DataDto>) {
                Log.d("API1", response.body().toString())
            }
            //응답 실패시
            override fun onFailure(call: Call<DataDto>, t: Throwable) {
                Log.d("API1", "fail")
            }
        })

        api.getPosts().enqueue(object : Callback<MutableList<DataDto>>{
            override fun onResponse(
                call: Call<MutableList<DataDto>>,
                response: Response<MutableList<DataDto>>
            ) {
                Log.d("API2", response.body().toString())
            }
            override fun onFailure(call: Call<MutableList<DataDto>>, t: Throwable) {
                Log.d("API2", "fail")
            }
        })

        api.getPostNum(5).enqueue(object : Callback<DataDto>{
            //응답 성공시
            override fun onResponse(call: Call<DataDto>, response: Response<DataDto>) {
                Log.d("API3", response.body().toString())
            }
            //응답 실패시
            override fun onFailure(call: Call<DataDto>, t: Throwable) {
                Log.d("API3", "fail")
            }
        })
    }
}