package com.example.jetpackstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.jetpackstudy.databinding.ActivityMainBinding

/**
 * DataBinding
 * 이름처럼 데이터를 연결해주는 역할을 할 수 있다.
 * 데이터와 결합해서 사용할 수 있음
 * */
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.text.text = "바뀐텍스트"
        binding.text.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}