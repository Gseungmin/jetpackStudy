package com.example.jetpackstudy

import androidx.lifecycle.ViewModel

//viewModel
class MainViewModel : ViewModel() {

    var count = 0

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