package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.jetpackstudy.db.Database
import com.example.jetpackstudy.entity.Entity
import com.example.jetpackstudy.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Database.getDatabase(this)

        val inputArea = findViewById<EditText>(R.id.textInputArea)
        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getData)
        val deleteBtn = findViewById<Button>(R.id.delete)

        insertBtn.setOnClickListener {

            //코루틴을 사용하면 스레드를 사용하는데 IO 디스패처는 디스크 또는 네트워크 I/O에 최적화되어 있음, Room 사용시 최적
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().insert(Entity(0, inputArea.text.toString()))
                db.wordDao().insert(WordEntity(0, inputArea.text.toString()))
                inputArea.setText("")
            }
        }

        getAllBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("MAINACTIVITY", db.textDao().getAllData().toString())
                Log.d("MAINACTIVITY", db.wordDao().getAllData().toString())
            }
        }

        deleteBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.textDao().deleteAll()
                db.wordDao().deleteAll()
            }
        }
    }
}