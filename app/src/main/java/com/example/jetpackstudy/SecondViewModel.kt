package com.example.jetpackstudy

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {

    fun a() {
        CoroutineScope(Dispatchers.IO).launch {
            for(i in 0..10) {
                delay(1000)
                Log.d("Log", i.toString())
            }
        }
    }

    //viewModel에서 빠져나올때 이것을 중지시켜야 하는 작업 필요
    //따라서 사용하는 것이 ViewModelScope
    fun b() {
        viewModelScope.launch {
            for(i in 0..10) {
                Log.d("Log", "Start")
                delay(1000)
                Log.d("Log", i.toString())
                Log.d("Log", "End")
            }
        }
    }
}