package com.example.jetpackstudy

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackstudy.db.Database
import com.example.jetpackstudy.entity.Entity
import com.example.jetpackstudy.entity.WordEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//context 사용을 위해 이렇게 사용할 수 있음
class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val db = Database.getDatabase(context)

    //코루틴을 사용하면 스레드를 사용하는데 IO 디스패처는 디스크 또는 네트워크 I/O에 최적화되어 있음, Room 사용시 최적
    //viewModel은 Dispatchers.main이므로 에러가 발생 따라서 코드 필요
    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        Log.d("MAINACTIVITY", db.textDao().getAllData().toString())
        Log.d("MAINACTIVITY", db.wordDao().getAllData().toString())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().insert(Entity(0, text))
        db.wordDao().insert(WordEntity(0, text))
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        db.textDao().deleteAll()
        db.wordDao().deleteAll()
    }


}