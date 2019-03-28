package com.example.todolist.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.todolist.dao.NoteDao
import com.example.todolist.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        private var Instance : AppDatabase ? = null

        fun getInstance(context: Context): AppDatabase?{
            if(Instance == null){
                synchronized(AppDatabase::class) {
                    Instance =
                        // In future delete call method allowMainThreadQueries() and get info from db from not main thread
                        Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "todolist.db").allowMainThreadQueries().build()
                }
            }
            return Instance
        }

        fun getNoteDao(context: Context): NoteDao?{
            return getInstance(context)?.getNoteDao()
        }
    }
}