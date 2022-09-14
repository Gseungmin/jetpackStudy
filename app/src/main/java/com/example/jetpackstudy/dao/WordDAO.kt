package com.example.jetpackstudy.dao

import androidx.room.*
import com.example.jetpackstudy.entity.Entity
import com.example.jetpackstudy.entity.WordEntity

//Repository 역할
@Dao
interface WordDAO {

    @Query("SELECT * FROM word_table")
    fun getAllData() : List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity : WordEntity)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}