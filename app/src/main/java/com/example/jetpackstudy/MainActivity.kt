package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


//LiveData
//라이프 사이클과 결합해 데이터를 관찰할 수 있게 해줌
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        findViewById<Button>(R.id.plus).setOnClickListener {
            viewModel.plus()
        }

        viewModel.testLiveData.observe(this, Observer {
            findViewById<TextView>(R.id.textArea).text = it.toString()
        })

//        //변화를 관찰할때마다 해당 부분이 발생
//        viewModel.testMutableLiveData.observe(this, Observer {
//            findViewById<TextView>(R.id.textArea).text = viewModel.testMutableLiveData.value.toString()
//        })
    }
}