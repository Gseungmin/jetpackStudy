package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackstudy.databinding.ActivityMainBinding

//LiveData Transformation
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.mapLiveData.observe(this, Observer {
            binding.resultArea1.text = it.toString()
        })

        viewModel.switchMapLiveData.observe(this, Observer {
            binding.resultArea2.text = it.toString()
        })

        binding.btnArea.setOnClickListener {
            val count = binding.inputArea.text.toString().toInt()
            viewModel.setLiveDataValue(count)
        }


    }
}