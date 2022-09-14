package com.example.jetpackstudy.dao

import androidx.room.*
import com.example.jetpackstudy.entity.Entity

//Repository 역할
@Dao
interface DAO {

    @Query("SELECT * FROM text_table")
    fun getAllData() : List<Entity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity : Entity)

    @Query("DELETE FROM text_table")
    fun deleteAll()
}