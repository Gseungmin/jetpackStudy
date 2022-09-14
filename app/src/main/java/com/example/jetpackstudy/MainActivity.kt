package com.example.jetpackstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//Retrofit은 비동기적으로 실행되므로 데이터 전송의 순서를 보장하지 않음
//따라서 필요한 것이 코루틴
//코루틴을 사용하는 이유는 비동기적으로 실행되는 코드들을 간소화하기 위한 실행 패턴
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val move = findViewById<Button>(R.id.btn)
        move.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}