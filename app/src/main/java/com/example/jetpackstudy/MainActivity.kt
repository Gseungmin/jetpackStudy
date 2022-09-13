package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.jetpackstudy.databinding.ActivityMainBinding

//DataBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var testCount = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //기존 방법
        //binding.text.text = "바뀐 텍스트"

        //데이터 결합 방법
        val person = Person("ji", 20)
        binding.person = person
    }

    fun btnClick(view: View) {
        testCount++

        val person = Person("ji", testCount)
        binding.person = person
    }
}