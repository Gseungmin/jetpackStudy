package com.example.jetpackstudy.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackstudy.api.MyApi
import com.example.jetpackstudy.api.RetrofitInstance
import com.example.jetpackstudy.model.Plant
import com.example.jetpackstudy.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _result = MutableLiveData<List<Plant>>()
    val result : LiveData<List<Plant>>
        get() = _result

    fun getAllData() {
        viewModelScope.launch {
            _result.value = repository.getAllData()
        }
    }
}