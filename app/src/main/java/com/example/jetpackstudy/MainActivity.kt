package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.jetpackstudy.WorkManagerTest.Companion.HowMuch

// WorkManager -> 진행상태 검토
// WorkManager -> 오래걸리는 작업 (60초 6 12 18 24 30) -> 몇 퍼센트 진행이 되었다

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val workManagerTest = OneTimeWorkRequestBuilder<WorkManagerTest>().build()
        WorkManager.getInstance(this).enqueue(workManagerTest)

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workManagerTest.id)
            .observe(this, Observer { workInfo : WorkInfo? ->
                val progress = workInfo?.progress
                val value = progress?.getInt(HowMuch, 0)
                if(value != 0) {
                    Log.d("MainActivity", value.toString())
                }
                if(value == 100) {
                    Log.d("MainActivity", "이제 끝끝")
                }
            })

    }
}