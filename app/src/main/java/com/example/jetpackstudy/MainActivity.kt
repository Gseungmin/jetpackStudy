package com.example.jetpackstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpackstudy.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * kotlin Extensions
 * 잦은 findViewById의 코드로 인해 등장
 * 1. gradle 속성 추가
 * 2. 사용
 * 다른 액티비티의 속성에 접근해서 발생하는 문제 및 성능이슈로 구글에서 사용 지양
 * 구글에서 추천하는 방식은 ViewBiding 및 DataBinding
 * ViewBinding
 * findById에 비해 Null안전 및 유형 안전
 * DataBinding에 비해 빠르고 편리
 *
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.testText.text = "이거는 변경된 리스트"
        binding.testText.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}