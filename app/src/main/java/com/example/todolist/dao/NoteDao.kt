package com.example.todolist.dao

import android.arch.persistence.room.*
import com.example.todolist.model.Note

@Dao
interface NoteDao {
    @Insert
    fun insertNotes(vararg notes: Note)

    @Delete
    fun deleteNotes(vararg notes: Note)

    @Update
    fun updateNotes(vararg notes: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes(): List<Note>
}