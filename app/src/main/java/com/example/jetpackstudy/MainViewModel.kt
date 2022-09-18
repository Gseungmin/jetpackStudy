package com.example.jetpackstudy

import androidx.lifecycle.ViewModel

class MainViewModel(num : Int) : ViewModel() {

    var count = num
    fun plus() {
        count++
    }
    fun minus() {
        count--
    }

    fun getCountValue(): Int {
        return count
    }

}