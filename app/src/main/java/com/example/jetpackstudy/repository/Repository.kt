package com.example.jetpackstudy.repository

import com.example.jetpackstudy.api.MyApi
import com.example.jetpackstudy.api.RetrofitInstance

//viewModel에서 했던 역할을 빼오는 것이라 생각하면 됨
class Repository {

    //해당 인스턴스는 MyApi를 사용할 것 선언
    private val client = RetrofitInstance.getInstance().create(MyApi::class.java)

    suspend fun getAllData() = client.getAllPlants()
}