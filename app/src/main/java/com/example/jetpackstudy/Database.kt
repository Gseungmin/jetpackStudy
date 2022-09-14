package com.example.jetpackstudy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun textDao() : DAO

    companion object {
        @Volatile
        private var INSTANCE : com.example.jetpackstudy.Database? = null

        fun getDatabase(
            context : Context
        ) : com.example.jetpackstudy.Database {
            return INSTANCE ?:synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.jetpackstudy.Database::class.java,
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