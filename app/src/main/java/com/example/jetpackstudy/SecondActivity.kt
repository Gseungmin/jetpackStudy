package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class SecondActivity : AppCompatActivity() {

    private lateinit var viewModel: SecondViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
//        viewModel.a()
        viewModel.b()
    }
}