package com.example.jetpackstudy

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.jetpackstudy.db.Database
import com.example.jetpackstudy.entity.Entity
import com.example.jetpackstudy.entity.WordEntity
import com.example.jetpackstudy.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//context 사용을 위해 이렇게 사용할 수 있음
class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context = getApplication<Application>().applicationContext
    val repository = Repository(context)

    private var _textList = MutableLiveData<List<Entity>>()
    val textList : LiveData<List<Entity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList : LiveData<List<WordEntity>>
        get() = _wordList

    //코루틴을 사용하면 스레드를 사용하는데 IO 디스패처는 디스크 또는 네트워크 I/O에 최적화되어 있음, Room 사용시 최적
    //viewModel은 Dispatchers.main이므로 에러가 발생 따라서 코드 필요
    fun getData() = viewModelScope.launch(Dispatchers.IO) {
        //background에서 사용할 수 없는 문제 발생, 따라서 postValue 사용
//        _textList.value = db.textDao().getAllData()
//        _wordList.value = db.wordDao().getAllData()
        _textList.postValue(repository.getTextList())
        _wordList.postValue(repository.getWordList())
    }

    fun insertData(text: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertTextData(text)
        repository.insertWordData(text)
//        db.textDao().insert(Entity(0, text))
//        db.wordDao().insert(WordEntity(0, text))
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteTextData()
        repository.deleteWordData()
//        db.textDao().deleteAll()
//        db.wordDao().deleteAll()
    }


}