package com.example.jetpackstudy

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.lang.Thread.sleep

class WorkManagerB(context : Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters){

    override fun doWork(): Result {

        //데이터 수신, 데이터가 안들어올 경우 대비 defaultValue 설정
        val a = inputData.getInt("a", 1000)
        val b = inputData.getInt("b", 2000)
        val c = inputData.getInt("c", 3000)

        Log.d("WorkManagerB", a.toString())
        Log.d("WorkManagerB", b.toString())
        Log.d("WorkManagerB", c.toString())

        //데이터 반환
        val output : Data = workDataOf("result" to 10)
        return Result.success(output)
    }
}
