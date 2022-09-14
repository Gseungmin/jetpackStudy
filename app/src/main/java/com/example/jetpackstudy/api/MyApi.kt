package com.example.jetpackstudy.api

import com.example.jetpackstudy.dto.DataDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    @GET("posts/1")
    suspend fun getPost1() : DataDto

    @GET("posts")
    suspend fun getPosts() : MutableList<DataDto>

    //동적으로 Get
    @GET("posts/{number}")
    suspend fun getPostNum(@Path("number") number: Int) : DataDto

}