package com.example.jetpackstudy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

//    var testMutableLiveData = MutableLiveData(0)
//
//    //MutableLiveData와 LiveData의 차이
//    //LiveData는 ViewModel 이외에서 변경하는 것을 방지
//
//    fun plus() {
//        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
//    }

    //라이브데이터 사용
    private var _testMutableLiveData = MutableLiveData(0)

    val testLiveData : LiveData<Int>
        get() = _testMutableLiveData

    fun plus() {
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }
}