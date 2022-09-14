package com.example.jetpackstudy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackstudy.api.MyApi
import com.example.jetpackstudy.api.RetrofitInstance
import com.example.jetpackstudy.model.Plant
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    //해당 인스턴스는 MyApi를 사용할 것 선언
    val retrofitInstance : MyApi = RetrofitInstance.getInstance().create(MyApi::class.java)

    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result

    fun getAllData() {
        viewModelScope.launch {
            _result.value = retrofitInstance.getAllPlants()
        }
    }
}