package com.example.jetpackstudy.repository

import android.content.Context
import com.example.jetpackstudy.db.Database
import com.example.jetpackstudy.entity.Entity
import com.example.jetpackstudy.entity.WordEntity

class Repository(context : Context) {

    val db = Database.getDatabase(context)

    fun getTextList() = db.textDao().getAllData()

    fun getWordList() = db.wordDao().getAllData()

    fun insertTextData(text: String) = db.textDao().insert(Entity(0, text))

    fun insertWordData(text: String) = db.wordDao().insert(WordEntity(0, text))

    fun deleteTextData() = db.textDao().deleteAll()

    fun deleteWordData() = db.wordDao().deleteAll()

}