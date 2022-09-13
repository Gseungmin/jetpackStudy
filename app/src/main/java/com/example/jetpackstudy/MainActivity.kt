package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackstudy.databinding.ActivityMainBinding

//viewModel -> Activity와 Fragment 공유
//Activity 값을 Fragment를 쓰고 싶을때
//Fragment 값을 ViewModel 값으로 사용하기 위해
//viewModel Factory: 네트워크 통신이나 LocalDB에서 데이터를 받아오는 정보를 viewModel에 넘기기
//따라서 viewModel에 값을 넘겨주고 싶을때 사용
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    val manager = supportFragmentManager
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = MainViewModelFactory(5000)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        binding.result.text = viewModel.getCountValue().toString()

        binding.plus.setOnClickListener {
            viewModel.plus()
            binding.result.text = viewModel.getCountValue().toString()
        }

        binding.minus.setOnClickListener {
            viewModel.minus()
            binding.result.text = viewModel.getCountValue().toString()
        }

        binding.fragmentBtn.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = TestFragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}