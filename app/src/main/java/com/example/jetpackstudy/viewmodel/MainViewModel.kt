package com.example.jetpackstudy.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackstudy.api.MyApi
import com.example.jetpackstudy.api.RetrofitInstance
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val retrofitInstance = RetrofitInstance.getInstance().create(MyApi::class.java)

    private var _mutableWord1 = MutableLiveData<String>()
    val liveWord1 : LiveData<String>
        get() = _mutableWord1

    private var _mutableWord2 = MutableLiveData<String>()
    val liveWord2 : LiveData<String>
        get() = _mutableWord2
//
//    private var _mutableWord3 = MutableLiveData<String>()
//    val liveWord3 : LiveData<String>
//        get() = _mutableWord3

    fun getPost1() = viewModelScope.launch {
        val dto = retrofitInstance.getPost1()
        _mutableWord1.value = dto.title
    }

//    fun getPosts() = viewModelScope.launch {
//
//        val dtos = retrofitInstance.getPosts()
//        Log.d("MainViewModel", dtos.toString())
//        _mutableWord3.value = dtos[0].title
//    }

    fun getPostNumber(number : Int) = viewModelScope.launch {
        val dto = retrofitInstance.getPostNum(number)
        _mutableWord2.value = dto.title
    }
}