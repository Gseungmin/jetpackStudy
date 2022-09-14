package com.example.jetpackstudy

import androidx.room.*

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