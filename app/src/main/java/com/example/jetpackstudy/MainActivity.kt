package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

//workmanager
//사용자가 프로그램을 종료해도 오래걸리는 작업에 대해 계속 진행해줌
//앱이 다시시작되거나 재부팅될때 작업을 유지
//코루틴과 같이 쓰기도 좋고 작업 순서를 설정할 수 있다
//백그라운드 작업하기 좋다
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SimpleThread().start()

        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        WorkManager.getInstance(this).enqueue(workManagerA)
    }
}

class SimpleThread : Thread() {

    override fun run() {
        super.run()

        for(i in 1..10) {
            Log.d("MainActivity", "$i")
            sleep(1000)
        }

    }

}