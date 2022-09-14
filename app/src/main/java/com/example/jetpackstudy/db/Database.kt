package com.example.jetpackstudy.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jetpackstudy.dao.DAO
import com.example.jetpackstudy.dao.WordDAO
import com.example.jetpackstudy.entity.Entity
import com.example.jetpackstudy.entity.WordEntity

@Database(entities = [Entity::class, WordEntity::class], version = 2)
abstract class Database : RoomDatabase() {

    abstract fun wordDao() : WordDAO
    abstract fun textDao() : DAO

    companion object {
        @Volatile
        private var INSTANCE : com.example.jetpackstudy.db.Database? = null

        fun getDatabase(
            context : Context
        ) : com.example.jetpackstudy.db.Database {
            return INSTANCE ?:synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.jetpackstudy.db.Database::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}