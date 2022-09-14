package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf

//workmanager
//사용자가 프로그램을 종료해도 오래걸리는 작업에 대해 계속 진행해줌
//앱이 다시시작되거나 재부팅될때 작업을 유지
//코루틴과 같이 쓰기도 좋고 작업 순서를 설정할 수 있다
//백그라운드 작업하기 좋다
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val workManagerA = OneTimeWorkRequestBuilder<WorkManagerA>().build()
        WorkManager.getInstance(this).enqueue(workManagerA)

        //보낼 데이터
        val myData: Data = workDataOf(
            "a" to 10,
            "b" to 20
        )

        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().setInputData(myData).build()
        WorkManager.getInstance(this).enqueue(workManagerB)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerB.id)
            .observe(this, Observer { info ->

                if (info != null && info.state.isFinished) {
                    val result = info.outputData.getInt("result", 10000)
                    val result2 = info.outputData.getInt("result2", 10000)
                    Log.d("MainActivity", result.toString())
                    Log.d("MainActivity", result2.toString())
                }
            })
    }
}