package com.example.jetpackstudy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    @GET("posts/1")
    fun getPost1() : Call<DataDto>

    @GET("posts")
    fun getPosts() : Call<MutableList<DataDto>>

    //동적으로 Get
    @GET("posts/{number}")
    fun getPostNum(@Path("number") number: Int) : Call<DataDto>

}