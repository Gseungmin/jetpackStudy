package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


/**
 * viewModel 클래스는 안드로이드 수명 주기를 고려하여 데이터를 저장 및 관리
 * 화면 회전 같이 구성을 변경할 때도 데이터를 유지, 만약 데이터가 변경된다면 문제 발생
 * UI컨트롤러(Activiry, Fragment)에서 모든 것을 하려고 하면 복잡해진다
 * 따라서 ViewModel을 사용하면 테스트나 관리가 용이하다
 * 화면을 뒤집으면 생명주기가 종료되었다가 다시 켜지는데 이때 데이터 손실을 방지하기 위해 ViewModel 사용
 * */
class MainActivity : AppCompatActivity() {

//    private lateinit var viewModel: MainViewModel

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val transaction = manager.beginTransaction()
            val fragment = TestFragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        val pbtn = findViewById<Button>(R.id.plus)
//        val mbtn = findViewById<Button>(R.id.minus)
//        val resultArea = findViewById<TextView>(R.id.result)
//
//        resultArea.text = viewModel.getCountValue().toString()
//
//        pbtn.setOnClickListener {
//            viewModel.plus()
//            resultArea.text = viewModel.getCountValue().toString()
//        }
//
//        mbtn.setOnClickListener {
//            viewModel.minus()
//            resultArea.text = viewModel.getCountValue().toString()
//        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}