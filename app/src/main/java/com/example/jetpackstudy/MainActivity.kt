package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

// 주기적 실행
// 15분마다 / 30분다 / 1시간마다 로직 실행
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //15분마다 실행, 미니멈이 15분
        val workManager = PeriodicWorkRequestBuilder<WorkManager1>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workManager)
    }
}