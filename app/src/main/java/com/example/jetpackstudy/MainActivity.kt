package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

// WorkManager 고유 작업
//작업 관리: 예를 들어 24시간 마다 백엔드 서비스에 로그 업로드하려하는데 주의하지 않으면 한번만 실행해야하는
//작업임에도 동일한 작업이 여러번 큐에 추가됨
//즉 한작업이 작업 큐에 한번만 추가되게 함
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testBtn = findViewById<Button>(R.id.testBtn)
        testBtn.setOnClickListener {


            val testWorkManager = OneTimeWorkRequestBuilder<TestWorkManager>().build()
            // 기존에 했던 방식
            //WorkManager.getInstance(this).enqueue(testWorkManager)

            // 새로운방식
            // WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.KEEP, testWorkManager)
            // KEEP은 기존 작업이 있으면 현재 작업 제외, REPLACE는 기존 작업 대체
            WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.REPLACE, testWorkManager)
        }
    }
}